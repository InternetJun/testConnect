//要实现的是lru的算法.
public class LRU{
	//里面包含了doubleLinkList；HashMap的使用？
}
//要实现中缀的表达式--》后缀的表达
public class Calculation{
	public String poland(String s) {
		int len = s.length();
		//几种的情况，1，数字；2，操作数；3，括号。
		char[] chars = s.toCharArray();
		Stack stack = new Stack();
		List<String> res = new ArrayList<>();
		int temp = -1;
		for(int i = 0; i < len; i++) {
			char c = chars[i];
			if(temp == -1){
				temp = c - '0';
			} else if(isNumber(c)) {
				temp = temp * 10 + c-'0';
			} else {
				//遇到了其他的结果中，数字加入. choose 0 is not good;
				if(temp != -1) {
					res.add();
					temp = -1;
				}
				if(isOperate(c)) {
					while(!stack.isEmpty()){
						if(stack.peek().equals("(")){
							break;
						}
						res.add();//加入到一个结果解中去的，就是说的东西。
					}
					stack.push(c);
				} else{
					if(c == '(') {
						stack.push(c+"");
					} 
					if(c == ')') {
						while (!stack.peek().equals("(")) {
                            res.add(stack.pop());
                        }
                        //左括号出栈
                        stack.pop();
					}					
				}
			}
		}
	
	}
	
	public boolean isNumber(char c) {
		return c >= '0' && c <= '9';
	}
}

//要实现格雷码。
public class Solution{
	//转2进制的问题。
	public String transfer(int code){
		int head = 1;
		for(int i = 0; i < ; i++) {
			
		}
	}
}

//实现的是一个堆排序的内容。
public class HeapSort{
	//1.要的第一个非叶子节点进行adjust；
	for(int i = len/2; i >= 0; i--) {
		adjust(nums, i, len);//i的left == 2*i+1, right == 2* i + 2;
	}
	//
	for(int i = len; i>=0; i--){
		swap();
		adjust();
	}
	
	public adjust(){
		for(int k = 2*i+1; k < len; k = 2*k+1) {
		
		}
	}
}
	