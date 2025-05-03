/*
 * @lc app=leetcode.cn id=438 lang=java
 * @lcpr version=30204
 *
 * [438] 找到字符串中所有字母异位词
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        // 边界条件检查
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        // 字符频率计数数组（只考虑小写字母）
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        // 初始化模式串p的字符频率
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // 初始化第一个窗口的字符频率
        for (int i = 0; i < p.length(); i++) {
            if (i < s.length()) {
                sCount[s.charAt(i) - 'a']++;
            }
        }

        // 比较第一个窗口是否为p的异位词
        if (Arrays.equals(sCount, pCount)) {
            result.add(0);
        }

        // 滑动窗口
        for (int i = p.length(); i < s.length(); i++) {
            // 移出窗口最左侧的字符
            sCount[s.charAt(i - p.length()) - 'a']--;
            // 移入新的字符
            sCount[s.charAt(i) - 'a']++;

            // 检查当前窗口是否为p的异位词
            if (Arrays.equals(sCount, pCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}

// @lc code=end



/*
// @lcpr case=start
// "cbaebabacd"\n"abc"\n
// @lcpr case=end

// @lcpr case=start
// "abab"\n"ab"\n
// @lcpr case=end

 */

