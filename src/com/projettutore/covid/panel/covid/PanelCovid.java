package com.projettutore.covid.panel.covid;

import com.projettutore.covid.frame.FrameCovid;
import com.projettutore.covid.model.Chronologie;
import com.projettutore.covid.panel.selection.PanelCreation;
import com.projettutore.covid.panel.selection.PanelFormulaire;
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

    /**
     * Constructeur de base de la classe
     */
    public PanelCovid (Chronologie chronologie, FrameCovid frameCovid){
        this.chronologie = chronologie;
        cardLayout = new CardLayout();
        setLayout(cardLayout);
        this.setVisible(true);
        PanelAffichage panelAffichage = new PanelAffichage(chronologie);
        //PanelFormulaire panelFormulaire = new PanelFormulaire();
        PanelSelection panelSelection = new PanelSelection(frameCovid);
        this.add(panelAffichage, "menu2");
        this.add(panelSelection, "menu1");
        //Controler_Covid controler = new Controler_Covid(panelDiapo, panelFormulaire,panelFrise);
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

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String eventName = actionEvent.getActionCommand();
        CardLayout cardLayout = (CardLayout) this.getLayout();
        switch (eventName) {

            case "1": cardLayout.show(this, "menu1");
                break;
            case "2": cardLayout.show(this, "menu2");
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
        }
    }

}
