# 并查集
**我的问题是不同的顺序是怎么得到不同的结果的？**
A:原因是有一个共同的变量的问题了，都是对他进行的变化，所以经过它的其他变量就会有一个一样的标准的。  
有城市圈。要求的是不同阵营一共有几个？
~~~ java
public int find(int[] parent, int ind){
	if(ind != parent[ind]) {
		parent[ind] = find(parent, parent[ind]);
	}
	return parent[ind];
}
~~~
## 对它利用我们的DFS和BFS去做
==*记住，有2个方向的时候，请写2次的邻接表啊！*==



