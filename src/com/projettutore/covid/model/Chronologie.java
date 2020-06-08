package com.projettutore.covid.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @see java.io.Serializable
 * @see Event
 */
public class Chronologie implements Serializable {
    private HashMap<Date, Event> chronologieHashMap;
    private String titleChronologie;

    /**
     *
     * @param titleChronologie
     */
    public Chronologie(String titleChronologie){
        this.chronologieHashMap = new HashMap<Date, Event>();
        this.titleChronologie = titleChronologie;
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
            this.chronologieHashMap.put(event.getDateEvent(), event);
            return true;
        }
    }
}
