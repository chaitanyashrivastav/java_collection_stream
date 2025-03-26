import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File inputFile = new File("source.txt");
            if (!inputFile.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }

            fis = new FileInputStream(inputFile);
            fos = new FileOutputStream("destination.txt");

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}
