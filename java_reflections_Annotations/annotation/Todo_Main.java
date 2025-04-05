import java.lang.reflect.Method;

public class Todo_Main {

  @Todo(task = "lazy things", assignedTo = "joe", priority = "LOW")
  void sleep() {
    System.out.println("Sleeping");
  }

  @Todo(task = "productivity", assignedTo = "helen", priority = "HIGH")
  void work() {
    System.out.println("Working");
  }

  @Todo(task = "productivity", assignedTo = "helen", priority = "HIGH")
  void checkSchedule(){
    System.out.println("putting all the tasks in mobile");
  }

  @Todo(task = "working out", assignedTo = "frank")
  void play() {
    System.out.println("playing");
  }

  public static void main(String[] args) {
    try {
      Todo_Main obj = new Todo_Main(); //Instance created
  
      Method methods[] = Todo_Main.class.getDeclaredMethods() ; 
  
      for (Method method : methods) {
        Todo annotation = method.getAnnotation(Todo.class) ;

        if (method.isAnnotationPresent(Todo.class)) {
          // method.invoke(obj) ; 
          System.out.println("Method: " + method.getName());
          System.out.println(annotation.task());
          System.out.println(annotation.assignedTo());
          System.out.println(annotation.priority());
          System.out.println("----------------");
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
