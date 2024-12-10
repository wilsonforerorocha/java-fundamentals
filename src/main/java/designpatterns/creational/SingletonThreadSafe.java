package designpatterns.creational;

public class SingletonThreadSafe {

    // The field must be declared volatile so that double check lock would work
    // correctly.
    private static volatile SingletonThreadSafe instance;

    public String value;

    private SingletonThreadSafe(String value) {
        System.out.println("Singleton Thread Safe is created");
        this.value = value;
    }

    public static SingletonThreadSafe getInstance(String value) {
        if (instance == null) {
            instance = new SingletonThreadSafe(value);
        }
        return instance;
    }

    public void showValue() {
        System.out.println(value);
    }
}
