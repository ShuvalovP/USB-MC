package com.shaybox.usbmc.utils;

import java.io.*;
import java.util.Properties;

public class Config {

   public static Properties prop = new Properties();

    public static void Create(String config) throws IOException {

        OutputStream output = null;

        try {

            output = new FileOutputStream(config);

            // set the properties value
            prop.setProperty("sync-launcher-profiles", "false");
            prop.setProperty("sync-files", "false");
            prop.setProperty("sync-method", "new");

            // save properties to project root folder
            prop.store(output, null);

        } finally {
            if (output != null) {
                output.close();
            }

        }
    }

    public static void Load(String config) throws IOException {

        InputStream input = null;

        try {

            input = new FileInputStream(config);

            prop.load(input);

            //Debug Output
            System.out.println("Sync Profiles: " + prop.getProperty("sync-launcher-profiles"));
            System.out.println("Sync Status: " + prop.getProperty("sync-files"));
            System.out.println("Sync Method: " + prop.getProperty("sync-method"));

        } finally{
            if(input!=null){
                input.close();
            }
        }

    }

}
