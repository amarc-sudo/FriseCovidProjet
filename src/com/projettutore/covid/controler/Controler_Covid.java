package com.projettutore.covid.controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import com.projettutore.covid.exeption.ChronologieException;
import com.projettutore.covid.exeption.FormulaireExeption;
import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.panel.PanelCovid;
import com.projettutore.covid.panel.affichage.PanelDiapo;
import com.projettutore.covid.panel.affichage.PanelNavigationEvenement;
import com.projettutore.covid.panel.PanelFormulaire;
import com.projettutore.covid.panel.affichage.PanelFrise;
import com.projettutore.covid.panel.selection.PanelFile;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;


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
	private Boolean changementYear;
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
		this.changementYear = false;
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
			panelDiapo.getPanelNavigationEvenement().previous();
		}
		if(e.getActionCommand() == "rightButton"){
			panelDiapo.getPanelNavigationEvenement().next();
		}
		try {
			if (e.getActionCommand() == "addEvent") {
			chronologie.add(panelFormulaire.getEvent());
			}
		}catch (ChronologieException | FormulaireExeption fE){
			JOptionPane.showMessageDialog(null, fE);
		}
		if(e.getActionCommand() == "import"){
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			jfc.addChoosableFileFilter(new FileNameExtensionFilter(".png", "png", ".jpg", "jpg"));
			jfc.addChoosableFileFilter(new FileNameExtensionFilter(".jpg", "jpg"));
			jfc.setAcceptAllFileFilterUsed(false);
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int returnValue = jfc.showOpenDialog(null);

			if(returnValue == JFileChooser.APPROVE_OPTION){
				File selected = jfc.getSelectedFile();
				panelFormulaire.getJTF_Location().setText(selected.getAbsolutePath());
			}
		}
		if(e.getActionCommand() == "year"){
			changementYear = true;
			panelFormulaire.changeMonth();
			changementYear = false;
			panelFormulaire.changeDay(panelFormulaire.getMonth(), panelFormulaire.getYear());
		}

		if(e.getActionCommand() == "month" && !changementYear){
			panelFormulaire.changeDay(panelFormulaire.getMonth(), panelFormulaire.getYear());
		}

	}
		
}