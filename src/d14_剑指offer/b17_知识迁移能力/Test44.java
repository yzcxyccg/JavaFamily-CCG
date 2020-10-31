package d14_剑指offer.b17_知识迁移能力;
/**
 * 翻转单词顺序列
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”
 */
public class Test44 {
    public String ReverseSentence(String str) {
        if(str.trim().length() < 1)return str;
        char[] chars = str.toCharArray();
        //先整体反转
        reverseChar(chars,0,str.length()-1);
        int l = 0;
        //根据空格反转
        for(int  i = 0 ; i < str.length() ; i++){
            if(chars[i] == ' '){
                reverseChar(chars,l,i-1);
                l = i+1;
            }
        }
        reverseChar(chars,l,str.length()-1);
        return String.valueOf(chars);
    }
    public void reverseChar(char[] chars,int start,int end){
        while(start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;end--;
        }
    }
}
