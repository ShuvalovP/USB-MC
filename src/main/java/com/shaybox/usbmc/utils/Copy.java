package com.shaybox.usbmc.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Copy {

    public static void Dir(File source, File dest) throws IOException {

        FileUtils.copyDirectory(source, dest);

    }

    public static void File(File source, File dest) throws IOException {

        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

    }

}
