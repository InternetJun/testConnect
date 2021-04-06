# 并查集

## 基本的路径搜索问题
[路径搜索问题](https://www.nowcoder.com/practice/2a49359695a544b8939c77358d29b7e6?tpId=13&tqId=11218&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey)
~~~ java
public boolean dfs(int i, int j, int k) {
	if(i || j || board[i][j] != word[k]) {
		return false;
	}
	board[i][j] = '\0';
	boolean res = dfs()||dfs();
	board[i][j] = word[k];
	return res;
}
~~~
**具有连通性的问题，就是一个图论，并查集的问题啊！！！**
---
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

## 交换字母的位置到字典序最小
[最小的字典序](https://leetcode-cn.com/problems/smallest-string-with-swaps/)
~~~ java
//
public class UnionFind{
	public int find(int[] parent, int i) {
	}
	
	//constructor
	public void unionFind(){
	
	}
	
	public void union(){
	
	}
	
	//对数据的连通性的判断。他是需要对值的计算的。
	public double isConnected(int x, int y) {
		
	}

}
~~~





