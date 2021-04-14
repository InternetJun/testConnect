package 类初始化;

public class TestInteger {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        /*我是这里错了 存在a+b数值表达式，比较的是数值*/
        System.out.println(g == (a + b));
        /**
         * 我这里是错的
         * @Long的equals()先判断传递进来的是不是Long类型，而a+b自动装箱的是Integer类型*/
        System.out.println(g.equals(a + b));
        System.out.println(g.equals(a + h));
    }
}
