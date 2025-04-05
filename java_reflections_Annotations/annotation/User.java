import java.lang.reflect.Field;

public class User {

  @MaxLength(10)
  private String username;

  public User(String username) {
    this.username = username;
    validateMaxLength();
  }

  private void validateMaxLength() {
    Field[] fields = this.getClass().getDeclaredFields();

    for (Field field : fields) {
      if (field.isAnnotationPresent(MaxLength.class)) {
        MaxLength annotation = field.getAnnotation(MaxLength.class);
        int max = annotation.value();

        field.setAccessible(true);
        try {
          Object value = field.get(this);
          if (value instanceof String str && str.length() > max) {
            throw new IllegalArgumentException(
                field.getName() + " exceeds max length of " + max);
          }
        } catch (IllegalAccessException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  // For testing
  public String getUsername() {
    return username;
  }

  public static void main(String[] args) {
    // Valid username
    User user1 = new User("JohnDoe");

    // Invalid username - will throw exception
    User user2 = new User("VeryLongUsername"); // throws IllegalArgumentException
  }
}
