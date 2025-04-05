
import java.lang.reflect.Method;

public class TaskManager {
  @TaskInfo(priority = 1, assignedTo = "higher")
  void find_info() {
    System.out.println("higher priority");
  }

  @TaskInfo(priority = 6, assignedTo = "lower")
  void find_noth() {
    System.out.println("lower priority");
  }

  public static void main(String[] args) {
    TaskManager manager= new TaskManager(); 

    for(Method method : manager.getClass().getDeclaredMethods()){
      if (method.isAnnotationPresent(TaskInfo.class)) {
        TaskInfo annotation = method.getAnnotation(TaskInfo.class); 

        System.out.println("Method name: " + method.getName());
        System.out.println("Priority : " +  annotation.priority());
        System.out.println("Assigned to : " + annotation.assignedTo());
        System.out.println("------------------------------");
      }
      

    }
  }
}
