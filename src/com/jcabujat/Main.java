package com.jcabujat;

import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {
        Path directory = FileSystems.getDefault().getPath("FileTree\\Dir2");
        DirectoryStream.Filter<Path> filter = Files::isRegularFile; // method reference
//        DirectoryStream.Filter<Path> filter = entry -> (Files.isRegularFile(entry)); // lambda equivalent of the below code
//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
//            @Override
//            public boolean accept(Path entry) throws IOException {
//                return (Files.isRegularFile(entry));
//            }
//        };
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) { // filtering the content using the customized filter object

            for (Path file : contents) {
                System.out.println(file.getFileName());
            }

        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
        }
    }
}
