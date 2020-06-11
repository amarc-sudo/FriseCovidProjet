package com.projettutore.covid.panel;

import com.projettutore.covid.frame.FrameCovid;

import javax.swing.*;

public class PanelSelection extends JPanel {
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
    public PanelSelection(FrameCovid frameCovid){
        this.frameCovid = frameCovid;
        panelFile = new PanelFile();
        this.add(panelFile);
    }
}
