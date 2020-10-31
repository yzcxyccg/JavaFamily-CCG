package d14_剑指offer.b14_分解让复杂问题简单;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c
 * 所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Test27 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<String>();//根据返回类型需要
        if(str==null||str.length()==0){
            return result;
        }
        char[] chars = str.toCharArray();
        TreeSet<String> res = new TreeSet<String>(); //用于排序输出
        getResult(chars,0,str.length()-1,res);
        result.addAll(res) ;//添加到ArrayList
        return result ;
    }
    public void getResult(char[] chars,int start,int end,TreeSet<String> res){
        if(start==end)res.add(String.valueOf(chars));
        else{
            for(int i=start;i<=end;i++){
                swap(chars,start,i);
                getResult(chars,start+1,end,res);
                swap(chars,start,i);//在换回来
            }
        }
    }
    public void swap(char[] chars,int a,int b){
        if(a==b)return;
        else{
            char temp = chars[a];
            chars[a] = chars[b];
            chars[b] = temp;
        }
    }

    public static void main(String[] args) {
        Test27 test27 = new Test27();
        System.out.println(test27.Permutation("12345"));
    }
}
