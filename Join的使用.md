# join()
join()的作用是对一个thread的使用完后才会有自己的结束
~~~ java
package thread;

class CustomThread1 extends Thread {
    public CustomThread1() {
        super("[CustomThread1] Thread");
    };
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(threadName + " loop at " + i);
                Thread.sleep(1000);
            }
            System.out.println(threadName + " end.");
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + ".run");
        }
    }
}

class CustomThread extends Thread {
    CustomThread1 t1;
    public CustomThread(CustomThread1 t1) {
        super("[CustomThread] Thread");
        this.t1 = t1;
    }
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " start.");
        try {
            // 线程CustomThread在t1.join();阻塞处起动，向下继续执行的结果
            t1.join();
            System.out.println(threadName + " end.");
        } catch (Exception e) {
            System.out.println("Exception from " + threadName + ".run");
        }
    }
}

class JoinTestDemo {
    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "  start.");
        CustomThread1 t1 = new CustomThread1();
        CustomThread t = new CustomThread(t1);
        try {
            t1.start();
            Thread.sleep(2000);
            t.start();
            t.join();//在代碼2里，將此處注釋掉
        } catch (Exception e) {
            System.out.println("Exception from main");
        }
        System.out.println(threadName + " end!");
    }
}

~~~
# 对futureTask和callable的question
~~~ java
package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallable implements Callable<Integer> {
    /*他的问题是什么?带返回值的
    * 支付接口的问题.
    * */

    @Override
    public Integer call() throws Exception {
        System.out.println("coming in callable");
        return 1024;
    }

    /**
     * @扩展类的东西.会阻塞主线程吗?
     * A: 会的.need time to wait;
     *
     * */
}

class Demo{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyCallable());

        Thread thread1 = new Thread(futureTask, "aa");
        thread1.start();
        while(!futureTask.isDone()){
            System.out.println("please wait...");
        }

        System.out.println("result is: " + + futureTask.get());
        /**
        * int res = 100;
        * int res2 = future.get();
        * @future需要最后的代码的.会阻塞的!利用的是
         * @while(!future.isDone()) {//就是说算完了就参与计算.
         *
         * @}
         * 多个线程的调用呢?
         * @new Thread(futureTask, "bb").start();这里的是coming 只进去一次的.会复用结果啊.
         * @new Thread(futureTask1, "bb").start();这里的话就不会了.
        * */
    }
}/*并发, 异步的东西.
    运行的是1 1 10 1s的运行东西.
    最后的是10s的任务, 你最后返回我吧.
*/
~~~

