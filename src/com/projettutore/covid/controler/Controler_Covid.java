package com.projettutore.covid.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.projettutore.covid.exeption.ChronologieException;
import com.projettutore.covid.exeption.FormulaireExeption;
import com.projettutore.covid.managers.FileManager;
import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.panel.covid.PanelCovid;
import com.projettutore.covid.panel.covid.PanelDiapo;
import com.projettutore.covid.panel.covid.PanelNavigationEvenement;
import com.projettutore.covid.panel.selection.PanelFormulaire;
import com.projettutore.covid.panel.covid.PanelFrise;
import com.projettutore.covid.panel.selection.PanelFile;

import javax.swing.JOptionPane;


/**
 * @author Slimanitz
 * C'est la callasse Controlleur permettant de rejoindre et de gerer tous les ActionListener necessaire et les traiter ainsi
 *
 */
public class Controler_Covid implements ActionListener{
	
	private PanelCovid panelCovid;
	private PanelDiapo panelDiapo;
	private PanelFile panelFile;
	private PanelFormulaire panelFormulaire;
	private PanelFrise panelFrise;
	private PanelNavigationEvenement panelNavigationEvenement;
	private Chronologie chronologie;
	/**
	 * @param parPanelDiapo
	 * @param parPanelFrise
	 * Les parametres en questions vont servir a Lier tout les Panel Avec la classe Controleur
	 */
	public Controler_Covid (PanelDiapo parPanelDiapo , PanelFrise parPanelFrise, PanelFormulaire panelFormulaire, Chronologie chronologie) throws ChronologieException, FormulaireExeption {
		this.panelFormulaire = panelFormulaire;
		this.panelDiapo = parPanelDiapo ;
		this.panelFrise = parPanelFrise;
		this.panelDiapo.recordListener(this);
		this.chronologie = chronologie;
		/*
		panelFrise.recordListener(this);*/
		panelFormulaire.recordListener(this);
	}
	/**
	 *Ici se fera la gestion de tout les boutons et des action litener des panels initialiser precedemment
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "leftButton"){
			panelDiapo.getPanelNavigationEvenement().next();
		}
		if(e.getActionCommand() == "rightButton"){
			panelDiapo.getPanelNavigationEvenement().previous();
		}
		try {
		if (e.getActionCommand() == "addEvent") {
			chronologie.add(panelFormulaire.getEvent());
		}
	}catch (ChronologieException | FormulaireExeption fE){
		JOptionPane.showMessageDialog(null, fE);
	}

	}
		
}