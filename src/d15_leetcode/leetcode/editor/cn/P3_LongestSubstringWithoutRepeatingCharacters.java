package d15_leetcode.leetcode.editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 9249 👎 0

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * <p>
 * 2023-06-18 22:15:31
 *
 * @author chengcongguang
 */
public class P3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
        solution.lengthOfLongestSubstring("abcabcebb");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            int start = 0;//滑动窗口的开始值
            int maxlen = 0;
            Map<Character, Integer> map = new HashMap<>();//存储窗口内字符跟位置
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (map.containsKey(ch)) {
                    //map中包含字符，则出现重复字符,窗口后移
                    start = Math.max(start, map.get(ch) + 1);
                }
                map.put(ch, i);
                maxlen = Math.max(maxlen, i - start + 1);
            }
            return maxlen;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}