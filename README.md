# 对字母的编码（）
原题的解决。A-Z对应于1~26的分析：
![最佳的分析](https://pic.leetcode-cn.com/c09dc70d3085792b2b8417843e297f6841fd12f921b0e4fe28a2c4a8dc86dd1e-image.png)
但携程考虑的是对0~25的编码呢？
~~~ java
 public int numDecodings(String s) {
     /*   if (s.charAt(0) == '0') {
            return 1;
        }*/
        int pre = 1, curr = 1;
        for (int i = 1; i < s.length(); i++) {
            int tmp = curr;
            if (s.charAt(i)== '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    curr = pre+curr;
                }else if(s.charAt(i - 1) > '2'){
                    curr = pre;
                }
            }else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i - 1) <= '5')){
                curr = curr + pre;}
            else if (s.charAt(i-1) == 0){
                curr = pre;
            }
            pre = tmp;
        }
        return curr;
    }
~~~
**他主要是对0的特殊的处理啊。还有压缩空间的问题。**
# 最小的箭（leetcode-452）
他和之前的题目有轻微的区别的。需要怎么处理呢？
**liyong Arrays.sort(points, (p1,p2)-> p1[1] < p2[1] ? -1: 1)**
进行升序排序。重要的是不能超出***范围啊***
# 对链插入排序
~~~ java
  有几行的代码
  last.next = cur.next ;
  cur.next = pre.next;
  pre.next = cur;
~~~
2. 降低我们的复杂度呢？
利用的是我们的归并的排序

~~~ java
//对他进行的是归并排序，要的是查找中点啊
fast = head, slow = head;
while(fast.next != null && fast.ne.ne != null) {
  fast = fast.ne.next;
  slow = slow.next;
}
//还要把他们断开 
ListNode mid = slow.next;
slow.next = null;
sort(head);
sort(mid);
merge(head, mid);
return merge();

//其实对于这样的操作，是对于左右两边的排序好了的结果的。
public ListNode merge(){
  if(left == null) {
    return right;
  } else{
    return left;
  }
}

