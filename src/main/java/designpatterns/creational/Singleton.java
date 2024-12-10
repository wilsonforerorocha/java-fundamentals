package designpatterns.creational;

/**
 * The Singleton Pattern is a creational design pattern that ensures a class has only one instance and provides
 * a global access point to that instance.
 */
public class Singleton {

    private static Singleton instance;

    public String value;

    private Singleton(String value) {
        System.out.println("Singleton is created");
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }

    public void showValue() {
        System.out.println(value);
    }
}
