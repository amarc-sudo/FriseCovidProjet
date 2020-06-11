package com.projettutore.covid.panel;

import com.projettutore.covid.controler.Controler_Covid;
import com.projettutore.covid.model.Chronologie;

import javax.swing.*;
import java.awt.*;

/**
 * Panel principal de l'application, dedans ce retrouverons dans un CardLayout plusieurs panel
 * @see JPanel
 */
public class PanelCovid extends JPanel {
    /**
     * LayoutManager du panel. est navigation a travers les cards avec un JMenu
     * @see CardLayout
     * @see JMenu
     */
    private CardLayout cardLayout;
    /**
     *
     */
    private Chronologie chronologie;

    /**
     * Constructeur de base de la classe
     */
    public PanelCovid (){
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        PanelDiapo panelDiapo = new PanelDiapo();
    	PanelFrise panelFrise = new PanelFrise();
        PanelFormulaire panelFormulaire = new PanelFormulaire();
        Controler_Covid controler = new Controler_Covid(panelDiapo, panelFormulaire,panelFrise);
        
    }




    //En dessous les get et set

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public Chronologie getChronologie() {
        return chronologie;
    }

    public void setChronologie(Chronologie chronologie) {
        this.chronologie = chronologie;
    }
}
