import java.util.Arrays;
import java.util.List;

abstract class JobRole {
  private String name;
  private String dept;

  JobRole(String name, String dept) {
    this.name = name;
    this.dept = dept;
  }

  public String getName() {
    return name;
  }

  public String getDept() {
    return dept;
  }

  abstract void displayJobs();
}

class SoftwareEngineer extends JobRole {

  SoftwareEngineer(String name, String dept) {
    super(name, dept);
  }

  @Override
  void displayJobs() {
    System.out.println(getName() + " belongs to: " + getDept() + "is a software engineer");
  }
}

class DataScientist extends JobRole {
  DataScientist(String name, String dept) {
    super(name, dept);
  }

  @Override
  void displayJobs() {
    System.out.println(getName() + " belongs to: " + getDept() + "is a data scientist");
  }
}

class ProductManager extends JobRole {
  ProductManager(String name, String dept) {
    super(name, dept);
  }

  @Override
  void displayJobs() {
    System.out.println(getName() + " belongs to: " + getDept() + " is a product manager");
  }
}

class Resume<T extends JobRole>{
  private T jobRole ;

  public Resume(T jobRole){
    this.jobRole = jobRole ; 
  }

  public void processResume(){
    jobRole.displayJobs();
  }
}

class ResumeScreeningSystem{
  public static void handleMultipleResume(List <? extends JobRole> jobRoles){
    for (JobRole jobrole : jobRoles) {
      jobrole.displayJobs();
    }
  }
}

public class AI_resume_screening {
  public static void main(String[] args) {
    Resume<SoftwareEngineer> engg = new Resume<>(new SoftwareEngineer("Joe", "IT"))  ; 
    Resume<DataScientist> dataScientistResume = new Resume<>(new DataScientist("Bob", "Python"));
    Resume<ProductManager> productManagerResume = new Resume<>(new ProductManager("Charlie", "Agile"));

    engg.processResume();
    dataScientistResume.processResume();
    productManagerResume.processResume(); //handling individually

    // handling multiple resumes in a batch
    List<JobRole> multipleResumes = Arrays.asList(
      new SoftwareEngineer("Joe", "IT"), new DataScientist("Bob", "Python"),new ProductManager("Charlie", "Agile")
    ); // creates a fixed-size list of length 3 from given elements

    System.out.println() ;
    ResumeScreeningSystem.handleMultipleResume(multipleResumes) ;
  }
}
