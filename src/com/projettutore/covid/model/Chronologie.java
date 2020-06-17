package com.projettutore.covid.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @see java.io.Serializable
 * @see Event
 */
public class Chronologie implements Serializable {
	private Date startDate;
	private Date endDate;
    private HashMap<Date, Event> chronologieHashMap;
    private String titleChronologie;

    /**
     *  Constructeur d'une chronologie avec une durée d'un ans a partir de la date system
     * @param titleChronologie
     */
    public Chronologie(String titleChronologie){
        this.chronologieHashMap = new HashMap<Date, Event>();
        this.titleChronologie = titleChronologie;
    }

    /**
     * Constructeur d'une chronologie avec changement de la date
     * @param titleChronologie
     */
    public Chronologie(String titleChronologie, Date startDate, Date endDate){
        this.chronologieHashMap = new HashMap<Date, Event>();
        this.titleChronologie = titleChronologie;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    /**
     *
     * @param event
     * @return
     */
    public boolean add(Event event){
        if (this.chronologieHashMap.containsKey(event.getDateEvent())){
            return false;
        }
        else{
            if(event.getDateEvent().compareTo(startDate) == 1 && event.getDateEvent().compareTo(endDate) == -1) {
                this.chronologieHashMap.put(event.getDateEvent(), event);
                return true;
            }
            else return false;
        }
    }

    public TreeMap<Date, Event> getTreeEvent(){
        TreeMap<Date, Event> dateEventTreeMap = new TreeMap<>(chronologieHashMap);
        return dateEventTreeMap;
    }
    public String getTitle(){
        return titleChronologie;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public HashMap<Date, Event> getChronologieHashMap() {
        return chronologieHashMap;
    }
}
