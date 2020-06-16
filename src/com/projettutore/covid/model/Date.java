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

    /**
     * Constructeur de base, crée une date selon la date du systeme
     */
    public Date(){
        GregorianCalendar today = new GregorianCalendar();
        this.day = today.get(5);
        this.month = today.get(2) +1;
        this.year = today.get(1);
        this.intDayWeek = today.get(7);
        this.numberWeek = today.get(3);
    }


    /**
     * Constructeur créant une date selon le jours, le mois et l'année données (sans verification de donnée)
     * @param day
     * @param month
     * @param year
     */
    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
        GregorianCalendar arDay = new GregorianCalendar(this.year, this.month-1, this.day);
        this.intDayWeek = arDay.get(7);
        this.numberWeek = arDay.get(3);
    }

    /**
     * Methode qui retourne le nombre de jours dans un mois
     * @param month
     * @param year
     * @return
     */
    public int dayInAMonth(int month, int year) {
        switch(month) {
            case 2:
                if (isLeap(year)) {
                    return 29;
                }
                return 28;
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            default:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
        }
    }

    /**
     * Retourne une nouvelle date correspondant a la date du lendemain
     * @return Date
     */
    public Date dateDuLendemain() {
        if (this.day < dayInAMonth(this.month, this.year)) {
            return new Date(this.day + 1, this.month, this.year);
        } else {
            return this.month < 12 ? new Date(1, this.month + 1, this.year) : new Date(1, 1, this.year + 1);
        }
    }

    /**
     * Retourne une nouvelle date correspondant a la date de la veille
     * @return Dates
     */
    public Date dateDeLaVeille() {
        if (this.day > 1) {
            return new Date(this.day - 1, this.month, this.year);
        } else {
            return this.month > 1 ? new Date(dayInAMonth(this.month - 1, this.year), this.month - 1, this.year) : new Date(31, 12, this.year - 1);
        }
    }

    /**
     * Methode qui renvoie true si la date est la date d'aujourd'hui
     * @return
     */
    public boolean isToday() {
        return (new Date()).compareTo(this) == 0;
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

    /*
            methode static
    */

    /**
     * Methode qui retourne true si l'année donnée est bissextile, false si l'année n'est pas bissextile.
     * @param year
     * @return
     */
    private static boolean isLeap(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    /*
    tostring
     */

    public String toString(){
        return ""+ day + " " + month + " " + year;
    }

    /*
    Set and Get
     */

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getNumberWeek() {
        return numberWeek;
    }

    public int getIntDayWeek() {
        return intDayWeek;
    }
}
