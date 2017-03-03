package com.shaybox.usbmc.utils;

import java.io.*;
import java.net.URL;

public class Download {

    //Download Function
    public Download(File file, URL url) throws IOException {

        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int n;
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
