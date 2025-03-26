import java.io.*;

public class ImageToByteArray {
    public static void main(String[] args) {
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        FileOutputStream fos = null;

        try {
            File inputFile = new File("image.jpg");
            fis = new FileInputStream(inputFile);
            baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageData = baos.toByteArray();
            fos = new FileOutputStream("copy_image.jpg");
            fos.write(imageData);
            System.out.println("Image copied successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (baos != null) baos.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}
