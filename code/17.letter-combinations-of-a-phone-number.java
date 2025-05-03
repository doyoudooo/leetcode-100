/*
 * @lc app=leetcode.cn id=17 lang=java
 * @lcpr version=30204
 *
 * [17] 电话号码的字母组合
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    // 数字到字母的映射
    private String[] letterMap = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        // 处理空输入
        if (digits == null || digits.length() == 0) {
            return results;
        }
        
        // 开始回溯
        backtrack(digits, 0, new StringBuilder(), results);
        return results;
    }
    private void backtrack(String digits, int index, StringBuilder current, List<String> results) {
        // 如果当前组合长度等于输入长度，加入结果集
        if (index == digits.length()) {
            results.add(current.toString());
            return;
        }
        
        // 获取当前数字对应的字母字符串
        String letters = letterMap[digits.charAt(index) - '0'];
        //例如，输入"23"，则index=0时,letters为"abc";index=1时,letters为"def"

        // 遍历每个字母
        for (char letter : letters.toCharArray()) {
            // 添加当前字母
            current.append(letter);//例如'abc'的第一个字母'a'添加到current中
            // 递归处理下一个数字
            backtrack(digits, index + 1, current, results);
            // 回溯，删除最后添加的字母
            current.deleteCharAt(current.length() - 1);
        }
    }
/*
 * 
 * 对于这道电话号码字母组合题，面试总结的一句话是：

"这是一个典型的回溯算法问题，通过数字到字母的映射和递归回溯，我们可以系统地构建所有可能的组合，关键在于理解'选择'和'撤销选择'的过程，以及使用 StringBuilder 来优化字符串操作的性能。"

这句话涵盖了：

问题类型（回溯算法）
核心思路（映射+递归）
关键点（选择与撤销）
优化方向（StringBuilder）
这样的总结既展示了对问题的深入理解，也体现了实现细节的考虑。
 */
}
// @lc code=end



/*
// @lcpr case=start
// "23"\n
// @lcpr case=end

// @lcpr case=start
// ""\n
// @lcpr case=end

// @lcpr case=start
// "2"\n
// @lcpr case=end

 */

