package d18_其他;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 程从广
 * @Description 查找字符串中最长子串
 * @Date 创建于 2020/8/22 16:58
 */
public class Test4 {
    public static String noDuplicate(String str) {
        if(str==null||str.length()==0){
            return null;
        }
        Set<String> set = new HashSet<>();
        String result = "";
        System.out.println("length:" + str.length());
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String s = str.substring(i, j);
                set.add(s);
            }
        }
        int max = 0;
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            LinkedHashSet<String> setchar = new LinkedHashSet<>();
            String  st = iterator.next().toString();
            for (int a = 0; a < st.length(); a++) {
                setchar.add(String.valueOf(st.charAt(a)));
            }
            if(setchar.size()==st.length()){
                int len = st.length();
                if(max<len){
                    max = Math.max(max, len);
                    result = st;
                }
            }
        }
        System.out.println(max);
        return result;
    }
    public static String getMaxsubHuisu(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int start = 0;//滑动窗口的开始值
        int maxlen = 0;
        int len = 0;
        int startMaxIndex = 0;//最长子串的开始值
        Map<Character, Integer> map = new HashMap<>();//存储窗口内字符跟位置
        int i;
        for (i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer value = map.get(ch);
            if (map.containsKey(ch)) {//map中包含字符，则出现重复字符
                start = value + 1;//下一次开始的位置是，存在map中重复字符的下一个位置
                len = 0;//重新开始新的窗口，len置为0
                map = new HashMap<>();//map置空
                i=value;//下次从重复的值开始回溯
            } else {
                map.put(ch, i);//不存在重复的，就存入map
                len++;//每次进来长度自增1
                if (len > maxlen) {//如果当前的窗口长度>最长字符串则，更新最长串，跟最长子串开始位置
                    maxlen = len;
                    startMaxIndex = start;
                }
            }
        }
        return s.substring(startMaxIndex, (startMaxIndex + maxlen));
    }
    public static void main(String[] args) {
        System.out.println(getMaxsubHuisu("abcba"));
    }
}
