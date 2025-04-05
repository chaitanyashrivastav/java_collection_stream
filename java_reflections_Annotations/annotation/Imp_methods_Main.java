import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Imp_methods_Main {

  @ImportantMethod(level = "LOW")
  void run() {
    System.out.println("its running");
  }

  void walk() {
    System.out.println("its walking");
  }

  @ImportantMethod
  void fly() {
    System.out.println("its flying");
  }

  public static void main(String[] args) throws IllegalAccessException, InvocationTargetException { 
    Imp_methods_Main obj = new Imp_methods_Main() ; // creating an instance of the main class for method invoking purposes
    
    Method[] methods = Imp_methods_Main.class.getDeclaredMethods();
    
    for (Method method : methods) {
      ImportantMethod annotation = method.getAnnotation(ImportantMethod.class) ;  

      if (method.isAnnotationPresent(ImportantMethod.class)) {
        method.invoke(obj) ; 
        System.out.println("Level: "+annotation.level());
        System.out.println("-------------");
      }
    }
  }
}
