package com.projettutore.covid.panel;

import com.projettutore.covid.controler.Controler_Selection;
import com.projettutore.covid.frame.FrameCovid;

import javax.swing.*;
import java.awt.*;

public class PanelSelection extends JPanel {
    /**
     *
     */
    private PanelCreation panelCreation;
    /**
     * Frame parent pour pouvoir changer le content pane a la selection ou création d'un fichier
     */
    private FrameCovid frameCovid;
    /**
     * Panel de selection de chronologie existante
     */
    private PanelFile panelFile;
    /**
     * Constructeur de base
     */
    private Controler_Selection controlerSelection;
    public PanelSelection(FrameCovid frameCovid){
        this.setLayout(new GridBagLayout());
        this.frameCovid = frameCovid;
        panelCreation = new PanelCreation();
        panelFile = new PanelFile();
        this.add(panelFile);
        this.add(panelCreation);
        controlerSelection = new Controler_Selection(this, panelCreation, panelFile, frameCovid);
    }
}
