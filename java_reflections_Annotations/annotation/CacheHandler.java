import java.lang.reflect.Method;
import java.util.HashMap;

interface handler {
  int findDuplicates(int n) ; 
}

public class CacheHandler implements handler {
  private final HashMap<Integer, Integer> cache = new HashMap<>() ;  

  public int fibb(int n) {
    if (n == 0 || n == 1) {
      return n;
    }
    return fibb(n - 1) + fibb(n - 2);
  }
    @Override
    @CacheResult
    public int findDuplicates(int n) {
      if(!cache.containsKey(n)){
        System.out.println("Element added to cache");
        cache.put(n, fibb(n)) ; 
      }else{
        System.out.println("already in cache, called from there !");
      }

      return cache.get(n) ; 
    }

  public static void main(String[] args) throws Throwable {
    handler obj = new CacheHandler() ;
    Method method = obj.getClass().getDeclaredMethod("findDuplicates",int.class) ;  

    if (method.isAnnotationPresent(CacheResult.class)) {
      System.out.println(method.invoke(obj, 4));
      System.out.println("------------------");
      System.out.println(method.invoke(obj, 5));
      System.out.println("-------------------");
      System.out.println(method.invoke(obj, 4));
    }

}
}
