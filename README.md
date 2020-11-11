# 动态规划解决的问题
dp[i][j]的定义是什么？
dp(i, j) = j为下一个的字母，i为是一个上一个的字母。注意的是可以顺时针和逆时针的。所以的是有
dp = math.min(dp, math.min())+1;
~~~
g
[1, 4144959, 4144959, 4144959, 4144959, 4144959, 2]
[4144959, 4144959, 4, 5, 4144959, 4144959, 4144959]
4
要输出的内容有每一个和前一个的联系内容。
~~~
# leetcode下一个排列
![动图](https://assets.leetcode-cn.com/solution-static/31/31.gif)
思路:
1, 从右到左第一个下降的数
2, 一样的方向第一个比找出的数大
3, 对找出的数的以后序列进行逆序的输出。
~~~ java
while(i >= 0 && nums[i] >= nums[i+1]){
    i--;
}
if(i >= 0){
    int j = nums.length-1;
    while(j >= 0 && nums[j] <= nums[i]){
        j--;
    }
    swap(nums, i, j);
    reverse(nums, i+1);
}

//只要left < right;
public void reverse(int[] nums, int i){
    int R = nums.length-1;
    int L = i;
    while(L < R){
        swap(nums, L, R);
        L++;
        R--;
    }
}
~~~
# mysql遇到的问题
Could not open unix socket lock file /tmp/mysql.sock.lock；
他是需要去解决的。要是不能connect的话，可以添加映射就好了，
# 声网的一个编程
**Q:一个数由n个1组成，不可以被2或5整除，但是可以被3整除。求出最小的符合条件数的位数是几个？**
A:1，*3可以除的话就会有各个数的和为3的倍数的。*
2，还有什么的条件呢？觉得有点问题。

# 20201109
记录了对优先队列的使用的，但还是要记录一点的。怎么获取原来的数组呢？用int[][]来保存，第一个为欧氏距离，第二个是第i个元素。
在获取的时候就有points[i]时的数组了;
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
![test](https://github.com/InternetJun/testConnect/blob/main/algorithm_complex.png)
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
## 关系型和非关系型
CAP的关系。
1，c：一致型。
2，a：意思是只要收到用户的请求，服务器就必须给出回应。
3，p：即分区容忍性，这里的分区是指网络意义上的分区。由于网络是不可靠的，所有节点之间很可能出现无法通讯的情况，在节点不能通信时，要保证系统可以继续正常服务。
---
关系型:用户的一些附属东西。关系型数据库的最大优点就是事务的一致性，这个特性，使得关系型数据库中可以适用于一切要求一致性比较高的系统中。比如：银行系统。
非...:
![数据库的cap](https://img-blog.csdn.net/20180927215842663?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3UwMTMzMzIxMjQ=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
## 分布式
他是一个对自己系统的负责和透明，还有可以和其他系统的联系。
百度百科：==所以分布式系统具有高度的内聚性和透明性。==
