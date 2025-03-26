import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class EmployeeSerialization {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "John Doe", "IT", 60000));
        employees.add(new Employee(2, "Jane Smith", "HR", 55000));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.ser"))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized.");
        } catch (IOException e) {
            System.out.println("Error serializing: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser"))) {
            List<Employee> deserializedEmployees = (List<Employee>) ois.readObject();
            for (Employee emp : deserializedEmployees) {
                System.out.println("ID: " + emp.id + ", Name: " + emp.name + ", Department: " + emp.department + ", Salary: " + emp.salary);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error deserializing: " + e.getMessage());
        }
    }
}
