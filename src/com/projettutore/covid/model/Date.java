package com.projettutore.covid.model;

import java.io.Serializable;

/**
 * Classe representant une date
 * @see java.lang.Comparable
 * @see java.io.Serializable
 */
public class Date implements Comparable, Serializable {

    private int day;
    private int month;
    private int year;
    private int numberWeek;

    public Date(){

    }

    public Date(int day, int month, int year){

    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
