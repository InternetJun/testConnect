package 类初始化;

public class TestStatic {
    public static String anInt = "10";
    public static int j = 0;

    public static void main(String[] args) {
        int a = TestStatic.j;
        test();
        System.out.println(anInt);

    }

    public static void test() {
/*17770422981*/
        for (int i = 0; i < 2; i++) {
            anInt += "hello";
            System.out.println(anInt+"\t"+i);
        }
    }

}