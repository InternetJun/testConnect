package 类初始化.bank;

public class ThreadTest
{
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                pong();
            }

        };
        thread.run();
        System.out.println("ping");

    }

    private static void pong() {
        System.out.println("pong");
    }
}
