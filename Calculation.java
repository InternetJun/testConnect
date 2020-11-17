package difficult;

import org.junit.Test;

import java.util.*;

public class Calculation {
    private boolean isOperation(String t) {
        return t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/");
    }

    private String[] getPolish(String s) {
        List<String> res = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        char[] array = s.toCharArray();
        int n = array.length;
        //累加数字，-1 表示当前没有数字
        int temp = -1;
        for (int i = 0; i < n; i++) {
            if (array[i] == ' ') {
                continue;
            }
            //遇到数字
            if (isNumber(array[i])) {
                //进行数字的累加
                if (temp == -1) {
                    temp = array[i] - '0';
                } else {
                    temp = temp * 10 + array[i] - '0';
                }
            } else {
                //遇到其它操作符，将数字加入到结果中
                if (temp != -1) {
                    res.add(temp + "");
                    temp = -1;
                }
                if (isOperation(array[i] + "")) {
                    //遇到操作符将栈中的操作符加入到结果中
                    while (!stack.isEmpty()) {
                        //遇到左括号结束
                        if (stack.peek().equals("(")) {
                            break;
                        }
                        res.add(stack.pop());
                    }
                    //当前操作符入栈
                    stack.push(array[i] + "");
                } else {
                    //遇到左括号，直接入栈
                    if (array[i] == '(') {
                        stack.push(array[i] + "");
                    }
                    //遇到右括号，将出栈元素加入到结果中，直到遇到左括号
                    if (array[i] == ')') {
                        while (!stack.peek().equals("(")) {
                            res.add(stack.pop());
                        }
                        //左括号出栈
                        stack.pop();
                    }
                }
            }
        }
        if (temp != -1) {
            res.add(temp + "");
        }
        //栈中的其他元素加入到结果
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        String[] sArray = new String[res.size()];
        //List 转为 数组
        for (int i = 0; i < res.size(); i++) {
            sArray[i] = res.get(i);
        }
        return sArray;
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

    @Test
    public void main() {
        String[] res = getPolish("(1+2)*3-6");
        System.out.println(Arrays.toString(res));
    }

    public int calculate(String s) {
        /*
            将 减法、乘法、除法 转换为 加法
            某个数 num, 如果前面的对应的运算符是 -，那么 将 -num 压入栈中
            这样，我们只需在最后将栈的元素全部弹出，完成加法操作，即可得到最终结果

            对于括号，它存在递归性质
            即
            3 * (2 + 4 * 3) + 2
          = 3 * calculate(2 + 4 * 3) + 2
          = 3 * 24 + 2
          即我们可以将括号内的字符串当作一个运算式，再递归调用本函数，最终返回一个数值
        */
        int[] i = new int[1];
        return dfs(s, i);
    }
    private int dfs(String s, int[] i){
        Deque<Integer> stack = new LinkedList<>();

        //记录某个连续的数，比如 "42"，那么我们首先 num = 4，然后遇到 2 ,num = num * 10 + 2 = 42
        int num = 0;
        char op = '+';
        for(; i[0] < s.length(); i[0]++){
            char ch = s.charAt(i[0]);

            //遇到左括号，递归运算内部子式
            if(ch == '('){
                ++i[0];
                num = dfs(s, i);
            }

            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }
            //不是数字，不是空格（运算符 或 '(' 或 ')' ） 或者 到了最后一个字符，那么根据前面记录的 op 操作符 将数字压栈，然后将新的运算符 ch 赋值给 op
            if(!Character.isDigit(ch) && ch != ' ' || i[0] == s.length() - 1){
                switch(op){
                    case '+':
                        stack.push(num); break;
                    case '-':
                        stack.push(-num); break;
                    case '*':
                        int pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                }
                num = 0;
                op = ch;
            }
            /*
            遇到右括号，退出循环，然后计算结果， 返回上一层 dfs
            这一步写在最后是因为，当 ch 为 右括号 时，那么我们需要先将前面已经得到的 num 压入栈中，再退出循环
            */
            if(ch == ')'){
                break;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }
}
