package com.projettutore.covid.panel;

import com.projettutore.covid.frame.FrameCovid;
import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.panel.affichage.PanelAffichage;
import com.projettutore.covid.panel.selection.PanelSelection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel principal de l'application, dedans ce retrouverons dans un CardLayout plusieurs panel
 * @see JPanel
 */
public class PanelCovid extends JPanel implements ActionListener {
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

    PanelAffichage panelAffichage ;
    PanelFormulaire panelFormulaire ;
    PanelSelection panelSelection;

    /**
     * Constructeur de base de la classe
     */
    public PanelCovid (Chronologie chronologie, FrameCovid frameCovid){
        this.chronologie = chronologie;
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        this.setVisible(true);
        panelFormulaire = new PanelFormulaire(chronologie);
        panelAffichage = new PanelAffichage(chronologie, this);
        panelSelection = new PanelSelection(frameCovid);
        this.add(panelAffichage, "menu2");
        this.add(panelSelection, "menu1");
        this.add(panelFormulaire, "menu4");
        //this.setBackground(Color.WHITE);
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

    public PanelFormulaire getPanelFormulaire(){
        return panelFormulaire;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String eventName = actionEvent.getActionCommand();
        CardLayout cardLayout = (CardLayout) this.getLayout();
        switch (eventName) {

            case "1": cardLayout.show(this, "menu1");
                break;
            case "2":
                panelAffichage.getPanelDiapo().getPanelNavigationEvenement().refresh();
                cardLayout.show(this, "menu2");
                break;
            case "3": int saisi = JOptionPane.showConfirmDialog (
                    this,
                    "Êtes-vous sûr de votre choix ?",
                    "Exit",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );
                switch (saisi) {
                    case JOptionPane.CLOSED_OPTION:
                    case JOptionPane.OK_OPTION:
                        System.exit(0);break;
                    case JOptionPane.CANCEL_OPTION:

                }
            case "4": cardLayout.show(this, "menu4");
        }
    }

}
