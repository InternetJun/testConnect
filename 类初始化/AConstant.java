package 类初始化;

import org.junit.Test;

public class AConstant {
    public int anInt = 1;
    public void t(){
        System.out.println("I am not important");
    }

    @Test
    public void main(){
        boolean f = backspaceCompare("a#b##","ab##");
        System.out.println(f);
    }

    public boolean backspaceCompare(String S, String T) {
        int len = S.length();
        int lenT = T.length();
        if(len == 0 && lenT == 0){
            return true;
        }

        //基本的情况。要是有多个的空格呢？
//        String sS = getSubString(S);
//        System.out.println(sS.length());
        String sT = getSubString(T);
        System.out.println(sT.length());
        return true;

    }

    public String getSubString(String s){
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c=='#'){
                if(sb.length()>0){
                    sb.deleteCharAt(sb.length()-1);
                }
                continue;/*haiyou的是一个break;*/
            }
            sb.append(c);
        }
        return sb.toString();
    }
}

class BConstant extends AConstant{
    public int anInt = 2;
    public void t(){
        System.out.println("I am important");
    }
}

class TestC{
    public static void main(String[] args) {
        AConstant bConstant = new BConstant();
        System.out.println(bConstant.anInt);//没有的话直接是用了。
    }


}
