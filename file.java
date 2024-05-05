import java.io.*;

public class FileOperationsExample {
    public static void main(String[] args) {
        String fileName = "example.txt";

        // Create a new file
        createFile(fileName);

        // Add content to the existing file
        addContentToFile(fileName, "This is some content added to the file.\n");

        // Display the file content before deleting
        System.out.println("File content before deletion:");
        displayFileContent(fileName);

        // Delete content of the existing file
        deleteFileContent(fileName);

        // Display the file content after deletion
        System.out.println("File content after deletion:");
        displayFileContent(fileName);
    }

    public static void createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }
    }

    public static void addContentToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(content);
            System.out.println("Content added to the file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while adding content to the file.");
            e.printStackTrace();
        }
    }

    public static void displayFileContent(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

    public static void deleteFileContent(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("");
            System.out.println("Content deleted from the file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while deleting content from the file.");
            e.printStackTrace();
        }
    }
}

