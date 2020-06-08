package com.projettutore.covid.model;

import java.io.Serializable;

/**
 * Classe représentant un evenement
 * @see java.lang.Comparable
 * @see java.io.Serializable
 */
public class Event implements Comparable, Serializable {
    public Event(){

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
