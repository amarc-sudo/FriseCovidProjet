package com.projettutore.covid.managers;

import com.projettutore.covid.model.Chronologie;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;

import java.awt.image.BufferedImage;
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
     * Methode static qui permet de copier un element dans le dossier de l'application
     * @param source
     * @return
     */
    public static boolean copier(File source, String name) {
        if(!(new File(f.toString() +"\\ProjetCovid\\" + File.separator + name + source.getName()).exists())) {
            try (InputStream sourceFile = new java.io.FileInputStream(source);
                 OutputStream destinationFile = new FileOutputStream(new File(f.toString() + "\\ProjetCovid\\"  + name + File.separator + source.getName()))) {
                // Lecture par segment de 0.5Mo
                byte buffer[] = new byte[512 * 1024];
                int nbLecture;
                while ((nbLecture = sourceFile.read(buffer)) != -1) {
                    destinationFile.write(buffer, 0, nbLecture);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false; // Erreur
            }
            return true; // Résultat OK
        }
        return true;
    }

    /**
     * methode statique qui permet de charger une image dans le dossier documents
     * @param name
     * @return
     * @throws IOException
     */
    public static BufferedImage loadImage(String name, String filesName) throws IOException {
        System.out.println(new File(f.toString() + File.separator +"ProjetCovid"+ File.separator + filesName+ File.separator + name).exists());
        return ImageIO.read(new File(f.toString() + File.separator +"ProjetCovid"+ File.separator + filesName+ File.separator + name));
    }

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
                    fis = new FileInputStream(new File(f.toString() +"\\ProjetCovid\\" + name.substring(0, name.length() - 7) + File.separator  + name));
                else
                    fis = new FileInputStream(new File(f.toString() +"\\ProjetCovid\\" + name + File.separator + name+".serial"));

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
                    fis = new FileInputStream(new File(f.toString() + "/ProjetCovid/"+ name.substring(0, name.length() - 7) + File.separator + name));
                }
                else
                    fis = new FileInputStream(new File(f.toString() + "/ProjetCovid/" + name + File.separator + name + ".serial"));
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
            if(new File(f.toString() + "\\ProjetCovid\\" + name + File.separator).exists()) {
                try {
                    FileOutputStream fos;
                    if (name.endsWith(".serial"))
                        fos = new FileOutputStream(new File(f.toString() + "\\ProjetCovid\\" + name + File.separator + name));
                    else
                        fos = new FileOutputStream(new File(f.toString() + "\\ProjetCovid\\" + name + File.separator + name + ".serial"));
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
        if(new File(f.toString() + "/ProjetCovid/" + name + File.separator).exists()) {
            if (isUnix()) {
                try {
                    FileOutputStream fos;
                    if (name.endsWith(".serial"))
                        fos = new FileOutputStream(new File(f.toString() + "/ProjetCovid/" + name + File.separator + name));
                    else
                        fos = new FileOutputStream(new File(f.toString() + "/ProjetCovid/" + name + File.separator + name + ".serial"));
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

    public static void createFileChronologie(String name){
        File file;
        if(isWindows()) {
            file = new File(f.toString() + "\\ProjetCovid\\" + name );
            if (file.exists()) {
            } else {
                if (file.mkdir()) {
                } else {
                }
            }
        }
        if(isUnix()) {
            file = new File(f.toString()+"/ProjetCovid/" + name);
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
    public static ArrayList chronologieListe() {
        File repertoire;
        ArrayList<String> returnStatement = new ArrayList<String>();

        if(isWindows())
            repertoire = new File(f.toString() + "\\ProjetCovid\\");
        else
            repertoire = new File(f.toString() + "/ProjetCovid/");
        if (repertoire.isDirectory()) {
            search(repertoire, returnStatement);
        }
        else {
        }
        return returnStatement;
    }

    private static void search(File file, ArrayList<String> result) {
        if (file.isDirectory()) {
            if (file.canRead()) {
                for (File temp : file.listFiles()) {
                    if (temp.isDirectory()) {
                        search(temp, result);
                    } else {
                        if (temp.getName().endsWith(".serial")) {
                            result.add(temp.getAbsoluteFile().getName().toString());
                        }

                    }
                }
            } else {
            }
        }

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
