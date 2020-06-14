package com.projettutore.covid.panel;

import com.projettutore.covid.controler.Controler_Selection;
import com.projettutore.covid.managers.FileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Panel qui gere le fichiers, le premier a ce lancer, reste a l'avant jusqu'a la selection d'un fichier
 */
public class PanelFile extends JPanel {

    /**
     * Liste des Chronologie selectionable
     */
    private JList<String> JList_Chronologie;
    /**
     * Liste chainé de String remplie des noms des sauvegardes
     * @see FileManager#chronologieListe()
     */
    private ArrayList<String> listSave;
    /**
     * Model de list
     */
    private DefaultListModel listModelChronologie;
    /**
     * Bouton pour charger une save
     */
    private JButton buttonLoad;

    public PanelFile(){
        //debut initialisation de la liste
        this.setLayout(new BorderLayout());
        listModelChronologie = new DefaultListModel();
        listSave = FileManager.chronologieListe();
        String save;
        for(int i = 0; i < listSave.size() ; i++){
            listModelChronologie.addElement(listSave.get(i));
        }

        JList_Chronologie = new JList<String>(listModelChronologie);
        JList_Chronologie.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(JList_Chronologie);
        this.add(listScrollPane, BorderLayout.CENTER);
        //fin initialisation de la liste
        //debut initialisation des boutons
        buttonLoad = new JButton("charger");
        buttonLoad.setActionCommand("load");
        this.add(buttonLoad, BorderLayout.SOUTH);
        //fin initialisation des boutons
    }
    
    
    public void  recordListener(Controler_Selection parControler) {
    	buttonLoad.addActionListener(parControler);
    }

    public String getSelectedSave(){
        return JList_Chronologie.getSelectedValue();
    }
}
