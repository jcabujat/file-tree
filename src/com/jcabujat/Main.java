package com.jcabujat;

import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {
        Path directory = FileSystems.getDefault().getPath("FileTree\\Dir2");
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory,"*.dat")) { // filtering the content to get files with .dat extension

            for (Path file: contents) {
                System.out.println(file.getFileName());
            }

        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }
    }
}
