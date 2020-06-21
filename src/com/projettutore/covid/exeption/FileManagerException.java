package com.projettutore.covid.exeption;

import com.projettutore.covid.managers.FileManager;

public class FileManagerException extends Exception {
    public FileManagerException(String message){
        super(message);
    }
}
