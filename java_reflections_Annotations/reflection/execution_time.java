import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//Create an Interface
interface Task {
    void execute();
}

//Implement the Interface
class TaskImpl implements Task {
    public void execute() {
        try {
            Thread.sleep(500); // Simulating some work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Task executed!");
    }
}

//Create a Timing Proxy Handler
class TimingProxyHandler implements InvocationHandler {
    private final Object target;

    public TimingProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.nanoTime();
        Object result = method.invoke(target, args);
        long endTime = System.nanoTime();
        System.out.println("Execution time for method " + method.getName() + ": " + (endTime - startTime) / 1_000_000.0 + " ms");
        return result;
    }
}

//Create a Proxy Factory
class ProxyFactory {
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target, Class<T> interfaceType) {
        return (T) Proxy.newProxyInstance(
            interfaceType.getClassLoader(),
            new Class<?>[]{interfaceType},
            new TimingProxyHandler(target)
        );
    }
}

//Test the Proxy
public class execution_time {
    public static void main(String[] args) {
        Task task = ProxyFactory.createProxy(new TaskImpl(), Task.class);
        task.execute();
    }
}
