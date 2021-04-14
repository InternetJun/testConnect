package 类初始化;

class AOrder {
    AOrder() {
        System.out.println("I am A class...");
    }
    static {
        System.out.println("I am A static...");
    }

    {
        System.out.println("I am A constructor...");
    }
}

class BOrder extends AOrder {
    private BOrder() {
        System.out.println("I am B class...");
    }
    static {
        System.out.println("I am B static...");
    }

    {
        System.out.println("I am B constructor...");
    }

    public static void main(String[] args) {
        System.out.println("main start...");
        new BOrder();
        System.out.println("main end...");
    }
}

