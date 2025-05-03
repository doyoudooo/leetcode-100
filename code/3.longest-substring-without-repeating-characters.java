/*
 * @lc app=leetcode.cn id=3 lang=java
 * @lcpr version=30204
 *
 * [3] 无重复字符的最长子串
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 边界检查
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // 使用HashMap存储字符及其最后出现的位置
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;  // 窗口左边界
        
        // 右指针遍历字符串
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // 如果当前字符已经在窗口中出现过
            if (map.containsKey(c)) {
                // 更新左边界到重复字符的下一个位置
                // Math.max确保左边界只向右移动
                left = Math.max(left, map.get(c) + 1);
            }
            
            // 更新字符最后出现的位置
            map.put(c, right);
            
            // 更新最大长度
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
// @lc code=end



/*
// @lcpr case=start
// "abcabcbb"\n
// @lcpr case=end

// @lcpr case=start
// "bbbbb"\n
// @lcpr case=end

// @lcpr case=start
// "pwwkew"\n
// @lcpr case=end

 */

