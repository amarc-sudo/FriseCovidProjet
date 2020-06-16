package com.projettutore.covid.panel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.*;

import com.projettutore.covid.controler.Controler_Covid;
import com.projettutore.covid.model.Date;
import com.projettutore.covid.model.Event;

public class PanelFormulaire extends JPanel {

		private JButton JB_Plus = new JButton("+");
		//Pour l icone du boputon pour inmporter l'image je pense a chercher une photo et mettre une ImageIcon
		
		private JButton JB_ImportPicture = new JButton("ImportPicture");

		private Date  chDate = new Date();
		private JTextField JTF_Location = new JTextField();
		private JTextField JTF_Title = new JTextField();
		private JTextArea JTA_Description = new JTextArea(5,5);
		private GridBagConstraints gbc = new GridBagConstraints(); 
		private JLabel JL_Title = new JLabel("Titre",JLabel.CENTER);
		private JLabel JL_Date = new JLabel("Date",JLabel.CENTER);
		private JLabel JL_Description = new JLabel("Description",JLabel.CENTER);
		private JLabel JL_Location = new JLabel("Lieu",JLabel.CENTER);



		private JComboBox JCB_Year ;
		private JComboBox JCB_Month ;
		private JComboBox JCB_Day ;

		
		public PanelFormulaire() {
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
		
			
			
			//YEAR
			String[] Year = {"2019","2020","2021"};
			JCB_Year = new JComboBox(Year) ;
			JCB_Year.setActionCommand("JCB_Year");
			//END YEAR 
			
			//MONTH
			for(int i = 1;i < 12;i++) {
				if(i<10) {
					List.add( "0"+String.valueOf(i));
		
				}
				else {
					List.add(String.valueOf(i));
		
				}
			}
			String[] Month = new String[List.size()];
			Month = List.toArray(Month);
			List.removeAll(List);
			JCB_Month = new JComboBox(Month);
			JCB_Month.setVisible(false);
			JCB_Month.setActionCommand("JCB_Month");
			//END MONTH
			
			//DAY
			/*for(int i = 1;i < 31;i++) {
				if(i<10) {
					List.add( "0"+String.valueOf(i));
		
				}
				else {
					List.add(String.valueOf(i));
		
				}
			}
			String[] Day= new String[List.size()];
			Day = List.toArray(Day);
			List.removeAll(List);
			JCB_Day = new JComboBox(Day);*/
			JCB_Day.setVisible(false);
			
			//END DAY
			
		
			
			
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
			
		}

		public void recordListener (Controler_Covid parControler) { 
			JB_Plus.addActionListener (parControler);
			JCB_Year.addActionListener(parControler);
			JCB_Month.addActionListener(parControler);
			JCB_Day.addActionListener(parControler);
		}
		
		public Event getEvent() {
		
			return new Event(chDate, JTF_Title.getText(), JTF_Location.getText(),JTA_Description.getText());
		}
		
		public JButton getJB_Plus() {
			return JB_Plus;
		}
		
		public void setJCB_MonthVisible() {
			JCB_Month.setVisible(true);
		}
		
		public void setJCB_DayVisible(int parMonth,int parYear) {
			Date temp = new Date (11,parMonth,parYear);
			ArrayList<String> List = new ArrayList<String>();
			for(int i=0;i< temp.dayInAMonth(parMonth, parYear) ;i++){
				if(i<10) {
					List.add( "0"+String.valueOf(i));
		
				}
				else {
					List.add(String.valueOf(i));
		
				}
			
			}
			String[] Day= new String[List.size()];
			Day = List.toArray(Day);
			JCB_Day = new JComboBox(Day);
			JCB_Day.setVisible(true);
		}
		
		public int getYear() {
			return Integer.parseInt((String) JCB_Year.getSelectedItem());
		}
		
		public int getMonth() {
			return Integer.parseInt((String) JCB_Month.getSelectedItem());
		}

	}



