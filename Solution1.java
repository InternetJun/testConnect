package test.didi;

import org.junit.Test;

import java.sql.Time;
import java.util.Random;

/**@https://labuladong.gitbook.io/algo/gao-pin-mian-shi-xi-lie/k-ge-yi-zu-fan-zhuan-lian-biao
* 要的是对链表的改函数的！
* */
public class Solution1 {

    //可以指定字符串的某个位置是什么范围的值

    @Test
    public void testString() {
        String s = getRandomString2(29);
        System.out.println(s);
    }


    public String getRandomString2(int length){
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number= 0;
            try {
                number = random.nextInt(3);//0-2的生成。
            } catch (Exception e) {
                e.printStackTrace();
            }
            long result=0;
            switch(number){
                case 0:
                    result=Math.round(Math.random()*25+65);
                    sb.append(String.valueOf((char)result));
                    break;
                case 1:
                    result=Math.round(Math.random()*25+97);
                    sb.append(String.valueOf((char)result));
                    break;
                case 2:
                    sb.append(String.valueOf(new Random().nextInt(10)));
                    break;
            }


        }
        return sb.toString();
    }

    public String reverse(int start, int end, String s) {

        StringBuilder stringBuilder = new StringBuilder();
        while(start != end) {
            /*在这里面进行string 的反转*/
            stringBuilder.insert(0, s.charAt(start));
            start++;
        }
        return stringBuilder.toString();
    }

    public String reverseK(String s, int group) {
        if (s == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder1 = new StringBuilder();
        int groups = s.length()-s.length()%group;
        int index = 0,  pos = 0;
        while(index < groups) {
            for (int i = 0; i < group; i++) {
                /**找到b的位置, 我不要这个for循环时可以的吗?
                * @每次需要加多少呢?对吧.需要的!!!
                 *
                * */
                index++;
            }
            String temp = reverse(pos, index, s);//多个的temp怎么连接？
            stringBuilder.append(temp);
            pos =  index;
        }

        for (int i = groups; i < s.length(); i++) {
            stringBuilder1.insert(0, s.charAt(i));
        }
        stringBuilder.append(stringBuilder1);
        return stringBuilder.toString();
    }

    @Test
    public void test(){
        long time = System.currentTimeMillis();
        String s = getRandomString2(79);
        System.out.println(s);
        System.out.println(reverseK(s,5));
        /*100个char。 2 ^ 8*100*1000 ~= 10^8的处理速度
        *
        * */
        long end = System.currentTimeMillis();
        System.out.println((float) (end- time)/1000 + "s");

    }
}
