package com.projettutore.covid.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.StringTokenizer;

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
        if(dateEvent.compareTo(event.getDateEvent()) == 1)
            return 1;
        else if (dateEvent.compareTo(event.getDateEvent()) == -1){
            return -1;
        }
        else{
            return 0;
        }
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("coucou");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return dateEvent.equals(event.dateEvent);
    }

    @Override
    public int hashCode() {
        System.out.println("coucou");
        return Objects.hash(dateEvent);
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

    public String toStringHtml(){
        String returnStatement;
        returnStatement = "<html>" +
                "<h4><i>"+dateEvent.toString()+"</i></h4>" +
                "<h3>"+title+"</h3>";
        String descriptionHtml = "";
        if(description != "") {
            StringTokenizer st = new StringTokenizer(description);
            int i = 0;
            while (st.hasMoreTokens() && i < 12) {
                descriptionHtml += st.nextToken() + " ";
                System.out.println(i);
                if(i == 11){
                    descriptionHtml+=" <br> ";
                    i=0;
                }
                i++;
            }
        }
        returnStatement += " " + descriptionHtml;
        return returnStatement;
    }

}
