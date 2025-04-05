import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface BugReports{
  BugReport[] value() ; //Array to store multiple @BugReport annotations 
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class) // this makes BugReport.class repeatable 
public @interface BugReport {
  String description() ; 
}
