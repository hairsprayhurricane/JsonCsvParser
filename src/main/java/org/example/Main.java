package org.example;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileSearcher searcher = new FileSearcher();
        try {
            //List<File> jsonFiles = searcher.searchFiles("src/templates"); // файлы шаблонные, найденные на первом попавшемся сайте
            List<File> jsonFiles = searcher.searchFiles("src/stations-data");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

