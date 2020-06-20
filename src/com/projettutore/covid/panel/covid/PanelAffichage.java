package com.projettutore.covid.panel.covid;

import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.model.Date;
import com.projettutore.covid.model.Event;

import javax.swing.*;
import java.awt.*;

/**
 * Panel qui permet d'afficher la Frise chronologie et l'evenement selectione
 *
 */
public class PanelAffichage extends JPanel {
    private PanelDiapo panelDiapo;
    private PanelFrise panelFrise;
    private Chronologie chronologie;
    public PanelAffichage(Chronologie chronologie){
        this.chronologie = chronologie;
        this.setLayout(new BorderLayout());
        chronologie.add(new Event(new Date(22,12,2005), "coucou", "coucou", "coucou"));
        panelDiapo = new PanelDiapo(chronologie);
        panelFrise = new PanelFrise();
        this.add(panelDiapo, BorderLayout.NORTH);
        this.add(panelFrise, BorderLayout.SOUTH);
    }
}
