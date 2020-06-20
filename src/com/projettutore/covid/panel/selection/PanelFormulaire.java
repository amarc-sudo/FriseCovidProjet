package com.projettutore.covid.panel.selection;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.*;

import com.projettutore.covid.controler.Controler_Covid;
import com.projettutore.covid.controler.Controler_Selection;
import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.model.Date;
import com.projettutore.covid.model.Event;

public class PanelFormulaire extends JPanel {

	private JButton JB_Plus = new JButton("+");
	private JButton JB_end = new JButton(("end"));
	//Pour l icone du boputon pour inmporter l'image je pense a chercher une photo et mettre une ImageIcon
	private JButton JB_ImportPicture = new JButton("ImportPicture");
	private Date  chDate = new Date();
	private JTextField JTF_Location = new JTextField();private JTextField JTF_Title = new JTextField();
	/**
	 *
	 */
	private JTextField JTF_PathImg = new JTextField();
	private JTextArea JTA_Description = new JTextArea(5,5);
	private GridBagConstraints gbc = new GridBagConstraints();
	private JLabel JL_Title = new JLabel("Titre",JLabel.CENTER);
	private JLabel JL_Date = new JLabel("Date",JLabel.CENTER);
	private JLabel JL_Description = new JLabel("Description",JLabel.CENTER);
	private JLabel JL_Location = new JLabel("Lieu",JLabel.CENTER);

	private PanelSelection panelSelectionFormulaire;

	private JComboBox JCB_Year ;
	private JComboBox JCB_Month ;
	private JComboBox JCB_Day ;

	private Chronologie chronologie;
		
	public PanelFormulaire(Chronologie chronologie) {
		this.chronologie = chronologie;
		setLayout(new GridBagLayout());

		//LIGNE 0
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		gbc.fill  = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10,10,10,10);
		add(JB_ImportPicture,gbc);
			
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
		add(JTA_Description,gbc);
		//FIN DE LA LIGNE 5

		//debut ligne 6
		gbc.gridx = 0;
		gbc.gridy = 6;
		gbc.gridwidth = 3;
		this.add(JB_end, gbc);
		//FIN LIGNE 6
		//debut nommage event
		JB_end.setActionCommand("endEvent");
		JB_Plus.setActionCommand("addEvent");
		this.setBackground(Color.BLACK);
		panelSelectionFormulaire = new PanelSelection(this);
		}

		public void recordListener (Controler_Selection parControler) {
			JB_Plus.addActionListener(parControler);
			JB_end.addActionListener(parControler);
		}
		
		public Event getEvent() {
			return new Event(new Date((int)JCB_Day.getSelectedItem(), (int)JCB_Month.getSelectedItem(), (int)JCB_Year.getSelectedItem()), JTF_Title.getText(), JTA_Description.getText(),JTF_Location.getText());
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
	}



