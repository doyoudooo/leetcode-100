/*
 * @lc app=leetcode.cn id=76 lang=java
 * @lcpr version=30204
 *
 * [76] 最小覆盖子串
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
        //特殊判断
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        //need 存储 t 中字符的需求量
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // window 存储当前窗口中字符的数量
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0; // 滑动窗口的左右边界 [left, right)
        int valid = 0; // 窗口中满足 need 条件的字符种类数
        // 记录最小覆盖子串的起始索引和长度
        int start = 0;
        int minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 注意：这里用 equals 比较 Integer 对象
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    // 注意：这里用 equals 比较 Integer 对象
                    if (window.get(d).equals(need.get(d))) {
                        valid--; // 只有当某个字符刚好满足need时移出，valid才减1
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

  // 返回最小覆盖子串，如果没找到则 minLen 保持为初始值
  return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);




    }
}


// @lc code=end



/*
// @lcpr case=start
// "ADOBECODEBANC"\n"ABC"\n
// @lcpr case=end

// @lcpr case=start
// "a"\n"a"\n
// @lcpr case=end

// @lcpr case=start
// "a"\n"aa"\n
// @lcpr case=end

 */

