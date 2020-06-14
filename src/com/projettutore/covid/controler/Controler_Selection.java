package com.projettutore.covid.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.projettutore.covid.frame.FrameCovid;
import com.projettutore.covid.model.Chronologie;
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
					PanelCovid panelCovid = new PanelCovid(new Chronologie("coucou"));
					frameCovid.setCovidPane(new Chronologie("coucou"), panelCovid);

				}
			}
		}
			
		}


