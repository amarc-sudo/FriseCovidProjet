package com.projettutore.covid.panel.covid;

import com.projettutore.covid.controler.Controler_Covid;
import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.model.Date;
import com.projettutore.covid.model.Event;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JPanel;

/**
 * Panel qui sert a la navigation entre les fichiers, est composé d'une arrayList de panel evenement trier dans l'ordre chronologique, on peut naviguer entre les evenements avec les methodes next et previous.
 * @see PanelNavigationEvenement#previous()
 * @see PanelNavigationEvenement#next()
 * @see PanelEvenement
 */
public class PanelNavigationEvenement extends JPanel {
    private Chronologie chronologie;
    private CardLayout cardLayout;
    private  ArrayList<PanelEvenement> panelEvenements;

    public PanelNavigationEvenement(Chronologie chronologie){
        this.chronologie = chronologie;
        cardLayout = new CardLayout();
        panelEvenements = new ArrayList<>();
        this.setLayout(cardLayout);
        TreeMap<Date, Event> dateEventTreeMap = chronologie.getTreeEvent();
        Set set = dateEventTreeMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry mapEntry = (Map.Entry)iterator.next();
            PanelEvenement panelEvenement = new PanelEvenement((Event)mapEntry.getValue());
            panelEvenements.add(panelEvenement);
        }
        for(int i = 0 ; i < panelEvenements.size() ; i++){
            this.add(panelEvenements.get(i));
        }
    }
    public void refresh(){
        for(int i = 0 ; i < panelEvenements.size() ; i++)
            this.remove(panelEvenements.get(i));
        TreeMap<Date, Event> dateEventTreeMap = chronologie.getTreeEvent();
        Set set = dateEventTreeMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry mapEntry = (Map.Entry)iterator.next();
            PanelEvenement panelEvenement = new PanelEvenement((Event)mapEntry.getValue());
            panelEvenements.add(panelEvenement);
        }
        for(int i = 0 ; i < panelEvenements.size() ; i++){
            this.add(panelEvenements.get(i));
        }
    }
    public void next(){
        refresh();
        cardLayout.next(this);
    }
    public void previous(){
        refresh();
        cardLayout.previous(this);
    }

}
