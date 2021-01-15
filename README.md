# 二维的数组对每个元素排序
**和一维数组排序对应起来哦，有点区别的**
~~~ java
Collections.sort(ls,new Compartor<int[]>(){
	@Override
	public int compare(int[] x, int[] y) {
		if(x[0] == y[0]){
			return x[1]-y[1];
		}
		return x[0]-y[0];
	}
});
~~~
# 遇到了很好玩的正则表达式
~~~notepad给每行的最后加上一个符号的实现:
*$---> }可以实现的在每行的最后加上一个};*
还有的事情表了换行的处理了.
~~~
**在testConnect种会有对文件夹读取文件的,还有的是对文件名统一去除空格的.**

~~~ windows
@echo off&setlocal enabledelayedexpansion
for /f "delims=" %%i in ('dir /s/b *.*') do (
    set "foo=%%~nxi"
    set foo=!foo: =!
    set foo=!foo: =!
    ren "%%~fi" "!foo!"
)
exit
~~~

# 对元素的补齐的问题
leetcode1229的每日一题的解释了,
# 对正则表达式的问题了
//abc{1,3}+cd和abccd是不匹配的！
  //abc{1,3}d和abccd是匹配的！
  有贪婪模式+,懒惰模式?和普通的情况.
  ~~~ java
  @Test
    public void testPlace() {
        Pattern pattern = Pattern.compile("^abc{1,3}+d$");
        Matcher matcher = pattern.matcher("abccd");
        boolean isFound = false;
        if (isFound=matcher.find()){
            System.out.println("ok");
            System.out.println(matcher.group(0));
        } else {
            System.out.println("not match!");
        }
    }
  ~~~
## 全局变量初始化的问题
***有path为一个List数组,有的问题:***
1, 对全局的变量来说,有里面的元素是没有情空空的,
而是有存在。

2, res.add(new ArrayList<>(path));他对里面的变量重新的赋值.

==要是为res.add(path);的时候有结果为:==
# 对string拆分为数组，leetcode842
分为很多块的时候呢？有什么的问题?
是一个经典的问题，就是回溯的问题，寻找一个有效解了，但是问题是说什么呢？
**我出现了2份一样的代码，没有找出原因**;
~~~ java
if(size < 2 || ls.get(size-1)+ls.get(size-2)){
	ls.add(num);
	if(dfs) {
		return true;
	}
	res.remve(size);//这是一定需要的，因为是需要回溯的东西了。
}
~~~
**1,2,3,4块的问题呢？**
# 还有的是2个元素的或运算问题
他是利用了位运算的异或操作，有的是说不同的数的掩码mask有如下的性质
diff = mask^(-mask) = 第一位的不为0的元素
当我们利用**数和diff异或**操作的时候，有不为0；
另一个数是x^mask了
# 对位运算的使用问题
`>>>`表示：正数时，在移位时，所有移位的位置都置为0;负数时所有当前位置前的原本为1的置为0，原本为0的置为1； 

a<<b，==表示`a`==转为二进制后左移b位，左移后，空位补0 

 a>>b，表示`a`转为二进制后右移b位，右移后 

```Java
System.out.println(Integer.parseInt("11",2));
//他表示的是11在2进制的编码下，需要转换为10进制，对我们可见的元素。
```

==对Integer的溢出是只有会在1<<31处的会导致了-2^31的。其他的时候会循环的移位了。==
# 单调栈的实现思路

eg1：下一个更大的元素I;

eg2：下一个更大元素II

是一个环形的数组，最后几个元素的判断没有结果的时候可以从头来过，和那个自由子路的题目很类似的感觉。

==他的思路是什么？==

· 一个是构造出我们的数组。

·对他进行求余；

在自由子路的一个循环的n中对他进行的是i，n-i的操作了。
~~~ java
for (int i = 1; i < m; ++i) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
~~~

eg3：在一个序列中，k位最大的元素，需要保持我们的队列顺序不变的。

