package designpatterns.creational;

public class SingletonPractice {

    public static void main(String[] args) {
        testSingleton();
        testBadThreadSingleton();
        testGoodThreadSingleton();
    }

    private static void testSingleton() {
        System.out.println("Testing Singleton" + "\n\n" +
                "RESULT:" + "\n");
        Singleton singleton = Singleton.getInstance("FOO");
        Singleton anotherSingleton = Singleton.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
    }

    private static void testGoodThreadSingleton() {
        System.out.println("Testing Good Thread Singleton" + "\n\n" +
                "RESULT:" + "\n");
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    private static void testBadThreadSingleton() {
        System.out.println("Testing Bad Thread Singleton" + "\n\n" +
                "RESULT:" + "\n");
        Thread threadFoo = new Thread(new ThreadFooBad());
        Thread threadBar = new Thread(new ThreadBarBad());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            SingletonThreadSafe singleton = SingletonThreadSafe.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            SingletonThreadSafe singleton = SingletonThreadSafe.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }

    static class ThreadFooBad implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBarBad implements Runnable {
        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
}
