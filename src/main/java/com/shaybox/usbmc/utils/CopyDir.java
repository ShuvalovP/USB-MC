package com.shaybox.usbmc.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CopyDir {

    public CopyDir(File source, File dest) throws IOException {

        FileUtils.copyDirectory(source, dest);

    }

}
