package com.projettutore.covid.model;

import java.io.Serializable;

/**
 * Classe représentant un evenement
 * @see java.lang.Comparable
 * @see java.io.Serializable
 */
public class Event implements Comparable<Event>, Serializable {
    private Date dateEvent;
    private String title;
    private String description;
    private String pathToImg;

    public Event(Date dateEvent, String title, String description, String pathToImg) {
        this.dateEvent = dateEvent;
        this.title = title;
        this.description = description;
        this.pathToImg = pathToImg;
    }

    @Override
    public int compareTo(Event event) {
        return 0;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPathToImg() {
        return pathToImg;
    }
}
