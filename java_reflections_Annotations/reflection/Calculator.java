import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Calculator {
  private double multiply(int a, int b){
    return a*b ; 
  }
  public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, InvocationTargetException {
    Calculator pc = new Calculator() ; 
    Method method = pc.getClass().getDeclaredMethod("multiply", int.class,int.class) ;  

    if (method.getName().equals("multiply")) {
      method.setAccessible(true);
      System.out.println(method.invoke(pc,2,3));
    }
  }
}
