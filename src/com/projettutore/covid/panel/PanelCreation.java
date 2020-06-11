package com.projettutore.covid.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import com.projettutore.covid.controler.Controler_Selection;

public class PanelCreation extends JPanel {
	//JBUTTON
	private JButton JB_Add = new JButton("+");
	
	//JLABELS
	private JLabel JL_Name = new JLabel("Nom de la chronologie",JLabel.CENTER);
	private JLabel JL_DateDebut = new JLabel("Date de début",JLabel.CENTER);
	private JLabel JL_DateFin = new JLabel("Date de fin",JLabel.CENTER);
	
	//JTEXTEFIELD
	private JTextField JTF_Name = new JTextField();
	
	//JCOMBO BOX POUR LES DATES DE DEBUTS TEL QUE 1 ETANT POUR LA JCB DE LA DATE DE DEBUT
	private JComboBox JCB_Year_1 = new JComboBox();
	private JComboBox JCB_Month_1 = new JComboBox();
	private JComboBox JCB_Day_1 = new JComboBox();
	
	//JCOMBO BOX POUR LES DATES DE DEBUTS ET 2 POUR LA JCB DE LA DATE DE FIN 
	private JComboBox JCB_Year_2 = new JComboBox();
	private JComboBox JCB_Month_2 = new JComboBox();
	private JComboBox JCB_Day_2 = new JComboBox();
	
	private GridBagConstraints gbc = new GridBagConstraints();
	
	
	public PanelCreation() {
		setLayout(new GridBagLayout());
		
		//LINE 0
		gbc.gridx = 3;
		gbc.gridy = 0;
	
		gbc.fill  = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10,10,10,10);
		add(JB_Add,gbc);
		
		//LINE 1
		gbc.gridx = 0;
		gbc.gridy = 1;
		
		add(JL_Name,gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = 3;
		add(JTF_Name,gbc);
		gbc.gridwidth = 1;
		
		//lINE 2
		gbc.gridx = 0;
		gbc.gridy = 2;
		add(JL_DateDebut,gbc);
		
		gbc.gridx = 1;
		add(JCB_Year_1,gbc);
		
		gbc.gridx = 2;
		add(JCB_Month_1,gbc);
		
		gbc.gridx = 3;
		add(JCB_Day_1,gbc);
		
		//lINE 3
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(JL_DateFin,gbc);
		
		gbc.gridx = 1;
		add(JCB_Year_2,gbc);
				
		gbc.gridx = 2;
		add(JCB_Month_2,gbc);
				
		gbc.gridx = 3;
		add(JCB_Day_2,gbc);
		
		
		
	}
	
	
	public void recoredListener(Controler_Selection parControler) {
		JCB_Year_1.addActionListener(parControler);
		JCB_Month_1.addActionListener(parControler);
		JCB_Day_1.addActionListener(parControler);
		
		JCB_Year_2.addActionListener(parControler);
		JCB_Month_2.addActionListener(parControler);
		JCB_Day_2.addActionListener(parControler);
		
		JB_Add.addActionListener(parControler);
	}

}
