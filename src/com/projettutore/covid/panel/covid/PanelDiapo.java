package com.projettutore.covid.panel.covid;

import com.projettutore.covid.controler.Controler_Covid;
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
     *
     */
    private Chronologie chronologie;
    /**
     *
     */
    private BorderLayout borderLayout;
    private PanelNavigationEvenement panelNavigationEvenement;
    private JButton jButton_Left;
    private JButton jButton_right;
    private Controler_Covid controlerCovid;
    /**
     *
     * @param chronologie
     */
    public PanelDiapo(Chronologie chronologie){
        this.panelNavigationEvenement = panelNavigationEvenement;
        this.chronologie = chronologie;
        this.panelNavigationEvenement = new PanelNavigationEvenement(chronologie);
        this.borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        jButton_Left = new JButton("previous");
        jButton_right = new JButton("next");
        this.add(panelNavigationEvenement, BorderLayout.CENTER);
        this.add(jButton_Left, BorderLayout.WEST);
        this.jButton_Left.setActionCommand("leftButton");
        this.add(jButton_right, BorderLayout.EAST);
        this.jButton_right.setActionCommand("rightButton");
    }
    public PanelNavigationEvenement getPanelNavigationEvenement(){
        return panelNavigationEvenement;
    }
    public void recordListener(Controler_Covid controlerCovid){
        jButton_right.addActionListener(controlerCovid);
        jButton_Left.addActionListener(controlerCovid);
    }
}
