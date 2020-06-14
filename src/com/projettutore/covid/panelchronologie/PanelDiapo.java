package com.projettutore.covid.panelchronologie;

import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.model.Date;
import com.projettutore.covid.model.Event;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Classe permetant de representer les evenements sous la forme d'un diaporama.
 * @see JPanel
 */
public class PanelDiapo extends JPanel {

    /**
     * Liste de paneaux evenements
     * @see ArrayList
     */
    private ArrayList<PanelEvenement> panelEvenements;

    /**
     *
     */
    private Chronologie chronologie;
    /**
     *
     */
    private CardLayout cardLayout;
    /**
     *
     * @param chronologie
     */
    public PanelDiapo(Chronologie chronologie){
        cardLayout = new CardLayout();
        panelEvenements = new ArrayList<>();
        this.setLayout(cardLayout);
        this.chronologie = chronologie;
        TreeMap<Date, Event> dateEventTreeMap = chronologie.getTreeEvent();
        Set set = dateEventTreeMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println("cou");
            Map.Entry mapEntry = (Map.Entry)iterator.next();
            panelEvenements.add(new PanelEvenement((Event)mapEntry.getValue()));
        }
        for(int i = 0 ; i < panelEvenements.size() ; i++){
            this.add(panelEvenements.get(i));
        }
    }

}
