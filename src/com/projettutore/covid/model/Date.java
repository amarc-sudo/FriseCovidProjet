package com.projettutore.covid.model;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Classe representant une date
 * @see java.lang.Comparable
 * @see java.io.Serializable
 */
public class Date implements Comparable<Date>, Serializable {

    private int day;
    private int month;
    private int year;
    private int numberWeek;
    private int intDayWeek;

    public Date(){
        GregorianCalendar today = new GregorianCalendar();
        this.day = today.get(5);
        this.month = today.get(2) +1;
        this.year = today.get(1);
        this.intDayWeek = today.get(7);
        this.numberWeek = today.get(3);
    }

    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
        GregorianCalendar arDay = new GregorianCalendar(this.year, this.month-1, this.day);
        this.intDayWeek = arDay.get(7);
        this.numberWeek = arDay.get(3);
    }

    @Override
    public int compareTo(Date date) {
        if (this.year < date.year) {
            return -1;
        } else if (this.year > date.year) {
            return 1;
        } else if (this.month < date.month) {
            return -1;
        } else if (this.month > date.month) {
            return 1;
        } else if (this.day < date.day) {
            return -1;
        } else {
            return this.day > date.day ? 1 : 0;
        }
    }

}
