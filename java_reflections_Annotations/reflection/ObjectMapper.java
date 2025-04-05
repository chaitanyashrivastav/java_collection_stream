import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

class mapping_here {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                String fieldName = entry.getKey();
                Object fieldValue = entry.getValue();

                try {
                    Field field = clazz.getDeclaredField(fieldName);
                    field.setAccessible(true);
                    field.set(instance, fieldValue);
                } catch (NoSuchFieldException ignored) {
                    // Ignore fields that do not exist in the class
                }
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Failed to map properties to object", e);
        }
    }
}

// Move Person to a separate class
class Person {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class ObjectMapper{
    public static void main(String[] args) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("name", "John Doe");
        properties.put("age", 30);

        Person person = mapping_here.toObject(Person.class, properties);
        System.out.println(person);
    }
}
