# 正则的表示
[大佬的总结](https://www.cnblogs.com/deerchao/archive/2006/08/24/zhengzhe30fengzhongjiaocheng.html)
过难的东西。
## 零断言
eg：1，对ing单词的前面的所有的单词全部的匹配出来\\？？？
<font color="red">他是怎么去解决的？<\font>
2，对固定的单词的后面的匹配出来。
String s = "(?<=****(\s+))\w+";可以匹配出所有的固定后面的单词内容的。

## 基本的正则的模板
~~~ java
   @Test
    public void main() {
        String s = "北京(朝阳)(三里敦)(天安门)";
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(s);
        if (m.find()) {
            System.out.println(m.group());
        }
    }
~~~
## 对正则的元子符号
有\w \s...
一行的开头^,一行的最后的字符$，在\n的前面的东西。
还有的是什么的知识需要补充...
