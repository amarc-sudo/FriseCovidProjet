package com.projettutore.covid.managers;

import com.projettutore.covid.model.Chronologie;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.ArrayList;

/**
 * Classe gérant les sauvegardes
 */
public class FileManager {
    /**
     * String de l'os en cours en petit case, win pour windows et unix pour linux/mac os
     */
    private static String OS = System.getProperty("os.name").toLowerCase();

    /**
     * path absolu vers le fichier document
     */
    private static FileSystemView fsv = FileSystemView.getFileSystemView();
    /**
     * fichier documents
     */
    private static File f = fsv.getDefaultDirectory();

    /**
     * Methode de lecture d'un fichier serialisez. Si le nom du fichier n'existe pas alors il crée une nouvelle chronologie
     * @param name
     */
    public static Chronologie load(String name){
        Chronologie chronologie = new Chronologie(name);
        if(isWindows()) {
            try {
                FileInputStream fis;
                if(name.endsWith(".serial"))
                    fis = new FileInputStream(new File(f.toString() +"\\ProjetCovid\\" + name));
                else
                    fis = new FileInputStream(new File(f.toString() +"\\ProjetCovid\\" + name+".serial"));

                ObjectInputStream ois= new ObjectInputStream(fis);
                try {

                    chronologie = (Chronologie) ois.readObject();
                } finally {

                    try {
                        ois.close();
                    } finally {
                        fis.close();
                    }
                }
            } catch(IOException ioe) {
                ioe.printStackTrace();
            } catch(ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            }
            return chronologie;
        }
        if(isUnix()) {
            try {
                FileInputStream fis;
                if(name.endsWith(".serial")) {
                    fis = new FileInputStream(new File(f.toString() + "/ProjetCovid/" + name));
                }
                else
                    fis = new FileInputStream(new File(f.toString() + "/ProjetCovid/" + name + ".serial"));
                ObjectInputStream ois= new ObjectInputStream(fis);
                try {

                    chronologie = (Chronologie) ois.readObject();
                } finally {

                    try {
                        ois.close();
                    } finally {
                        fis.close();
                    }
                }
            } catch(IOException ioe) {
                ioe.printStackTrace();
            } catch(ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            }
            return chronologie;
        }
        return chronologie;
    }

    /**
     * Sauvegarde une chronologie dans le repectoire ProjetCovid dans le dossier documents de la session en cours
     * @param name
     * @param chronologie
     */
    public static void save(String name, Chronologie chronologie) {
        if (isWindows()) {
            if(new File(f.toString() + "\\ProjetCovid\\").exists()) {
                try {
                    FileOutputStream fos;
                    if (name.endsWith(".serial"))
                        fos = new FileOutputStream(new File(f.toString() + "\\ProjetCovid\\" + name));
                    else
                        fos = new FileOutputStream(new File(f.toString() + "\\ProjetCovid\\" + name + ".serial"));
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    try {
                        oos.writeObject(chronologie);
                        oos.flush();
                    } finally {
                        try {
                            oos.close();
                        } finally {
                            fos.close();
                        }
                    }
                } catch (IOException ioe) {
                }
            }
            else{
                createSave();
                save(name, chronologie);
            }
        }
        if(new File(f.toString() + "/ProjetCovid/").exists()) {
            if (isUnix()) {
                try {
                    FileOutputStream fos;
                    if (name.endsWith(".serial"))
                        fos = new FileOutputStream(new File(f.toString() + "/ProjetCovid/" + name));
                    else
                        fos = new FileOutputStream(new File(f.toString() + "/ProjetCovid/" + name + ".serial"));
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    try {
                        oos.writeObject(chronologie);
                        oos.flush();
                    } finally {
                        //fermeture des flux
                        try {
                            oos.close();
                        } finally {
                            fos.close();
                        }
                    }
                } catch (IOException ioe) {
                }
            }
        }
        else{
            createSave();
            save(name, chronologie);
        }
    }
    /**
     * fichier de création du directory de sauvegarde. est utilisé dans le constructeur.
     */
    public static void createSave(){
        File file;
        if(isWindows()) {
            file = new File(f.toString() + "\\ProjetCovid");
            if (file.exists()) {
            } else {
                if (file.mkdir()) {
                } else {
                }
            }
        }
        if(isUnix()) {
            file = new File(f.toString()+"/ProjetCovid");
            if (file.exists()) {
            } else {
                if (file.mkdirs()) {
                } else {
                }
            }
        }
    }


    /**
     * Methode qui renvoi une arrayList des noms des chronologie existante
     * @return
     */
    public static ArrayList<String> chronologieListe(){
        File repertoire;
        ArrayList<String> returnStatement = new ArrayList<String>();
        if(isWindows())
            repertoire = new File(f.toString() + "\\ProjetCovid\\");
        else
            repertoire = new File(f.toString() + "/ProjetCovid/");
        File[] files=repertoire.listFiles();
        if(files != null){
            for (File file : files) {
                if (file.toString().endsWith(".serial")) {
                    returnStatement.add(((String)file.getName()));
                }
            }
        }
        return returnStatement;
    }
    /**
     * Methode qui renvoie un boolean true si l'os est Windows
     *
     * @return boolean
     */
    public static boolean isWindows() {
        return (OS.indexOf("win") >= 0);
    }

    /**
     * Methode qui renvoie un boolean true si l'os est Max
     *
     * @return boolean
     */
    public static boolean isMac() {
        return (OS.indexOf("mac") >= 0);
    }

    /**
     * Methode qui renvoie un boolean true si l'os est Linux
     *
     * @return boolean
     */
    public static boolean isUnix() {
        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
    }
}
