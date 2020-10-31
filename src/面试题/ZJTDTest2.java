package 面试题;

/**
 * 字符串的寻找
 * 对于全由小写字母组成的字符串s，我们将其中所有的'a'移除得到新的字符串s', 我们定义t = s + s';
 * 现在给你一个字符串t，希望你判断，能不能找到满足以上规则的s；如果可以，输出s; 如果找不到，输入 :(
 * 输入
 * ababacacbbcc
 * 输出
 * ababacac
 */
public class ZJTDTest2 {
 public static String StrCZ(String str){
     if(str.length() < 2)return ":(";
     String newStr = str.replaceAll("a","");
     if(newStr.length()%2!=0)return ":(";
     String str1 = newStr.substring(0,newStr.length()/2);
     String str2 = newStr.substring(newStr.length() / 2, newStr.length());
     if(str1.equals(str2)){
         return str.substring(0,str.length() - newStr.length()/2);
     }
     return ":(";
 }

    public static void main(String[] args) {
        System.out.println(StrCZ("ababacacbbcc"));
    }
}
