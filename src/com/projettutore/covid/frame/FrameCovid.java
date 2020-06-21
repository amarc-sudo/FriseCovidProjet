package com.projettutore.covid.frame;

import javax.swing.*;

import com.projettutore.covid.managers.PropertiesManager;
import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.panel.PanelCovid;
import com.projettutore.covid.panel.selection.PanelSelection;

import java.awt.*;


/**
 * Classe Principal de l'application, Derive de JFrame elle est la frame principal de l'application.
 */
public class FrameCovid extends JFrame {
	/**
	 * menu pour naviguer
	 */
	private JMenuBar jMenuBar;
	/**
	 * Item du Menu
	 */
	private JMenuItem[] items;

	/**
	 *
	 * @param parTitre
	 */
    public  FrameCovid(String parTitre){
    	super(parTitre);
    	PanelSelection contentPane = new PanelSelection(this);
    	//PanelCovid contentPane = new PanelCovid(new Chronologie("test"));
    	setContentPane(contentPane);
    	setSize(1000,600);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setLocation(200,200);
    }
    		
	public void setCovidPane(Chronologie chronologie, PanelCovid contentPane){
		jMenuBar = new JMenuBar();
    	getContentPane().removeAll();
    	setContentPane(contentPane);
		createMenu(contentPane);
		jMenuBar.setMaximumSize(jMenuBar.getPreferredSize());
		this.setJMenuBar(jMenuBar);
    	setVisible(true);
    	jMenuBar.setVisible(true);
	}

	public void createMenu(PanelCovid contentPane){
    	items = new JMenuItem[4];
    	String name = "";
    	for(int i = 0 ; i < 4 ; i++){
			name = "menu" + (i+1);
			items[i] = new JMenuItem(PropertiesManager.getElement(name));
			items[i].setActionCommand(""+(i+1));
			items[i].addActionListener(contentPane);
			items[i].setMaximumSize(new Dimension(items[i].getPreferredSize().width , items[i].getMaximumSize().height));
			jMenuBar.add(items[i]);
		}
	}

    public static void main(String args[]) {
		PropertiesManager.create();
    	new FrameCovid(PropertiesManager.getElement("titre"));
    }
}
