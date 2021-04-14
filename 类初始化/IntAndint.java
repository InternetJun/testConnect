package 类初始化;

public class IntAndint {
    /**/
    public static void main(String[] args) {
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

        System.out.println(f1 == f2);
        //在128内呢就是有不创建对象出来的。
        System.out.println(f3 == f4);
        //在128后就会创建新的对象。
    }
}
