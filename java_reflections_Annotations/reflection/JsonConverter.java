import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class JsonConverter {
    public static String toJson(Object obj) {
        if (obj == null) {
            return "null";
        }
        
        Class<?> clazz = obj.getClass();
        StringBuilder json = new StringBuilder();
        
        if (obj instanceof String || obj instanceof Character) {
            return "\"" + obj.toString() + "\"";
        }
        if (obj instanceof Number || obj instanceof Boolean) {
            return obj.toString();
        }
        if (obj instanceof List) {
            List<?> list = (List<?>) obj;
            json.append("[");
            for (int i = 0; i < list.size(); i++) { 
                json.append(toJson(list.get(i)));
                if (i < list.size() - 1) {
                    json.append(", ");
                }
            }
            json.append("]");
            return json.toString();
        }
        if (obj instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) obj;
            json.append("{");
            int i = 0;
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                json.append(toJson(entry.getKey().toString())).append(": ").append(toJson(entry.getValue()));
                if (i < map.size() - 1) {
                    json.append(", ");
                }
                i++;
            }
            json.append("}");
            return json.toString();
        }
        
        json.append("{");
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                Object value = fields[i].get(obj);
                json.append("\"").append(fields[i].getName()).append("\": ").append(toJson(value));
                if (i < fields.length - 1) {
                    json.append(", ");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        json.append("}");
        
        return json.toString();
    }
    
    public static void main(String[] args) {
        class Sample {
            String name = "John";
            int age = 30;
            boolean isActive = true;
        }
        
        Sample sampleObj = new Sample();
        System.out.println(toJson(sampleObj));
    }
}

