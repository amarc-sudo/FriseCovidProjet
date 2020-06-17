package com.projettutore.covid.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import com.projettutore.covid.frame.FrameCovid;
import com.projettutore.covid.managers.FileManager;
import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.model.Date;
import com.projettutore.covid.panel.PanelCovid;
import com.projettutore.covid.panel.PanelCreation;
import com.projettutore.covid.panel.PanelFile;
import com.projettutore.covid.panel.PanelSelection;

/**
	 * @author Slimanitz
	 * C'est la callasse Controlleur permettant de rejoindre et de gerer tous les ActionListener necessaire et les traiter ainsi
	 *
	 */

	public class Controler_Selection implements ActionListener {

		private PanelSelection panelSelection;
		private PanelCreation panelCreation;
		private PanelFile panelFile;
		private FrameCovid frameCovid;
		
		/**
		 * @param parPanelCreation
		 * @param parPanelFile
		 * @param parPanelSelection
		 * Les parametres en questions vont servir a Lier tout les Panel Avec la classe Controleur
		 */
		public Controler_Selection (PanelSelection parPanelSelection, PanelCreation parPanelCreation, PanelFile parPanelFile, FrameCovid frameCovid) {
			panelSelection = parPanelSelection;
			panelCreation = parPanelCreation;
			panelFile = parPanelFile;
			this.frameCovid = frameCovid;
			panelCreation.recoredListener(this);
			panelFile.recordListener(this);

		}
		
		
		
		
		/**
		 *Ici se fera la gestion de tout les boutons et des action litener des panels initialiser precedemment
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand() == "load") {
				if(panelFile.getSelectedSave() != null){
					Chronologie chronologie = FileManager.load(panelFile.getSelectedSave());
					PanelCovid panelCovid = new PanelCovid(chronologie);
					frameCovid.setCovidPane(chronologie, panelCovid);
				}
			}
			if(e.getActionCommand() == "add"){
				Chronologie chronologie = panelCreation.getNewChronologie();
				if(chronologie.getStartDate().compareTo(chronologie.getEndDate()) == -1) {
					PanelCovid panelCovid = new PanelCovid(chronologie);
					FileManager.save(chronologie.getTitle(), chronologie);
					frameCovid.setCovidPane(chronologie, panelCovid);
				}
			}
			if(e.getActionCommand() == "year1"){
				panelCreation.changeDay(panelCreation.getMonth1(), panelCreation.getYear1(), true);
			}
			if(e.getActionCommand() == "year2"){
				panelCreation.changeDay(panelCreation.getMonth2(), panelCreation.getYear2(), false);
			}
			if(e.getActionCommand() == "month1"){
				panelCreation.changeDay(panelCreation.getMonth1(), panelCreation.getYear1(), true);
			}
			if(e.getActionCommand() == "month2"){
				panelCreation.changeDay(panelCreation.getMonth2(), panelCreation.getYear2(), false);
			}
		}



	}


