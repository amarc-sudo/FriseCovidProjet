package com.projettutore.covid.panelchronologie;

import com.projettutore.covid.model.Date;
import com.projettutore.covid.model.Event;

import javax.swing.*;

public class PanelEvenement extends JPanel {

    /**
     *
     */
    private Event event;

    private JLabel jLabel_Description;

    public PanelEvenement(Event event){
        jLabel_Description = new JLabel();
        jLabel_Description.setText(event.toStringHtml());
        this.add(jLabel_Description);
        setVisible(true);
    }

    public String getTitle(){
        return event.getTitle();
    }
    public Date getDate(){
        return event.getDateEvent();
    }

}
