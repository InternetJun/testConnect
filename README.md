# testConnect
<font color='red'>七年，可以彻底忘记一个人。不管有多么深刻的伤痛，只需要七年都会痊愈，因为七年的时间可以把我们全身的细胞都更换掉，一个旧细胞都没有，每一天的坚持都是一种进步，每过一天，那些想念你的细胞就会死掉一些，总有一天，会干干净净?</font>
可以连接？
## 仓库的迁移
这里的是实现了从一个仓库到另一个仓库的迁移的，也成功了。
## 网上线上改变内容
利用 git fetch本地的文件和网上的保持一致的。

## 对int的最大值的表达上
<< 左移标志位， 1 << 31;表示了2^31；2……31-1；
很重要的。

![有效的分析](https://pic.leetcode-cn.com/1604740489-tzFzdh-image.png)
上图是分析出可以用归并排序的原因，无序的是可以接受的。
## 归并对逆序对的使用
2 -1 4 3的应用了。一样的思想，**太牛逼了**。
*逆序对的也是左右+交叉的总和*
## 字节的笔试换装的实现
**总共有几种情况：1，全0或者全1的时候；2,1110或者11110的时候考虑的问题有点找规律的意思**

## test image
![test](https://github.com/InternetJun/testConnect/blob/main/algorithm_complex.jpg)
## final的关键字的初始化的时机
~~~ java
class Demo{
    // int num = 10;
    //final int num2 = 20;

    int num = 10;
    final int num2; //这里num2还没有赋值，所以这里不会报错

    public Demo(){  //由于构造代码块优先于构造方法，此时再次初始化num2就报错
        num = 100;
//        num2 = 1;
    }
    {
        num2 = 88;//构造代码块先于构造方法，给num2赋值，也不会报错
    }
}
class FinalTest2{
    public static void mian(String[] args){
        Demo d = new Demo();
        System.out.println(d.num);
        System.out.println(d.num2);
    }
}
~~~
<font color = 'red'>类的初始化时机先后是：静态代码块，代码块，构造方法</font>
B extends A运行的顺序是：
...
a 代码块
a的构造
b的代码
b的构造
...
