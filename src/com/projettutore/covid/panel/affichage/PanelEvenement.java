package com.projettutore.covid.panel.affichage;

import com.projettutore.covid.managers.FileManager;
import com.projettutore.covid.model.Date;
import com.projettutore.covid.model.Event;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PanelEvenement extends JPanel {

    /**
     *
     */
    private Event event;

    private JLabel jLabel_Description;
    private ImageIcon imageEvent;

    public PanelEvenement(Event event, String nameOfChronologie) {
        jLabel_Description = new JLabel();
        jLabel_Description.setText(event.toStringHtml());
        try {
            BufferedImage img = FileManager.loadImage(event.getPathToImg(), nameOfChronologie);
            imageEvent = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
            JLabel image = new JLabel(imageEvent);
            this.add(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.add(jLabel_Description);
        setVisible(true);
    }

    public String getTitle() {
        return event.getTitle();
    }

    public Date getDate() {
        return event.getDateEvent();
    }
}
