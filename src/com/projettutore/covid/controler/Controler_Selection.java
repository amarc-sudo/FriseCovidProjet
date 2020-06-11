package com.projettutore.covid.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.projettutore.covid.panel.PanelCovid;
import com.projettutore.covid.panel.PanelCreation;
import com.projettutore.covid.panel.PanelDiapo;
import com.projettutore.covid.panel.PanelFile;
import com.projettutore.covid.panel.PanelFormulaire;
import com.projettutore.covid.panel.PanelFrise;
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
		
		
		/**
		 * @param parPanelDiapo
		 * @param parPanelFrise
		 * @param parPanelFormulaire
		 * Les parametres en questions vont servir a Lier tout les Panel Avec la classe Controleur
		 */
		public Controler_Selection (PanelSelection parPanelSelection, PanelCreation parPanelCreation, PanelFile parPanelFile) {
			panelSelection = parPanelSelection;
			panelCreation = parPanelCreation;
			panelFile = parPanelFile;
			
			panelCreation.recoredListener(this);
			panelFile.recordListener(this);
			
		
			
		}
		
		
		
		
		/**
		 *Ici se fera la gestion de tout les boutons et des action litener des panels initialiser precedemment
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
			
		}


