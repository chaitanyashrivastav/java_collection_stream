import java.lang.reflect.Field;

public class PersonforPrivate {
  private int age;

  public PersonforPrivate(int age) {
    this.age = age;
  }

  public int getAge() {
    return age;
  }

  public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
    PersonforPrivate pp = new PersonforPrivate(27) ; 
    Field field = pp.getClass().getDeclaredField("age") ; 

    if (field.getName().equals("age")) {
      field.setAccessible(true);
      field.set(pp, 67);
    }

    System.out.println(pp.getAge());
  }
}
