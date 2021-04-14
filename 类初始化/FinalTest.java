package 类初始化;

import org.junit.Test;

public class FinalTest {
    public static void main(String[] args) {
        FinalTest testFinal = new FinalTest();
        int i = 0;
        testFinal.changeValue(i);
        System.out.println(i);
    }

    public void changeValue(final int i){
        //final参数不可改变
        //i++;
        System.out.println(i);
    }

    public void changeValue(StringBuffer buffer){
        //buffer重新指向另一个对象
        buffer = new StringBuffer("hi");
        buffer.append("world");
        System.out.println(buffer);
    }

    /*还有一个的是用的是final的修饰的问题了*/

    public void changeValue1(final StringBuffer buffer){
        //final修饰引用类型的参数，不能再让其指向其他对象，但是对其所指向的内容是可以更改的。
        //buffer = new StringBuffer("hi");
        buffer.append("world");
    }

    @Test
    public void main() {
        StringBuffer buffer = new StringBuffer("hello");
        changeValue1(buffer);
        System.out.println("1:"+buffer);
        /*和下面的东西是一定相同的*/
        changeValue(buffer);
    }

}
