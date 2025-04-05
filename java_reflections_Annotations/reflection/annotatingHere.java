import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Author(name = "Robert")
public class annotatingHere {
  public static void main(String[] args) {
    Author annotation = annotatingHere.class.getDeclaredAnnotation(Author.class) ; 

    System.out.println(annotation.name());
  }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Author{
  String name() ; 
}
