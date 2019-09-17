package algorithm;

public class SomeSingleton {

}

class Singleton1 {
    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}

class Singleton2 {

    private static Singleton2 instance;

    static {
        instance = new Singleton2();
    }

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}

class Singleton3 {
    //必须声明为volatile，否则仍然线程不安全
    private static volatile Singleton3 singleton;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (singleton == null) {
            synchronized (Singleton3.class) {
                if (singleton == null) {
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}

class Singleton4 {

    private Singleton4() {
    }

    private static class SingletonInstance {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    public static Singleton4 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}

class Singleton5 {
    // 私有构造函数
    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        return Singleton6.INSTANCE.getInstance();
    }

    private enum Singleton6 {
        INSTANCE;
        private Singleton5 singleton;

        // JVM保证这个方法绝对只调用一次
        Singleton6() {
            singleton = new Singleton5();
        }

        public Singleton5 getInstance() {
            return singleton;
        }
    }
}


