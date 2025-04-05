import java.lang.reflect.Constructor;

public class Student {
  private String name;
  private int age;

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName(){
    return name ;
  }

  public int getAge(){
    return age ; 
  }

  public static void main(String[] args) {
    try {
      Constructor<Student> constructor = Student.class.getDeclaredConstructor(String.class , int.class) ;
      Student stu = constructor.newInstance("Joe" , 17);

      System.out.println(stu.getName() +" "+ stu.getAge());
    } catch (Exception e) {
      e.printStackTrace();
    }
     
  }
}
