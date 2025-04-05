
import java.lang.reflect.Method;

public class Main_Report {
  @BugReport(description = "Report 1")
  @BugReport(description = "Report 2")
  @BugReport(description = "Report 3")
  void buildMultipleReports() {
    // nothing here (just for annotation purposes)
  }

  public static void main(String[] args) {
    try {
      Method method = Main_Report.class.getDeclaredMethod("buildMultipleReports");
      // this will store all the bug_reports in an array
      BugReport[] reports = method.getAnnotationsByType(BugReport.class);

      for (BugReport report : reports) {
        System.out.println(report.description());
      }
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }

  }
}
