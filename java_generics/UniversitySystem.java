import java.util.ArrayList;
import java.util.List;

// Abstract base class for different course types
abstract class CourseType {
    private String courseName;
    private String instructor;

    public CourseType(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    abstract void displayCourseDetails(); // Abstract method to be implemented by subclasses
}

// Exam-Based Course
class ExamCourse extends CourseType {
    private int examWeightage;

    public ExamCourse(String courseName, String instructor, int examWeightage) {
        super(courseName, instructor);
        this.examWeightage = examWeightage;
    }

    @Override
    void displayCourseDetails() {
        System.out.println("Exam Course: " + getCourseName() + ", Instructor: " + getInstructor() + ", Exam Weightage: "
                + examWeightage + "%");
    }
}

// Assignment-Based Course
class AssignmentCourse extends CourseType {
    private int assignmentsCount;

    public AssignmentCourse(String courseName, String instructor, int assignmentsCount) {
        super(courseName, instructor);
        this.assignmentsCount = assignmentsCount;
    }

    @Override
    void displayCourseDetails() {
        System.out.println("Assignment Course: " + getCourseName() + ", Instructor: " + getInstructor() +
                ", Total Assignments: " + assignmentsCount);
    }
}

// Research-Based Course
class ResearchCourse extends CourseType {
    private String researchTopic;

    public ResearchCourse(String courseName, String instructor, String researchTopic) {
        super(courseName, instructor);
        this.researchTopic = researchTopic;
    }

    @Override
    void displayCourseDetails() {
        System.out.println("Research Course: " + getCourseName() + ", Instructor: " + getInstructor() + ", Research Topic: " + researchTopic);
    }
}

// Generic Course Manager (Only accepts CourseType or its subclasses)
class Course<T extends CourseType> {
    private List<T> courses = new ArrayList<>();

    public void addCourse(T course) {
        courses.add(course);
    }

    public List<T> getCourses() {
        return courses;
    }
}

// Utility class to display courses (Using Wildcards)
class CourseUtils {
    static void printCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            course.displayCourseDetails();
        }
    }
}



// Main Class
public class UniversitySystem {
    public static void main(String[] args) {
        // Creating courses
        ExamCourse mathCourse = new ExamCourse("Mathematics", "Dr. Smith", 70);
        AssignmentCourse programmingCourse = new AssignmentCourse("Java Programming", "Prof. Miller", 5);
        ResearchCourse aiCourse = new ResearchCourse("AI Research", "Dr. Watson", "Machine Learning");

        // Managing Exam Courses
        Course<ExamCourse> examCourseManager = new Course<>();
        examCourseManager.addCourse(mathCourse);

        // Managing Assignment Courses
        Course<AssignmentCourse> assignmentCourseManager = new Course<>();
        assignmentCourseManager.addCourse(programmingCourse);

        // Managing Research Courses
        Course<ResearchCourse> researchCourseManager = new Course<>();
        researchCourseManager.addCourse(aiCourse);

        // Displaying all courses using wildcards
        System.out.println("\nDisplaying Exam Courses:");
        CourseUtils.printCourses(examCourseManager.getCourses());

        System.out.println("\nDisplaying Assignment Courses:");
        CourseUtils.printCourses(assignmentCourseManager.getCourses());

        System.out.println("\nDisplaying Research Courses:");
        CourseUtils.printCourses(researchCourseManager.getCourses());

    }
}