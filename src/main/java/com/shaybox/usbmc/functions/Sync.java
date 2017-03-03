package com.shaybox.usbmc.functions;

import com.shaybox.usbmc.utils.CopyDir;
import com.shaybox.usbmc.utils.CopyFile;

import java.io.File;
import java.io.IOException;

public class Sync {

    //SOMEONE REFRACTOR
    //PLEASE

    private static String OS = System.getProperty("os.name").toLowerCase();
    private static String dataFolder = null;

    public static void Start(File usbmc) throws IOException {
        if (OS.contains("win")) {

            //Windows
            dataFolder = System.getProperty("user.home") + "\\AppData\\Roaming\\.minecraft";

            //Copy Windows
            Windows(usbmc);

        } else if (OS.contains("mac")) {

            //Mac
            dataFolder = System.getProperty("user.home") + "/Library/Application Support/minecraft";

            //Copy Other
            Other(usbmc);

        } else if (OS.contains("nux")) {

            //Linux
            dataFolder = System.getProperty("user.home") + "/.minecraft";

            //Copy Other
            Other(usbmc);

        } else {
            //Other
            System.err.println("Sorry, cant find your operating system: " + OS);
            System.err.println("Please contact Shayne on github for support!");

            //Crash Exit
            System.exit(1);
        }

        //Debug Output
        System.err.println("Detected OS Folder: " + dataFolder);

    }

    private static void Windows(File usbmc) {

        //Folder Copys
        try {
            new CopyDir(new File(dataFolder + "\\mods"), new File(usbmc + "\\mods"));
        } catch (Exception e) {
            System.err.println("Mods Folder Doesn't Exist");
        }

        try {
            new CopyDir(new File(dataFolder + "\\resourcepacks"), new File(usbmc + "\\resourcepacks"));
        } catch (Exception e) {
            System.err.println("Resourcepacks Folder Doesn't Exist");
        }

        try {
            new CopyDir(new File(dataFolder + "\\shaderpacks"), new File(usbmc + "\\shaderpacks"));
        } catch (Exception e) {
            System.err.println("Shaderpacks Folder Doesn't Exist");
        }

        try {
            new CopyDir(new File(dataFolder + "\\saves"), new File(usbmc + "\\saves"));
        } catch (Exception e) {
            System.err.println("Saves Folder Doesn't Exist");
        }

        //File Copys
        try {
            new CopyFile(new File(dataFolder + "\\options.txt"), new File(usbmc + "\\options.txt"));
        } catch (Exception e) {
            System.err.println("options.txt");
        }

        try {
            new CopyFile(new File(dataFolder + "\\optionsof.txt"), new File(usbmc + "\\optionsof.txt"));
        } catch (Exception e) {
            System.err.println("optionsof.txt");
        }

        try {
            new CopyFile(new File(dataFolder + "\\optionsshaders.txt"), new File(usbmc + "\\optionsshaders.txt"));
        } catch (Exception e) {
            System.err.println("optionsshaders.txt");
        }

        try {
            new CopyFile(new File(dataFolder + "\\servers.dat"), new File(usbmc + "\\servers.dat"));
        } catch (Exception e) {
            System.err.println("servers.dat");
        }
    }

    private static void Other(File usbmc) {

        //Folder Copys
        try {
            new CopyDir(new File(dataFolder + "/mods"), new File(usbmc + "/mods"));
        } catch (Exception e) {
            System.err.println("Mods Folder Doesn't Exist");
        }

        try {
            new CopyDir(new File(dataFolder + "/resourcepacks"), new File(usbmc + "/resourcepacks"));
        } catch (Exception e) {
            System.err.println("Resourcepacks Folder Doesn't Exist");
        }

        try {
            new CopyDir(new File(dataFolder + "/shaderpacks"), new File(usbmc + "/shaderpacks"));
        } catch (Exception e) {
            System.err.println("Shaderpacks Folder Doesn't Exist");
        }

        try {
            new CopyDir(new File(dataFolder + "/saves"), new File(usbmc + "/saves"));
        } catch (Exception e) {
            System.err.println("Saves Folder Doesn't Exist");
        }

        //File Copys
        try {
            new CopyFile(new File(dataFolder + "/options.txt"), new File(usbmc + "/options.txt"));
        } catch (Exception e) {
            System.err.println("options.txt Doesn't Exist");
        }

        try {
            new CopyFile(new File(dataFolder + "/optionsof.txt"), new File(usbmc + "/optionsof.txt"));
        } catch (Exception e) {
            System.err.println("optionsof.txt Doesn't Exist");
        }

        try {
            new CopyFile(new File(dataFolder + "/optionsshaders.txt"), new File(usbmc + "/optionsshaders.txt"));
        } catch (Exception e) {
            System.err.println("optionsshaders.txt Doesn't Exist");
        }

        try {
            new CopyFile(new File(dataFolder + "/servers.dat"), new File(usbmc + "/servers.dat"));
        } catch (Exception e) {
            System.err.println("servers.dat Doesn't Exist");
        }

    }

}
