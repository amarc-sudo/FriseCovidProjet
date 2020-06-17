package com.projettutore.covid.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import com.projettutore.covid.controler.Controler_Selection;
import com.projettutore.covid.managers.PropertiesManager;
import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.model.Date;

public class PanelCreation extends JPanel {
	//JBUTTON
	private JButton JB_Add = new JButton("+");
	
	//JLABELS
	private JLabel JL_Name = new JLabel(PropertiesManager.getElement("nameChronologie"),JLabel.CENTER);
	private JLabel JL_DateDebut = new JLabel(PropertiesManager.getElement("dateBegin"),JLabel.CENTER);
	private JLabel JL_DateFin = new JLabel(PropertiesManager.getElement("dateEnd"),JLabel.CENTER);
	
	//JTEXTEFIELD
	private JTextField JTF_Name = new JTextField();
	
	//JCOMBO BOX POUR LES DATES DE DEBUTS TEL QUE 1 ETANT POUR LA JCB DE LA DATE DE DEBUT
	private JComboBox<Integer> JCB_Year_1 = new JComboBox();
	private JComboBox<Integer> JCB_Month_1 = new JComboBox();
	private JComboBox<Integer> JCB_Day_1 = new JComboBox();
	
	//JCOMBO BOX POUR LES DATES DE DEBUTS ET 2 POUR LA JCB DE LA DATE DE FIN 
	private JComboBox<Integer> JCB_Year_2 = new JComboBox();
	private JComboBox<Integer> JCB_Month_2 = new JComboBox();
	private JComboBox<Integer> JCB_Day_2 = new JComboBox();
	
	private GridBagConstraints gbc = new GridBagConstraints();
	
	
	public PanelCreation() {
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

		createYearMonthDay();

		gbc.gridx = 1;
		add(JCB_Year_1,gbc);
		JCB_Year_1.setName("year1");
		JCB_Year_1.setActionCommand("year1");
		gbc.gridx = 2;
		add(JCB_Month_1,gbc);
		JCB_Month_1.setName("month1");
		JCB_Month_1.setActionCommand("month1");
		gbc.gridx = 3;
		add(JCB_Day_1,gbc);
		JCB_Day_1.setName("day1");
		JCB_Day_1.setActionCommand("day1");
		//lINE 3
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(JL_DateFin,gbc);
		
		gbc.gridx = 1;
		add(JCB_Year_2,gbc);
		JCB_Year_2.setName("year2");
		JCB_Year_2.setActionCommand("year2");
		gbc.gridx = 2;
		add(JCB_Month_2,gbc);
		JCB_Month_2.setName("month2");
		JCB_Month_2.setActionCommand("month2");
		gbc.gridx = 3;
		add(JCB_Day_2,gbc);
		JCB_Day_2.setName(("day2"));
		JCB_Day_2.setName("day2");
		
		
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

		Date debut = new Date((int)JCB_Year_1.getSelectedItem(), (int)JCB_Month_1.getSelectedItem(), (int)JCB_Day_1.getSelectedItem());
		Date fin = new Date((int)JCB_Year_2.getSelectedItem(), (int)JCB_Month_2.getSelectedItem(), (int)JCB_Day_2.getSelectedItem());
		return new Chronologie(JTF_Name.getText(), debut, fin);
	}

	public void createYearMonthDay() {
		for(int i = 1900 ; i <= 2050 ; i++){
			JCB_Year_1.addItem(i);
			JCB_Year_2.addItem(i);
		}
		JCB_Year_1.setSelectedIndex(100);
		JCB_Year_2.setSelectedIndex(110);
		for(int i = 1 ; i < 13 ; i++){
			JCB_Month_1.addItem(i);
			JCB_Month_2.addItem(i);
		}
		for(int i = 1 ; i < 32 ; i++){
			JCB_Day_1.addItem(i);
			JCB_Day_2.addItem(i);
		}
	}
	public void changeDay(int month, int year, boolean jComboBox){
		if(jComboBox){
			System.out.println(month);
			JCB_Day_1.removeAllItems();
			for(int i = 1 ; i <= Date.dayInAMonth(month, year); i++){
				System.out.println(i);
				JCB_Day_1.addItem(i);
			}
		}
		else{
			JCB_Day_2 = new JComboBox<>();
			for(int i = 1 ; i <= Date.dayInAMonth(month, year); i++){
				JCB_Day_2.addItem(i);
			}
		}
	}

	public int getDay1(){
		return (int)JCB_Day_1.getSelectedItem();
	}
	public int getDay2(){
		return (int)JCB_Day_2.getSelectedItem();
	}
	public int getMonth1(){
		return (int)JCB_Month_1.getSelectedItem();
	}
	public int getMonth2(){
		return (int)JCB_Month_2.getSelectedItem();
	}
	public int getYear1(){
		return (int)JCB_Year_1.getSelectedItem();
	}
	public int getYear2(){
		return (int)JCB_Year_2.getSelectedItem();
	}

}