==关键有一个变量remain，他是控制回头的次数==
# 二分法寻找左右边界的问题
1， leftBound
mid >= tar
2，rightBound	
mid <= tar
3，区间的下标的问题
~~~ java
//左边，右边的边界。还有的是说第一个不满足的位置了。
if(mid > tar/*这是对于左边的边界来说的，*/){
	right = mid -1;
	ans = mid;
} else{
	left = mid+1;
}
public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
~~~
# 字符的交替的输出的问题
有遇到一个问题是；怎么回到第一个位置呢？
aaabbcc的输出的过程是：
~~~
/*[a , a,  , a,  , b]
[a, b, a,  , a,  , b]
[a, b, a, c, a,  , b]
[a, b, a, c, a, c, b]*/
//的是偶数和奇数的问题。
for(int count: counts){
   while(count > 0){
   	if( i > n){
		i = 1;
	}
	//正常的输入数据。
	i+=2;
   }
}
~~~
# AQS的原理
[解释](https://www.jianshu.com/p/279baac48960)

1. **Sync.nonfairTryAcquire** 

2. **AbstractQueuedSynchronizer.addWaiter** 

3.  **AbstractQueuedSynchronizer.acquireQueued** 

   ==进行阻塞了.==

4. 解锁
---
非公锁实现方式就是：首先获取到当前线程，判断当前锁的状态是否为0，如果是，说明当前锁没有被其他线程占有，则利用CAS操作将锁的状态从0置为1成功后，将锁的持有者置为当前线程。

---

公平锁的实现，就是在非公平锁的实现上，加了一层判断hasQueuedPredecessors()，该方法的大概意思是判断是否有线程等待的时间比当前线程等待时间还要久，如果有返回true,则当前线程获取锁失败，如果没有返回false，当前线程获取到锁，也就是判断当前线程是否是等待队列的队头元素， 

| nextWaiter状态标志  |             说明             |
| :-----------------: | :--------------------------: |
|  SHARED(共享模式)   |      直接唤醒下一个节点      |
| EXCLUSIVE(独占模式) | 等待当前线程执行完成后再唤醒 |

 [java](http://cpro.baidu.com/cpro/ui/uijs.php?adclass=0&app_id=0&c=news&cf=1001&ch=0&di=128&fv=0&is_app=0&jk=46f05a5d5e52dd59&k=java&k0=java&kdi0=0&luki=1&mcpm=0&n=10&p=baidu&q=65035100_cpr&rb=0&rs=1&seller_id=1&sid=59dd525e5d5af046&ssp2=1&stid=9&t=tpclicked3_hc&td=1836545&tu=u1836545&u=http%3A%2F%2Fwww.bubuko.com%2Finfodetail-554279.html&urlid=0)的并发包中提供了ReadWriteLock，读-写锁。**它允许一个资源可以被多个读操作访问，或者被一个 写操作访问，但两者不能同时进行**。 

 FairSyn和NofairSync。**结论：ReentrantLock是以独占锁的加锁策略实现的互斥锁，同时它提供了公平和非公平两种锁获取方式**。 
# Java内存模型
read，write，load，use，assign，store，lock，unlock
---
# 内存泄露排查（基本的思路是什么？）
查看


情况==》查看存活对象；
基本的命令：[命令](https://blog.csdn.net/zhengwei223/article/details/77151224)
jps：status Tool；
...
# 异常的几个常见错误
**无权限，空指针，数学错误，下标，类没找到，参数错误。**
# 一次性的要取3个元素的问题
**我第一次实现的话，利用的是一个取一个，然后呢多重的循环。例如有的是三角边的获取**
可是呢，真正的是需要一次性的获取3个。A[i],A[i-1],A[i-2];
所以有的是。。。
# 对角线的矩阵元素遍历
其实他就是考了一个知识点
$$x+y=c$$一个初中都知道的线
# 排序的数字
-1：降序的意思。
1：升序的意思。

# 最长的子序列length
~~~ java
  public int lengthOfLISMe(int[] nums) {

        int len = nums.length;
        //处理长度的
        if (len == 0){
            return 0;
        }
        int[] dp = new int[len+1];
        int n = 1;
        //因为定义说的是长度为1的有max为num。
        dp[n] = nums[0];
        for (int i = 0; i < len; i++) {
            int temp = nums[i];
            if(temp > dp[n]) {
                dp[++n] = temp;
            }else{
//              要的是说有从i到num < dp[i];找不到的话，说明我们的初始化问题，更新dp[1].
                int l = 1, r = n, pos = 0;
                while(l<= r) {
                    int mid = (l+r)>>1;
                    if(nums[mid] < temp) {
                        pos = mid;
                        l = mid+1;
                    } else {
                        r = mid - 1;
                    }
                }
                dp[pos+1] = temp;
                System.out.println("dp"+(pos+1)+"num is "+ dp[pos+1]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return n;
    }
~~~
有如下几个点需要注意:
nums = [1 2 3 2 4];
1) dp数组的定义问题, dp = new int[len+1];
解释:dp的定义是长度为i,在nums中可以记录的最小的值(当然要满足递增)
有数组为len了.所以需要的是len+1的长度.
---
2) 在二分查找中.从1开始.0没有了定义.
---
3) 最后的dp输出的情况是[0, 2, 2, 3, 4, 0];
**dp的定义是i位置上最小的数了.**
---
**4) 定义的pos的作用**
为了防止一种的情况: 初始的dp[1].
# 一趟的顺序查找
1 5 2 3 5;知道了重复的是5,缺失的是4;
1-5的索引和数字是一一对应的, 要是有重复的话,第二次的进入会是负数的.
还有缺失的元素呢是对应的索引+1了.
# 对一维的排序
~~~ java
PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
	//他是2维的排序了.
Arrays.sort(points, (p1,p2)-> p1[1] < p2[1] ? -1: 1);
//还有lambda对1维的排序?
//他是对list的列表进行排序的.
 Collections.sort(list, (x, y) -> {
            if(map.containsKey(x) || map.containsKey(y)) {
                /*x-y是需要升序的意思.
                 * 就算有一个在map中,一个不在的情况,map的也是在前面的排序的.!!!
                 * */
                System.out.printf("x---"+map.getOrDefault(x, 1001)+'\t');
                System.out.printf("y---"+map.getOrDefault(y, 1001)+'\t');
                System.out.println();
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            }
            return x - y;
        });
//一维的数组排序；需要转换为Integer的类型的。要不然会报错的。
 int[] arr = { 3, 2, 1, 4, 6, 1, 8 };
Integer[] a = new Integer[arr.length];
Arrays.sort(a, (o1, o2) -> o2 - o1);
~~~

# 合并区间和视频区间的逆问题
对一个区间进行分割后, 要求最少的区间片段.
 int[][] clips ={{0,2},{4,6},{8,10},{1,9},{1,5},{5,9}};
 他的思想是贪心的算法啊.
# springSecurity对多登陆的控制
~~~ java
	.maxSessionsPreventsLogin(true);
    //还要加上的是对bean的处理啊，因为涉及到了源码的改动上和session的感知上。
    //再这样的处理是基于我们的内存的处理啊。怎么到数据库的层面上呢？ 他需要对我们的dao的类进行hascode和equals济宁重写的
    //在一次的有前后端分离的json问题。怎么处理？
~~~
**要是你还想获取他的元素值，必须要重写，才可以有我们要的元素啊~！！**
2. 对前后端项目分离中(太难了)
1.SecurityConfig的配置
2.SessionRegistryImpl实例
3.LoginFliter
4. 我们重新创建一个 ConcurrentSessionFilter 的实例，

dp记录的是len = i时的num.但是有一种的情况.
下标小于num.但是数值更大的情况.
//自己对于参考系的不确定啊, 这里的时要对nums[i]和dp的来比较啊,参考的是dp[mid]的大小.
//还有的是对一般的做法是有dp[i]表示的是i坐标下的最短长度了.
# 项目对Annation的使用
~~~ java
package com.nowcoder.community.controller.interceptor;

import com.nowcoder.community.annotation.LoginRequired;
import com.nowcoder.community.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class LoginRequiredInterceptor implements HandlerInterceptor {

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
            if (loginRequired != null && hostHolder.getUser() == null) {
                response.sendRedirect(request.getContextPath() + "/login");
                return false;
            }
        }
        return true;
    }
}

~~~
# 对字母的编码（）
原题的解决。A-Z对应于1-26的分析：
![最佳的分析](https://pic.leetcode-cn.com/c09dc70d3085792b2b8417843e297f6841fd12f921b0e4fe28a2c4a8dc86dd1e-image.png)
但携程考虑的是对0-25的编码呢？
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
题目的原题是1130。有利用的是dirs和bfs;
我们每次从该正方形边框的上顶点出发，**依次经过右顶点、下顶点和左顶点，最后回到上顶点。**
~~~ java
//他和那个bfs有点区别的其实,他的功力更好啊,还要数学的知识.
int[] dc = {1, 1, -1, -1};
int[] dr = {1,-1, -1, 1};
public int[][] allDis() {
for(int dist = 1; dist < MaxDist;dist++){
  row--;
  for(DIR) {
  //他的while很重要！
    while(i % 2== 0&&  c0!= col)|| (i%2 != 0 && r0!= row)){
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
