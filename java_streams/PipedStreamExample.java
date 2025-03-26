import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;
    private PipedInputStream pis;

    WriterThread(PipedOutputStream pos, PipedInputStream pis) {
        this.pos = pos;
        this.pis = pis;
    }

    public void run() {
        try {
            String message = "Hello from the writer thread!";
            pos.write(message.getBytes());
            pos.close();
        } catch (IOException e) {
            System.out.println("Error in WriterThread: " + e.getMessage());
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    public void run() {
        try {
            int data;
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Error in ReaderThread: " + e.getMessage());
        }
    }
}

public class PipedStreamExample {
    public static void main(String[] args) {
        PipedOutputStream pos = new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream();

        try {
            pis.connect(pos);
            Thread writerThread = new WriterThread(pos, pis);
            Thread readerThread = new ReaderThread(pis);

            writerThread.start();
            readerThread.start();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
