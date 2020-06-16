package com.projettutore.covid.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.*;

import com.projettutore.covid.controler.Controler_Selection;
import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.model.Date;

public class PanelCreation extends JPanel {
	//JBUTTON
	private JButton JB_Add = new JButton("+");
	
	//JLABELS
	private JLabel JL_Name = new JLabel("Nom de la chronologie",JLabel.CENTER);
	private JLabel JL_DateDebut = new JLabel("Date de debut",JLabel.CENTER);
	private JLabel JL_DateFin = new JLabel("Date de fin",JLabel.CENTER);
	
	//JTEXTEFIELD
	private JTextField JTF_Name = new JTextField();
	
	//JCOMBO BOX POUR LES DATES DE DEBUTS TEL QUE 1 ETANT POUR LA JCB DE LA DATE DE DEBUT
	private JComboBox<String> JCB_Year_1 = new JComboBox();
	private JComboBox<String> JCB_Month_1 = new JComboBox();
	private JComboBox<String> JCB_Day_1 = new JComboBox();
	
	//JCOMBO BOX POUR LES DATES DE DEBUTS ET 2 POUR LA JCB DE LA DATE DE FIN 
	private JComboBox<String> JCB_Year_2 = new JComboBox();
	private JComboBox<String> JCB_Month_2 = new JComboBox();
	private JComboBox<String> JCB_Day_2 = new JComboBox();
	
	private GridBagConstraints gbc = new GridBagConstraints();

	
	
	public PanelCreation() {
		String[] Year = {"2019","2020","2021"};
		String[] Month = new String[12] ;

		for(int i = 0;i<12 ; i++) {
			Month[i] = String.valueOf(i+1);
		}
		setLayout(new GridBagLayout());
		
		//LINE 0
		gbc.gridx = 3;
		gbc.gridy = 0;
	
		gbc.fill  = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10,10,10,10);
		add(JB_Add,gbc);
		JB_Add.setActionCommand("add");
		
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
		JCB_Year_1 = new JComboBox(Year);
		add(JCB_Year_1,gbc);
		JCB_Year_1.setName("year1");
		JCB_Year_1.setActionCommand("JCB_Year_1");
		gbc.gridx = 2;
		JCB_Month_1 = new JComboBox(Month);
		add(JCB_Month_1,gbc);
		JCB_Month_1.setName("month1");
		JCB_Month_1.setActionCommand("JCB_Month_1");
		JCB_Month_1.setVisible(false);
		gbc.gridx = 3;
		JCB_Day_1.setName("day1");

		//lINE 3
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(JL_DateFin,gbc);
		gbc.gridx = 1;
		JCB_Year_2 = new JComboBox(Year);
		add(JCB_Year_2,gbc);
		JCB_Year_2.setName("year2");
		JCB_Year_2.setActionCommand("JCB_Year_2");

		gbc.gridx = 2;
		JCB_Month_2 = new JComboBox(Month);
		JCB_Month_2.setVisible(false);
		add(JCB_Month_2,gbc);
		JCB_Month_2.setName("month2");
		JCB_Month_2.setActionCommand("JCB_Month_2");
		

		
		JCB_Day_2.setName(("day2"));
		
		
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

	public Chronologie getNewChronologie(){
		/*
		Date debut = new Date((int)JCB_Year_1.getSelectedItem(), (int)JCB_Month_1.getSelectedItem(), (int)JCB_Day_1.getSelectedItem());
		Date fin = new Date((int)JCB_Year_2.getSelectedItem(), (int)JCB_Month_2.getSelectedItem(), (int)JCB_Day_2.getSelectedItem());*/
		return new Chronologie(JTF_Name.getText());
	}
	public void setJCB_MonthVisible(int parint) {
		if(parint == 1) 
			JCB_Month_1.setVisible(true);
		else 
			JCB_Month_2.setVisible(true);

	}
	
	public void setJCB_DayVisible(int parMonth,int parYear,int parint) {
		if(parint == 1) {
			Date temp = new Date (11,parMonth,parYear);
			ArrayList<String> List = new ArrayList<String>();
			for(int i=0;i< temp.dayInAMonth(parMonth, parYear) ;i++){
				if(i<10) {
					List.add( "0"+String.valueOf(i+1));
		
				}
				else {
					List.add(String.valueOf(i+1));
		
				}
			
			}
			String[] Day= new String[List.size()];
			Day = List.toArray(Day);
			JCB_Day_1 = new JComboBox(Day);
			gbc.gridx = 3;
			gbc.gridy = 2;
			add(JCB_Day_1,gbc);
		}
		else {
			Date temp = new Date (11,parMonth,parYear);
			ArrayList<String> List = new ArrayList<String>();
			for(int i=0;i< temp.dayInAMonth(parMonth, parYear) ;i++){
				if(i<10) {
					List.add( "0"+String.valueOf(i+1));
		
				}
				else {
					List.add(String.valueOf(i+1));
		
				}
			
			}
			String[] Day= new String[List.size()];
			Day = List.toArray(Day);
			JCB_Day_2 = new JComboBox(Day);
			gbc.gridx = 3;
			gbc.gridy = 3;
			add(JCB_Day_2,gbc);
		}
		
	}
	
	public int getYear(int parint) {
		if(parint == 1) 
			return Integer.parseInt((String) JCB_Year_1.getSelectedItem());
		else 
			return Integer.parseInt((String) JCB_Year_2.getSelectedItem());
	}
	
	public int getMonth(int parint) {
		if(parint == 1) 
			return Integer.parseInt((String) JCB_Month_1.getSelectedItem());
		else 
			return Integer.parseInt((String) JCB_Month_2.getSelectedItem());
	}

}
