package com.projettutore.covid.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.projettutore.covid.frame.FrameCovid;
import com.projettutore.covid.managers.FileManager;
import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.panel.covid.PanelCovid;
import com.projettutore.covid.panel.selection.PanelCreation;
import com.projettutore.covid.panel.selection.PanelFile;
import com.projettutore.covid.panel.selection.PanelFormulaire;
import com.projettutore.covid.panel.selection.PanelSelection;

/**
	 * @author Slimanitz
	 * C'est la callasse Controlleur permettant de rejoindre et de gerer tous les ActionListener necessaire et les traiter ainsi
	 *
	 */

	public class Controler_Selection implements ActionListener {

		private PanelSelection panelSelection;
		private PanelCreation panelCreation;
		private PanelFile panelFile;
		private PanelFormulaire panelFormulaire;
		private FrameCovid frameCovid;
		private Chronologie chronologie;
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
		public Controler_Selection(PanelFormulaire panelFormulaire){
			this.panelFormulaire = panelFormulaire;
			panelFormulaire.recordListener(this);
		}
		
		
		
		
		/**
		 *Ici se fera la gestion de tout les boutons et des action litener des panels initialiser precedemment
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand() == "load") {
				if(panelFile.getSelectedSave() != null){
					chronologie = FileManager.load(panelFile.getSelectedSave());
					PanelCovid panelCovid = new PanelCovid(chronologie, frameCovid);
					frameCovid.setCovidPane(chronologie, panelCovid);
				}
			}
			if(e.getActionCommand() == "add"){
				chronologie = panelCreation.getNewChronologie();
				panelSelection.removeAll();
				frameCovid.getContentPane().removeAll();
				panelFormulaire = new PanelFormulaire(chronologie);
				panelFormulaire.recordListener(this);
				panelSelection.add(panelFormulaire);
				panelFormulaire.setVisible(true);
				frameCovid.setContentPane(panelSelection);
			}
			if(e.getActionCommand() == "addEvent"){
				chronologie.add(panelFormulaire.getEvent());
			}
			if(e.getActionCommand() == "endEvent"){
				PanelCovid panelCovid = new PanelCovid(chronologie, frameCovid);
				FileManager.save(chronologie.getTitle(), chronologie);
				frameCovid.setCovidPane(chronologie, panelCovid);
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
			if(e.getActionCommand() == "year"){
				panelFormulaire.changeDay(panelFormulaire.getMonth(), panelFormulaire.getYear());
			}
			if(e.getActionCommand() == "month"){
				panelFormulaire.changeDay(panelFormulaire.getMonth(), panelFormulaire.getYear());
			}
		}



	}


