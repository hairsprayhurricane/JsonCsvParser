import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileSearcher {
    public List<File> searchFiles(String directoryPath) throws IOException {
        List<File> jsonFiles = new ArrayList<>();
        List<File> csvFiles = new ArrayList<>();

        File directory = new File(directoryPath);
        if (!directory.isDirectory()) {
            throw new IOException("Path is not a directory");
        }

        searchFilesRecursively(directory, jsonFiles, csvFiles);

        System.out.println("Found JSON files:");
        for (File file : jsonFiles) {
            System.out.println(file.getName());
        }

        System.out.println("Found CSV files:");
        for (File file : csvFiles) {
            System.out.println(file.getName());
        }

        return jsonFiles;
    }

    private void searchFilesRecursively(File directory, List<File> jsonFiles, List<File> csvFiles) {
        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                searchFilesRecursively(file, jsonFiles, csvFiles);
            } else {
                if (file.getName().endsWith(".json")) {
                    jsonFiles.add(file);
                } else if (file.getName().endsWith(".csv")) {
                    csvFiles.add(file);
                }
            }
        }
    }
}
