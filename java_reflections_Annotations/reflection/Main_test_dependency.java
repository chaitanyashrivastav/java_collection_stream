import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

//Define @Inject Annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {}

// Simple Dependency Injection Container
class DIContainer {
    private final Map<Class<?>, Object> instances = new HashMap<>();

    public void register(Class<?> clazz) {
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            instances.put(clazz, instance);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create instance of " + clazz.getName(), e);
        }
    }

    public void injectDependencies() {
        for (Object instance : instances.values()) {
            for (Field field : instance.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(Inject.class)) {
                    Class<?> dependencyType = field.getType();
                    Object dependency = instances.get(dependencyType);
                    if (dependency != null) {
                        try {
                            field.setAccessible(true);
                            field.set(instance, dependency);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException("Failed to inject dependency into " + field.getName(), e);
                        }
                    }
                }
            }
        }
    }

    public <T> T getInstance(Class<T> clazz) {
        return clazz.cast(instances.get(clazz));
    }
}

//Example Classes
class Service {
    public void serve() {
        System.out.println("Service is running...");
    }
}

class Client {
    @Inject
    private Service service;
    
    public void execute() {
        service.serve();
    }
}

//Dependency Injection
public class Main_test_dependency {
    public static void main(String[] args) {
        DIContainer container = new DIContainer();
        container.register(Service.class);
        container.register(Client.class);
        container.injectDependencies();
        
        Client client = container.getInstance(Client.class);
        client.execute();
    }
}