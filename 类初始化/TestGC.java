package 类初始化;

public class TestGC {
    public static void main(String[] args) {
        testGC();
    }

    public static void testGC(){
        Float f = new Float(3.14f);
        System.out.println(f);
        f = null;/*表示了就地消费掉的，会很快的GC*/
        System.out.println(f);
    }
}
