package com.shaybox.usbmc;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static com.shaybox.usbmc.utils.Download.Download;

public class Main {

    //Main Function
    public static void main(String[] args) throws IOException {

        //Set Dir
        final String dir = System.getProperty("user.dir");

        //Check/Create USBMC Folder
        File USBMC = new File(dir + "/USBMC");
        if (!USBMC.exists()) {
            USBMC.mkdir();
        }

        //Download Launcher
        File launcher = new File("/USBMC/launcher.jar");
        if (!launcher.exists()) {
            Download(new File(dir + launcher), new URL("http://s3.amazonaws.com/Minecraft.Download/launcher/Minecraft.jar"));
        }

        //Start Launcher
        Runtime.getRuntime().exec("java -jar " + dir + launcher + " --workDir " + USBMC);

    }

}