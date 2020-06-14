package com.projettutore.covid.frame;

import javax.swing.*;

import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.panel.PanelCovid;
import com.projettutore.covid.panel.PanelSelection;


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
	private JMenu[] items;

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
    		jMenuBar = new JMenuBar();
    		jMenuBar.setVisible(false);
    		this.setJMenuBar(jMenuBar);
    	}
    		
	public void setCovidPane(Chronologie chronologie, PanelCovid contentPane){
    	getContentPane().removeAll();
    	setContentPane(contentPane);
    	setVisible(true);
    	jMenuBar.setVisible(true);
	}

	public void createMenu(){
    	items = new JMenu[3];
    	for(int i = 0 ; i < 3 ; i++){
			items[i] = new JMenu("temporaire");
		}
	}

    public static void main(String args[]) {
    	new FrameCovid("Notre foutu projet nique sa mere");
    }
}
