package com.projettutore.covid.frame;

import javax.swing.*;

import com.projettutore.covid.panel.PanelCovid;
import com.projettutore.covid.panel.PanelSelection;


/**
 * Classe Principal de l'application, Derive de JFrame elle est la frame principal de l'application.
 */
public class FrameCovid extends JFrame {

    public  FrameCovid(String parTitre){
    		super(parTitre);
    		PanelSelection contentPane = new PanelSelection(this);
    		setContentPane(contentPane);
    		setSize(1000,600);
    		setVisible(true);
    		setDefaultCloseOperation(EXIT_ON_CLOSE);
    		setLocation(200,200);
    	}
    		

    

    public static void main(String args[]) {
    	new FrameCovid("Notre foutu projet nique sa mere");
    }
}
