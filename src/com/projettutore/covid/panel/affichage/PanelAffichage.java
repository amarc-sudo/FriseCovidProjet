package com.projettutore.covid.panel.affichage;

import com.projettutore.covid.controler.Controler_Covid;
import com.projettutore.covid.exeption.ChronologieException;
import com.projettutore.covid.exeption.FormulaireExeption;
import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.panel.PanelCovid;

import javax.swing.*;
import java.awt.*;

/**
 * Panel qui permet d'afficher la Frise chronologie et l'evenement selectione
 */
public class PanelAffichage extends JPanel {
    private PanelDiapo panelDiapo;
    private PanelFrise panelFrise;
    private Chronologie chronologie;
    private Controler_Covid controler_covid;
    public PanelAffichage(Chronologie chronologie, PanelCovid panelCovid){
        this.chronologie = chronologie;
        this.setLayout(new GridLayout(2,1));
        panelDiapo = new PanelDiapo(chronologie);
        panelFrise = new PanelFrise(chronologie);
        this.add(panelDiapo, BorderLayout.NORTH);
        this.add(panelFrise, BorderLayout.SOUTH);
        try {
            this.controler_covid = new Controler_Covid(panelDiapo, panelFrise, panelCovid.getPanelFormulaire(), chronologie);
        } catch (ChronologieException e) {
            e.printStackTrace();
        } catch (FormulaireExeption formulaireExeption) {
            formulaireExeption.printStackTrace();
        }
    }
    public PanelDiapo getPanelDiapo(){
        return panelDiapo;
    }
}
