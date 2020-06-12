package com.projettutore.covid.panel;

import com.projettutore.covid.model.Chronologie;

import javax.swing.*;

public class PanelAffichage extends JPanel {
    private PanelDiapo panelDiapo;
    private PanelFrise panelFrise;
    private Chronologie chronologie;
    public PanelAffichage(Chronologie chronologie){
        this.chronologie = chronologie;
        panelDiapo = new PanelDiapo(chronologie);
        panelFrise = new PanelFrise();
        this.add(panelDiapo);
        this.add(panelFrise);
    }
}
