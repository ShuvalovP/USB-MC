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
            prop.setProperty("sync-files", "false");

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
            System.out.println("Sync-Files: " + prop.getProperty("sync-files"));

        } finally{
            if(input!=null){
                input.close();
            }
        }

    }

}