~~~
# 常用的java基本的名词
[java常用名词的解释](https://www.cnblogs.com/yw-ah/p/5795751.html)
1. POJO
简单的Java对象。
2. EJB（Enterprise JavaBean）
一组JavaBean的对象.为了满足一个业务组合成的JavaBean
3.JavaBean
必须是实现了serializable的接口的。比POJO多了点简单的逻辑内容。
还有的是可以对业务的处理了，pojo的格式就是数据的载体吧。
# 对数据的讨论问题
# 对IO流的类
FileReader；
InputStream是一个抽象类的。继承了Closed的接口
InputStreamReader是一个对文件读取内容；
BufferedReader

# 数字的构成的情况
ABCABC对应于012012；
~~~ java
//对很长的字符串，利用归并算法的思想
可以被分为如下的数组
0 12 0 1 2；
0 1 2 0 12；
0 1 20 1 2；
0 1 20 12；
一共四种的情况。
left*right+interval-1个组合；
~~~
# 对矩阵元素的搜索
题目的原题是1143。有利用的是dirs和bfs
~~~ java
int[] dc = {1, 1, -1, -1};
int[] dr = {1,-1, -1, 1};
public int[][] allDis() {
for(int dist = 1; dist < MaxDist;dist++){
  row--;
  for(DIR) {
  //他的while很重要！
    while(i % 2== 0;){
    }
  }
}
}
~~~


# 对字典的搜索
【lee127】：要求要给定了start，end，dict。要你寻找出最短的路径出来。有基本的思想是对他进行的是BFS的搜索。
~~~
有一个的问题就是要有26个小写的字母，不能构成回路的问题了。
用上一个set的集合了。
~~~
~~~ java
curChar = i;
if(dict.contains(key)) {
  if(!visit()) {
  queue.add();
  visit = !visit;
  }
}
char = curChar;
~~~
# 对二叉树的遍历的顺序的确定
[leetcode652](https://leetcode-cn.com/problems/find-duplicate-subtrees/)
相同结构的子树有多少呢？思路是
**后序遍历。原因是现要知道我的左孩子和右孩子的形状**

# 有趣的排序
要的第一个数前面有几个大于他的数，后面的数就是他的大小.很想一个找规律的数学题目。
~~~ java
 public static int[][] reconstructQueue(int[][] people) {
        // [7,0], [7,1], [6,1], [5,0], [5,2], [4,4]
        // 再一个一个插入。
        // [7,0]
        // [7,0], [7,1]
        // [7,0], [6,1], [7,1]
        // [5,0], [7,0], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [7,1]
        // [5,0], [7,0], [5,2], [6,1], [4,4], [7,1]。
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);

        LinkedList<int[]> list = new LinkedList<>();
        for (int[] i : people) {
            //i_1的是k的大小。i是里面的元素了。add(int index, E element)
            list.add(i[1], i);
        }
        for(int[] item : list){
            System.out.printf(Arrays.toString(item)+"\t");
        }

        return list.toArray(new int[list.size()][2]);
    }
~~~
# 移除k位数
对一个数字移除k个字母，后相对的位置不变的，问最小的数是多少？（[leetcode402](https://leetcode-cn.com/problems/remove-k-digits/)）
~~~
这里有一个前置知识：对于两个数 123a456 和 123b456，如果 a > b， 那么数字 123a456 大于 数字 123b456，否则数字 123a456 小于等于数字 123b456。也就说，两个相同位数的数字大小关系取决于第一个不同的数的大小
其实并没有那么难的。
~~~
**但是有一case：对于stack的内容没有被删干净，但k>0这时可以去加上
for(i < k){
    stack.pollLast();
}
**
# 有趣的排序（计数排的应用）
Leetcode1122

```java
//int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};int[] arr2 = {2,1,4,3,9,6};
public int[] sort(int[] arr1, int[] arr2) {
    //要对每一个的数字进行统计
    int[] frequences = new int[1001];      
    for(int num: arr1) {
        frequences[num]++;
    }
    int index = 0;
    for(int n : arr2) {
        /*if(frequences[n] == 0) {
            continue;
        }
        tmp[index++] = n;
        frequences[n]--;
        对一个元素重复的放入不是这样的实现的。
        */
    }
    //只剩下了只有一个的了。
}
```
2个解决办法：

1利用的是计数排序

~~~ java
public int[] sort(int[] arr1, int[] arr2) {
    //要对每一个的数字进行统计 
    int upper = 0;
    for(int x:arr1) {
    	upper = Math.max(upper, x);
    }
    int[] frequences = new int[upper+1];
    for(int item: arr1) {
        ++frequences[item];
    }
    
    int tmp = new int[arr1.length];
    int index = 0;
    for(int x: arr2) {
        for(int i = 0; i < frequences[x]; i++) {
        	tmp[i] = x;
        }
        frequences[x] = 0;
    }
    for(int x = 0; x <= upper; ++x) {
        for(int i = 0; i < frequences[x]; ++i) {
         	tmp[index++] = x;   
        }
    }
}
~~~

2利用自己自定义的排序算法。

主要的思想是有对map存储了arr2的元素和下标和list里面有arr1的所有元素。

~~~ java
Collections.sort(list,(x,y) ->{
     if(map.containsKey(x) || map.containsKey(y))
                /*x-y是需要升序的意思.
                * 就算有一个在map中,一个不在的情况,map的也是在前面的排序的.!!!
                * */
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
      return x - y;
});
~~~




# ThreadLocal
Obj不能对多线程共享的问题。
但是回收的时候是需要对key的回收和val的**回收**
![图的表示](https://upload-images.jianshu.io/upload_images/2615789-9107eeb7ad610325.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/714/format/webp)
上图中，实线代表强引用，虚线代表的是弱引用，如果threadLocal外部强引用被置为null(threadLocalInstance=null)的话，threadLocal实例就没有一条引用链路可达，很显然在gc(垃圾回收)的时候势必会被回收，因此entry就存在key为null的情况，无法通过一个Key为null去访问到该entry的value。同时，就存在了这样一条引用链：threadRef->currentThread->threadLocalMap->entry->valueRef->valueMemory,导致在垃圾回收的时候进行可达性分析的时候,value可达从而不会被回收掉，但是该value永远不能被访问到，这样就存在了内存泄漏。

# 内存屏障

4种cases: load和store的组合问题。

LS，LL，SL，SS；

# 类加载器和双亲委派

 **类加载器** 就是根据指定全限定名称将class文件加载到`JVM`内存，转为Class对象。 

BootStrap，Extension, Application.

![](https://imgconvert.csdnimg.cn/aHR0cHM6Ly91c2VyLWdvbGQtY2RuLnhpdHUuaW8vMjAxOS83LzIzLzE2YzFjNTRjZjRhZDg4NmI_aW1hZ2VWaWV3Mi8wL3cvMTI4MC9oLzk2MC9mb3JtYXQvd2VicC9pZ25vcmUtZXJyb3IvMQ?x-oss-process=image/format,png)

3）为什么需要双亲委派模型？

在这里，先想一下，如果没有双亲委派，那么用户是不是可以**自己定义一个java.lang.Object的同名类**，**java.lang.String的同名类**，并把它放到ClassPath中,那么**类之间的比较结果及类的唯一性将无法保证**，因此，为什么需要双亲委派模型？**防止内存中出现多份同样的字节码**

4）怎么打破双亲委派模型？

打破双亲委派机制则不仅**要继承ClassLoader**类，还要**重写loadClass和findClass**方法。

## JVM调优

3大args：-Xss（规定了虚拟栈的大小），-Xms（堆的初始值），-Xmx（max堆）；

## GC触发

1，System.Gc

2，系统决定的。

# JVM的内存图

![JVM](https://img-blog.csdnimg.cn/20191018124901149.jpeg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9oZWxsby5ibG9nLmNzZG4ubmV0,size_16,color_FFFFFF,t_70)

<font color='red'>method area and Heap is common</font>

虚拟机栈里有：==1，局部args；2，操作数栈；3，动态链接；4，方法返回地址。==

# 对github的某一个的文件下载
**他是做不到的，需要某个工具才能实现这样的功能。**
# 自定义的接口是怎么样的？
@Retention(保留代码的时间的问题)
@Document（@Documented用于描述其它类型的annotation应该被作为被标注的程序成员的公共API，
因此可以被例如javadoc此类的工具文档化。Documented是一个标记注解，没有成员。）
@Target()
@Inherieted(它是说被继承的)
@interface Not{

}

[关于注解的基本概念](https://www.cnblogs.com/peida/archive/2013/04/24/3036689.html)
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
