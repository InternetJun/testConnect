# 简单的死锁的例子
自己的实现：
~~~ java
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
}
~~~
<font color = 'red'>并没有出现要的结果，因为我在一个线程内完成的工作啊。但是死锁必须至少有2个线程争抢资源的。</font>
# SomeThink
这是我2020年参加秋招的各种程序题目的总结。
# 顺便记录下自己的心情
从9月份开始一直到11月份以来，自己的心一直很闷，觉得快到成功的彼岸的时候
生活却狠狠的又给你一击。我学到的东西有如下几条:
1，自信
我面试了一家名叫金智教育的公司，我回想自己的回答自己都不敢回想，必须要自信。
2，我学会了大人模样的xw
在HR面前要表现的自己对公司的忠诚，对这公司的热爱，对......
3，我学会了乐观与积极
不管对谁请保持中立的态度，不要怨气冲天，不要负能量那么多，
想想世界的美好，虽然知道生活在这世界的不容易，知道某某的
tl。可是还有github这个大社区呢，还有游戏的陪伴，还有代码
给自己带来的那种美的欣赏。
## 动物园
下午去的是红山动物园，看了宁静的动物园环境，看了慵懒的熊猫和
漂亮的鹈鹕。原来动物带来的感觉和感官是那么的美好。
## 对数据的斜率的表达
左右边界的问题表示是
~~~ java
int n = 0;
for(int i = 0; i < n; i++) {
  int j = i-1;
  while(j >= 0) {
  }
  int j = i+1;
  while(j < n) {
  }
  if(n > min) {
    min = n;
  }
}
~~~
## 对单词搜索思考
1.自己去做的是对数据的依次比较，但是有这样的做法是最高的复杂度。
2.可以知道的是对于小写字母的26个进行比较的话，复杂度可以忽略不计的。
3.对于List内的元素判断的话需要转换Set，因为set内有contains的method，时间复杂度是O（1）。
## do while
他的问题是最少被执行一次的。
类执行顺序？
## git的使用
git 在拉取一个仓库的内容后要是想添加文件的话，需要做下面2个大动作：
1， git pull --rebase origin master还有回复现场的作用了。
2， push -u origin master

