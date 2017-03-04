package com.shaybox.usbmc.functions;

import com.shaybox.usbmc.utils.Config;
import com.shaybox.usbmc.utils.Copy;

import java.io.File;
import java.io.IOException;

public class Sync {

    private static String OS = System.getProperty("os.name").toLowerCase();
    private static String Data;

    public static void Start(File usbmc) throws IOException {
        if (OS.contains("win")) {

            //Windows
            Data = System.getProperty("user.home") + "\\AppData\\Roaming\\.minecraft";

            //Transfer Files
            Transfer(usbmc);

        } else if (OS.contains("mac")) {

            //Mac
            Data = System.getProperty("user.home") + "/Library/Application Support/minecraft";

            //Transfer Files
            Transfer(usbmc);

        } else if (OS.contains("nux")) {

            //Linux
            Data = System.getProperty("user.home") + "/.minecraft";

            //Transfer Files
            Transfer(usbmc);

        } else {

            //Debug Output
            System.err.println("Sorry, your operating system was not found");
            System.err.println("Please contact Shayne on GitHub for support");
            System.err.println("Your OS: " + OS);

            //Exit
            System.exit(1);

        }

        //Debug Output
        System.err.println("OS Folder: " + Data);

    }

    private static void Transfer(File usbmc) throws IOException {

        if (Config.prop.getProperty("sync-launcher-profiles").equalsIgnoreCase("true")) {
            if (new File(usbmc + "/launcher_profiles.json").exists()) {
                Copy.File(new File(usbmc + "/launcher_profiles.json"), new File(usbmc + "/launcher_profiles.json.backup"));
            }
        }

        if (Config.prop.getProperty("sync-method").equalsIgnoreCase("new")) {
            Copy.Dir(new File(Data), usbmc);
        } else {
            oldTransfer(usbmc);
        }

        if (Config.prop.getProperty("sync-launcher-profiles").equalsIgnoreCase("true")) {
            if (new File(usbmc + "/launcher_profiles.json.backup").exists()) {
                Copy.File(new File(usbmc + "/launcher_profiles.json.backup"), new File(usbmc + "/launcher_profiles.json"));
            }
        }

    }
    
    private static void oldTransfer(File usbmc) throws IOException {

        //Folder Copys
        try {
            Copy.Dir(new File(Data + "/mods"), new File(usbmc + "/mods"));
        } catch (Exception e) {
            System.err.println("Mods Folder Doesn't Exist");
        }

        try {
            Copy.Dir(new File(Data + "/resourcepacks"), new File(usbmc + "/resourcepacks"));
        } catch (Exception e) {
            System.err.println("Resourcepacks Folder Doesn't Exist");
        }

        try {
            Copy.Dir(new File(Data + "/shaderpacks"), new File(usbmc + "/shaderpacks"));
        } catch (Exception e) {
            System.err.println("Shaderpacks Folder Doesn't Exist");
        }

        try {
            Copy.Dir(new File(Data + "/saves"), new File(usbmc + "/saves"));
        } catch (Exception e) {
            System.err.println("Saves Folder Doesn't Exist");
        }

        //File Copys
        try {
            Copy.File(new File(Data + "/options.txt"), new File(usbmc + "/options.txt"));
        } catch (Exception e) {
            System.err.println("options.txt Doesn't Exist");
        }

        try {
            Copy.File(new File(Data + "/optionsof.txt"), new File(usbmc + "/optionsof.txt"));
        } catch (Exception e) {
            System.err.println("optionsof.txt Doesn't Exist");
        }

        try {
            Copy.File(new File(Data + "/optionsshaders.txt"), new File(usbmc + "/optionsshaders.txt"));
        } catch (Exception e) {
            System.err.println("optionsshaders.txt Doesn't Exist");
        }

        try {
            Copy.File(new File(Data + "/servers.dat"), new File(usbmc + "/servers.dat"));
        } catch (Exception e) {
            System.err.println("servers.dat Doesn't Exist");
        }

    }
    
}
