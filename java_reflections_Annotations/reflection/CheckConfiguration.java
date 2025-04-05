import java.lang.reflect.Field;

public class CheckConfiguration{
  private static String API_KEY ;

  public String getAPI_KEY(){
    return API_KEY ;
  }

  public static void main(String[] args) {
    CheckConfiguration config = new CheckConfiguration() ; 
    API_KEY = "minorKey" ; 

    try {
      Field field = CheckConfiguration.class.getDeclaredField("API_KEY") ;
      field.setAccessible(true);
      field.set(null, "majorKey");

      System.out.println(config.getAPI_KEY());
    } catch (Exception e) {
      e.printStackTrace();
    } 

  }
}
