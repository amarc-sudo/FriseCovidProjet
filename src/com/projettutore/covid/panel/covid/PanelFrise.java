package com.projettutore.covid.panel.covid;

import com.projettutore.covid.model.Chronologie;

import javax.swing.*;

public class PanelFrise extends JPanel {
    private JTable jTable_Chronologie;
    private Chronologie chronologie;

    public PanelFrise(Chronologie chronologie){
        this.chronologie = chronologie;
        jTable_Chronologie = new JTable();
        this.add(jTable_Chronologie);
    }

}
