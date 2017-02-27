package com.shaybox.usbmc;

import java.io.*;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {

        final String dir = System.getProperty("user.dir");
        System.err.println(dir);

        File USBMC = new File(dir + "/USBMC");
        if (!USBMC.exists()) {
            USBMC.mkdir();
        }

        File AppData = new File(dir + "/USBMC/AppData");
        if (!AppData.exists()) {
            AppData.mkdir();
        }

        DownloadFile(new File(dir + "/USBMC/Minecraft.jar"), new URL("http://s3.amazonaws.com/Minecraft.Download/launcher/Minecraft.jar"));

        PrintWriter writer = new PrintWriter(dir + "/USBMC/README.txt", "UTF-8");
        writer.println("DO NOT RUN");
        writer.println("Minecraft.jar");
        writer.println("ONLY RUN USBMC.jar");
        writer.close();

        Runtime.getRuntime().exec("java -jar " + dir + "/USBMC/Minecraft.jar --workDir " + dir + "/USBMC/AppData");

    }
    
    private static void DownloadFile(File file, URL url) throws IOException {

        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n = 0;
        while (-1!=(n=in.read(buf)))
        {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(response);
        fos.close();

    }

}