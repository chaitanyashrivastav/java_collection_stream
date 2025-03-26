import java.io.*;

public class DataStreamExample {
    public static void main(String[] args) {
        DataOutputStream dos = null;
        DataInputStream dis = null;

        try {
            dos = new DataOutputStream(new FileOutputStream("student_data.dat"));
            dos.writeInt(1);
            dos.writeUTF("John");
            dos.writeDouble(3.9);

            dos.close();

            dis = new DataInputStream(new FileInputStream("student_data.dat"));
            int rollNumber = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (dos != null) dos.close();
                if (dis != null) dis.close();
            } catch (IOException e) {
                System.out.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}
