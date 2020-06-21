package com.projettutore.covid.model;

import com.projettutore.covid.exeption.ChronologieException;
import com.projettutore.covid.exeption.FormulaireExeption;
import com.projettutore.covid.managers.FileManager;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
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
    public boolean add(Event event) throws ChronologieException {
        for(Map.Entry mapentry : chronologieHashMap.entrySet()) {
            if(((Date) mapentry.getKey()).compareTo(event.getDateEvent()) == 0) {
                System.out.println("exeption");
                throw new ChronologieException("date deja existante");
            }
        }
        if(event.getDateEvent().compareTo(startDate) == 1 && event.getDateEvent().compareTo(endDate) == -1) {
            this.chronologieHashMap.put(event.getDateEvent(), event);
            FileManager.save(titleChronologie, this);
            return true;
        }
        else{
            throw new ChronologieException(("hors de la date du début ou de fin de la chronologie"));
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
