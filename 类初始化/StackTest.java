package 类初始化;

public class StackTest {
    public static void main(String[] args) {
        func(3,2);
    }

    public static void func(int x, int y) {
        if (x > 0) {
            System.out.print("x");
            func(x-1, y);
        } else if (y > 0) {
            System.out.print("y");
            func(x, y-1);
        }

    }
}
