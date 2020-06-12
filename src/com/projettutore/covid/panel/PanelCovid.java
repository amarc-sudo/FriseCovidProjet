package com.projettutore.covid.panel;

import com.projettutore.covid.controler.Controler;
import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.model.Date;
import com.projettutore.covid.model.Event;

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
    public PanelCovid (Chronologie chronologie){

        //test a supprimer plus tard
        chronologie = new Chronologie("test");
        chronologie.add(new Event(new Date(),"Apparation en chine", "En 2019, est apparu en chine un nouveau virus onze douze treize quatorse", "15"));
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        PanelAffichage panelAffichage = new PanelAffichage(chronologie);
        PanelFormulaire panelFormulaire = new PanelFormulaire();
        this.add(panelAffichage);
        //Controler controler = new Controler(panelDiapo, panelFormulaire,panelFrise);
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
