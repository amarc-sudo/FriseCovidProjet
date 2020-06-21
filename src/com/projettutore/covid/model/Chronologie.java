package com.projettutore.covid.model;

import com.projettutore.covid.exeption.ChronologieException;
import com.projettutore.covid.exeption.FormulaireExeption;
import com.projettutore.covid.managers.FileManager;

import java.io.File;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
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
    private String periode;

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
    public Chronologie(String titleChronologie, Date startDate, Date endDate, String periode){
        FileManager.createFileChronologie(titleChronologie);
        this.chronologieHashMap = new HashMap<Date, Event>();
        this.titleChronologie = titleChronologie;
        this.startDate = startDate;
        this.endDate = endDate;
        this.periode = periode;
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

    public HashMap<Date, Event> getSortHashMap(){
        List<Map.Entry<Date, Event>> list =
                new LinkedList<Map.Entry<Date, Event>>( chronologieHashMap.entrySet() );
        Collections.sort( list, new Comparator<Map.Entry<Date, Event>>(){
            public int compare
                    (Map.Entry<Date, Event>o1, Map.Entry<Date, Event> o2 )
            {
                //comparer deux clés
                return (o1.getKey()).compareTo( o2.getKey() );
            }
        });

        //créer une nouvelle HashMap à partir de LinkedList
        HashMap<Date, Event> hmapTriee = new LinkedHashMap<Date, Event>();
        for (Map.Entry<Date, Event> entry : list)
        {
            hmapTriee.put( entry.getKey(), entry.getValue() );
        }
        return hmapTriee;
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

    public String  getPeriode(){
        return periode;
    }

    public HashMap<Date, Event> getChronologieHashMap() {
        return chronologieHashMap;
    }
}
