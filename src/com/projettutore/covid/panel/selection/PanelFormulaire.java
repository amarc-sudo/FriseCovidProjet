package com.projettutore.covid.panel.selection;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

import com.projettutore.covid.controler.Controler_Covid;
import com.projettutore.covid.controler.Controler_Selection;
import com.projettutore.covid.exeption.FormulaireExeption;
import com.projettutore.covid.managers.FileManager;
import com.projettutore.covid.managers.PropertiesManager;
import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.model.Date;
import com.projettutore.covid.model.Event;

public class PanelFormulaire extends JPanel {

	private JButton JB_Plus = new JButton("+");
	private JButton JB_end = new JButton(("end"));
	//Pour l icone du boputon pour inmporter l'image je pense a chercher une photo et mettre une ImageIcon
	private JButton JB_ImportPicture = new JButton("ImportPicture");
	private JTextField JTF_Location = new JTextField(15);
	private JTextField JTF_Title = new JTextField(15);
	/**
	 *
	 */
	private JTextArea JTA_Description = new JTextArea(5,5);
	private GridBagConstraints gbc = new GridBagConstraints();
	private JLabel JL_Title = new JLabel("Titre",JLabel.CENTER);
	private JLabel JL_Date = new JLabel("Date",JLabel.CENTER);
	private JLabel JL_Description = new JLabel("Description",JLabel.CENTER);
	private JLabel JL_Location = new JLabel("Lieu",JLabel.CENTER);
	private JLabel JL_Poid = new JLabel("Poid",JLabel.CENTER);
	private Controler_Selection controlerSelectionFormulaire;

	private JComboBox JCB_Year ;
	private JComboBox JCB_Month ;
	private JComboBox JCB_Day ;

	private JComboBox<Integer> JCB_poid;

	private Chronologie chronologie;
		
	public PanelFormulaire(Chronologie chronologie) {
		this.chronologie = chronologie;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gbc.anchor = GridBagConstraints.CENTER;
		setLayout(gridBagLayout);
		//gbc.fill = GridBagConstraints.VERTICAL;

		//LIGNE 0
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.fill  = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10,10,10,10);
		add(JB_ImportPicture,gbc);
		JB_ImportPicture.setActionCommand("import");

		JB_Plus.setBackground(new Color (808080));
		gbc.gridx = 3;
		JB_Plus.setActionCommand("+");
		add(JB_Plus,gbc);
		//FIN DE LA LIGNE 0
			
		//LIGNE 1
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(JL_Title,gbc);
		gbc.gridx = 1;
		gbc.gridwidth = 3;
		add(JTF_Title,gbc);
		//FIN DE LA LIGNE 1
			
		//LIGNE 2
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		add(JL_Location,gbc);
		gbc.gridx = 1;
		gbc.gridwidth = 3;
		add(JTF_Location,gbc);
		JTF_Location.setMaximumSize(JTF_Location.getPreferredSize());
		JTF_Location.setEditable(false);
		//FIN DE LA LIGNE 2
			
		//LIGNE 3
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		add(JL_Date,gbc);
		ArrayList<String> List = new ArrayList<String>();

		createYearMonthDay();
		gbc.gridx = 1;
		add(JCB_Year,gbc);
		gbc.gridx = 2;
		add(JCB_Month,gbc);
		gbc.gridx = 3;
		add(JCB_Day,gbc);
		//FIN DE LA LIGNE 3

		//DEBUT LIGNE 4
		gbc.gridx = 0;
		//FIN DE LA LIGNE 4

		//DEBUT LIGNE 5
		gbc.gridx = 0;
		gbc.gridy = 4;
		add(JL_Description,gbc);
		gbc.gridx = 1;
		gbc.gridwidth = 3;
		JScrollPane sp_description = new JScrollPane(JTA_Description);
		add(sp_description,gbc);
		//FIN DE LA LIGNE 5

		//debut ligne 6
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth =1;
		this.add(JL_Poid, gbc);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth =3;
		Integer[] poidValues = {1,2,3,4,5};
		JCB_poid = new JComboBox<Integer>(poidValues);
		this.add(JCB_poid, gbc);


		//debut nommage event
		JB_Plus.setActionCommand("addEvent");
	}

	public void recordListener (Controler_Covid parControler) {
		JB_Plus.addActionListener(parControler);
		JB_end.addActionListener(parControler);
		JB_ImportPicture.addActionListener(parControler);
	}

	public Event getEvent() throws FormulaireExeption {
		if(JTF_Location.getText().isEmpty()){
			throw new FormulaireExeption(PropertiesManager.getElement("messagebugPathImg"));
		}
		else if(JTF_Title.getText().isEmpty()){
			throw new FormulaireExeption(PropertiesManager.getElement("messagebugTitre"));
		}
		else if(JTA_Description.getText().isEmpty()){
			throw new FormulaireExeption(PropertiesManager.getElement("messagebugDescrition"));
		}
		else {
			File img = new File(JTF_Location.getText());
			FileManager.copier(img, chronologie.getTitle());
			Event event = new Event(new Date((int) JCB_Day.getSelectedItem(), (int) JCB_Month.getSelectedItem(), (int) JCB_Year.getSelectedItem()), JTF_Title.getText(), JTA_Description.getText(), img.getName(), (int) JCB_poid.getSelectedItem());
			return event;
		}
	}

	public void createYearMonthDay() {
		JCB_Year = new JComboBox();
		JCB_Month = new JComboBox();
		JCB_Day = new JComboBox();
		for(int i = chronologie.getStartDate().getYear() ; i <= chronologie.getEndDate().getYear() ; i++){
			JCB_Year.addItem(i);
		}
		JCB_Year.setSelectedIndex(1);
		for(int i = 1 ; i < 13 ; i++){
			JCB_Month.addItem(i);
		}
		for(int i = 1 ; i < 32 ; i++){
			JCB_Day.addItem(i);
		}
		JCB_Day.setActionCommand("day");
		JCB_Month.setActionCommand("month");
		JCB_Year.setActionCommand("year");
	}

	public void changeDay(int month, int year){
		JCB_Day.removeAllItems();
		for(int i = 1 ; i <= Date.dayInAMonth(month, year); i++){
			System.out.println(i);
			JCB_Day.addItem(i);
		}
	}

	public JButton getJB_Plus() {
			return JB_Plus;
		}
	public int getMonth(){
		return (int)JCB_Month.getSelectedItem();
	}
	public int getYear(){
		return (int)JCB_Year.getSelectedItem();
	}
	public JTextField getJTF_Location(){
		return JTF_Location;
	}
	}



