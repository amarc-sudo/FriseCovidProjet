package com.projettutore.covid.managers;

import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesManager {
        private static Locale locale;
        private static ResourceBundle messages;
    public static void create(){
        locale = new Locale("fr");
        messages = ResourceBundle.getBundle("lang", locale);
    }

    public static String getElement(String element){
        return messages.getString(element);
    }

    public static void setLocale(String pays){
        locale = new Locale(pays);
        messages = ResourceBundle.getBundle("lang", locale);
    }
}
