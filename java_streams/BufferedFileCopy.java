import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            File inputFile = new File("largefile.txt");
            if (!inputFile.exists()) {
                System.out.println("Source file does not exist.");
                return;
            }

            fis = new FileInputStream(inputFile);
            fos = new FileOutputStream("copy_largefile.txt");
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            long startTime = System.nanoTime();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            long endTime = System.nanoTime();

            System.out.println("Buffered copy time: " + (endTime - startTime) + " ns");

            bis.close();
            bos.close();

            // Unbuffered copy for comparison
            fis = new FileInputStream(inputFile);
            fos = new FileOutputStream("unbuffered_copy_largefile.txt");

            startTime = System.nanoTime();
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            endTime = System.nanoTime();
            System.out.println("Unbuffered copy time: " + (endTime - startTime) + " ns");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
                if (bis != null) bis.close();
                if (bos != null) bos.close();
            } catch (IOException e) {
                System.out.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}
