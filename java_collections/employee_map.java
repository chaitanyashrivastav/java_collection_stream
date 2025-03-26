import java.util.*;

class Employee {
  String name;
  String Department;

  Employee(String name, String Department) {
    this.name = name;
    this.Department = Department;
  }

  @Override
  public String toString() {
    return name;
  }
}

public class employee_map {
  public static void main(String[] args) {
    List<Employee> employees = List.of(
        new Employee("Alice", "HR"),
        new Employee("Bob", "IT"),
        new Employee("John", "HR"), 
        new Employee("Eve", "Finance")) ;  

    Map<String, List<Employee>> groupedEmployees = new HashMap<>() ; 
    
    for(Employee emp : employees){
      groupedEmployees.computeIfAbsent( emp.Department , k -> new ArrayList<>()).add(emp)  ; 
    }

    for (var entry : groupedEmployees.entrySet()) {
      System.out.println(entry.getKey() + " : " + entry.getValue()) ;
    }
  }
}
