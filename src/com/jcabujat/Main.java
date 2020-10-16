package com.jcabujat;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("----- Walking Tree for Dir2 --------");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try {
            Files.walkFileTree(dir2Path, new PrintNames());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("----- Copy Dir2 files to Dir4/Dir2Copy ------");
        Path targetPath = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir4" +
                File.separator + "Dir2Copy");
        try {
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, targetPath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
