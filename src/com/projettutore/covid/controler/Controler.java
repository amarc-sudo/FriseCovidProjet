package com.projettutore.covid.controler;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.projettutore.covid.panel.*;



/**
 * @author Slimanitz
 * C'est la callasse Controlleur permettant de rejoindre et de gerer tous les ActionListener necessaire et les traiter ainsi
 *
 */
public class Controler implements ActionListener{
	
	private PanelCovid panelCovid;
	private PanelDiapo panelDiapo;
	private PanelFile panelFile;
	private PanelFrise panelFrise;
	
	
	/**
	 * @param parPanelDiapo
	 * @param parPanelFrise
	 * @param parPanelFormulaire
	 * Les parametres en questions vont servir a Lier tout les Panel Avec la classe Controleur
	 */
	public Controler (PanelDiapo parPanelDiapo , PanelFormulaire parPanelFormulaire, PanelFrise parPanelFrise) {
		panelDiapo = parPanelDiapo ;
		panelFrise = parPanelFrise;
		/*
		panelCovid.recordeListener(this);
		panelDiapo.recordListener(this);
		panelFile.recordListener(this);
		panelFrise.recordListener(this);*/

	
		
	}
	
	
	
	
	/**
	 *Ici se fera la gestion de tout les boutons et des action litener des panels initialiser precedemment
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
		
	}