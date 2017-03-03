package com.shaybox.usbmc;

import com.shaybox.usbmc.functions.Sync;
import com.shaybox.usbmc.utils.Config;
import com.shaybox.usbmc.utils.Download;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {

    //Main Function
    public static void main(String[] args) throws IOException {

        //Set Dir
        final String dir = System.getProperty("user.dir");
        System.err.println("Working Directory: " + dir);

        //Check/Create usbmc Folder
        File usbmc = new File(dir + "/usbmc");
        if (!usbmc.exists()) {
            usbmc.mkdir();
        }

        //Set Config
        final String config = usbmc + "/usbmc.cfg";

        //Create Config
        if (!new File(config).exists()) {
            //Create Config
            Config.Create(config);
        }

        //Load Config
        Config.Load(config);

        if (Config.prop.getProperty("sync-files").equalsIgnoreCase("true")) {
            //Sync Files
            Sync.Start(usbmc);
        }

        //Download Launcher
        File launcher = new File("/usbmc/launcher.jar");
        if (!launcher.exists()) {
            new Download(new File(dir + launcher), new URL("http://s3.amazonaws.com/Minecraft.Download/launcher/Minecraft.jar"));
        }

        //Start Launcher
        Runtime.getRuntime().exec("java -jar " + dir + launcher + " --workDir " + usbmc);

        //Normal Exit
        System.exit(0);

    }

}