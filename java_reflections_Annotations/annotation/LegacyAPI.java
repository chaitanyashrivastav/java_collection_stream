public class LegacyAPI {

  void newFeature() {
    System.out.println("This is the newer feature");
  }

  @Deprecated
  void oldFeature() {
    System.out.println("its out of date");
  }

  public static void main(String[] args) {
    LegacyAPI api = new LegacyAPI() ; 
    
    api.newFeature();
    api.oldFeature();
  }
}
