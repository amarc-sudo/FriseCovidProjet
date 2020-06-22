package com.projettutore.covid.panel.affichage;

import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.model.Date;
import com.projettutore.covid.model.Event;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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


    /**
     * Panel de navigation, posède un cardLayout remplie de panelEvenement trier dans l'ordre Chronologique
     * @param chronologie
     * @see PanelEvenement
     */
    public PanelNavigationEvenement(Chronologie chronologie){
        this.chronologie = chronologie;
        cardLayout = new CardLayout();
        panelEvenements = new ArrayList<>();
        this.setLayout(cardLayout);
        HashMap<Date, Event> dateEventHashMap = chronologie.getSortHashMap();
        Set set = dateEventHashMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry mapEntry = (Map.Entry)iterator.next();
            PanelEvenement panelEvenement = new PanelEvenement((Event)mapEntry.getValue(), chronologie.getTitle());
            panelEvenements.add(panelEvenement);
            this.add(panelEvenement, ((Event)mapEntry.getValue()).getDateEvent().toString());
        }
    }

    public void refresh(){
        for(int i = 0 ; i < panelEvenements.size() ; i++)
            this.remove(panelEvenements.get(i));
        HashMap<Date, Event> dateEventHashMap = chronologie.getSortHashMap();
        Set set = dateEventHashMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry mapEntry = (Map.Entry)iterator.next();
            PanelEvenement panelEvenement = new PanelEvenement((Event)mapEntry.getValue(), chronologie.getTitle());
            panelEvenements.add(panelEvenement);
            this.add(panelEvenement);
        }
    }
    public void next(){
       cardLayout.next(this);
    }
    public void previous(){
        cardLayout.previous(this);
    }

    public void show(String cardString){
        cardLayout.show(this, cardString);
    }

}
