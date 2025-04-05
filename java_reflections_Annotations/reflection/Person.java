import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Person {
  String name ;
  int age ; 
  Person(String name){
    this.name = name ; 
  }
  Person(){
    this.age = 10 ; 
  }
  void run(){} ; 
  void walk(){} ; 
  void fly(){} ; 

  public static void main(String[] args) {
    Person p = new Person();
    @SuppressWarnings("rawtypes")
    Constructor[] constructors = p.getClass().getDeclaredConstructors(); 
    Method[] methods = p.getClass().getDeclaredMethods() ; 
    Field[] fields = p.getClass().getDeclaredFields() ; 
    
    System.out.println(Arrays.toString(constructors));
    System.out.println(Arrays.toString(methods));
    System.out.println(Arrays.toString(fields));
  }

}
