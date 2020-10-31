package d15_leetcode;

/**
 * valid-palindrome
 * 判断题目给出的字符串是不是回文，仅考虑字符串中的字母字符和数字字符，并且忽略大小写
 * 例如："A man, a plan, a canal: Panama"是回文"race a car"不是回文
 * 注意：你有没有考虑过字符串可能为空？这是面试时应该提出的一个好问题。针对这个问题，我们定义空字符串是回文
 */
public class Test26 {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)return true;
        String str = s.replaceAll("\\W","");
        str = str.toLowerCase();
        int start = 0,end = str.length() - 1;
        while(start < end){
            if (str.charAt(start) == str.charAt(end)) {
                start++;end--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Test26 test26 = new Test26();
        System.out.println(test26.isPalindrome("a."));
    }
}
