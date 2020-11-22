//对计算器的中后缀的表示
import java.util.*;

public class Main{
        public List<String> toInfixExpression(String infixExpression) {
        //存储中序表达式
        List<String> ls = new ArrayList<String>();
        int i = 0;
        String str;
        char c;
        do {
            //如果c 在 < 48 或者 > 57 说明是符号, 这里没有判断是 + , - , * , / 等等
            if ((c = infixExpression.charAt(i)) < 48 || (c = infixExpression.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else { // 说明是数字，要进行拼接处理
                str = "";
                while (i < infixExpression.length() && (c = infixExpression.charAt(i)) >= 48
                        && (c = infixExpression.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }

        } while (i < infixExpression.length());
        return ls;
    }

    /**
     * 将一个中缀表达式对应的List 转成 转换成逆波兰表达式, 放入到List中
     * @param ls
     * @return
     */
    public  List<String> parseSuffixExpression(List<String> ls) {
        Stack<String> s1=new Stack<String>();
        Stack<String> s2=new Stack<String>();
        List<String> lss = new ArrayList<String>();
        for (String ss : ls) {
            if (ss.matches("\\d+")) {
                lss.add(ss);
            } else if (ss.equals("(")) {
                s1.push(ss);
            } else if (ss.equals(")")) {

                while (!s1.peek().equals("(")) {
                    lss.add(s1.pop());
                }
                s1.pop();
            } else {
                while (s1.size() != 0 && Operation1.getValue(s1.peek()) >= Operation1.getValue(ss)) {
                    lss.add(s1.pop());
                }
                s1.push(ss);
            }
        }
        while (s1.size() != 0) {
            lss.add(s1.pop());
        }
        return lss;
    }
    
    /**
    计算出要的结果了。
    */
    public int calculate(List<String> ls) {
        Stack<String> s=new Stack<String>();
        for (String str : ls) {
            if (str.matches("\\d+")) {
                s.push(str);
            } else {
                int b = Integer.parseInt(s.pop());
                int a = Integer.parseInt(s.pop());
                int result=0;
                if (str.equals("+")) {
                    result = a + b;
                } else if (str.equals("-")) {
                    result = a - b;
                } else if (str.equals("*")) {
                    result = a * b;
                } else if (str.equals("/")) {
                    result = a / b;
                } else {
                    throw new RuntimeException("符号错误");
                }
                s.push("" + result);
            }
        }
        return Integer.parseInt(s.pop());
    }

}
class Operation{
 private static int ADDITION=1;
    private static int SUBTRACTION=1;
    private static int MULTIPLICATION=2;
    private static int DIVISION=2;

    public static int getValue(String operation){
        int result;
        switch (operation){
            case "+":
                result=ADDITION;
                break;
            case "-":
                result=SUBTRACTION;
                break;
            case "*":
                result=MULTIPLICATION;
                break;
            case "/":
                result=DIVISION;
                break;
            default:
                result=0;
        }
        return result;
    }

}
