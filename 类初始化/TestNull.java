package 类初始化;

import com.sun.org.apache.bcel.internal.generic.ArithmeticInstruction;

public class TestNull {
    /**
    * @null是说对象没有分配出内存的意思
     * @""表示的是没有对象。没有内存的地址上调用method会报错的。所以
    * */
    public static <ExceptionTryCatchTest> void main(String[] args) {
        String s = "a";
        int a = 3;
        String s1 = null;

        try {
            System.out.println(s1.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //==============================
        try {
            int res = a / 0;
        } catch (ArithmeticException error) {
            error.printStackTrace();
            System.out.println("除数不能为0！");
        }catch (Exception e) {
            System.out.println("the main error");
        }
    }
}
