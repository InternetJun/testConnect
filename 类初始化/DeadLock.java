package 类初始化;

import SpringCircle.TheOriginal;
import org.junit.Test;

import java.util.ArrayList;

/**要实现的是对死锁的demo,有o1, o2,
* @可现实是并没有造成死锁.
 * 因为我是一个线程的东西啊.
*  */
public class DeadLock {
    public static Object o1 = new Object();
    public static Object o2 = new Object();
    /*要有几个类才能这样呢?*/
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{

        },"a").start();
        try {
            synchronized (o1) {
                Thread.sleep(5000);
                synchronized (o2){
                    System.out.println("I get the o2 obj");
                }
            }
            synchronized (o2) {
                Thread.sleep(5000);
                synchronized (o1){
                    System.out.println("I get the o1 obj");
                }
            }
        } catch (InterruptedException e) {
            System.out.println("I am a dead lock!");
            e.printStackTrace();
        }


    }

    @Test
    public void main() {
        ArrayList<Object> arrayList = new ArrayList<>();
    }
}
