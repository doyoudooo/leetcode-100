/*
 * @lc app=leetcode.cn id=22 lang=java
 * @lcpr version=30204
 *
 * [22] 括号生成
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/*
 * 这是一个典型的回溯问题，可以通过以下方式解决：
1.回溯法:
    维护当前已生成的括号字符串
    维护左右括号的剩余数量
    递归生成所有可能的组合

2.核心决策规则:
    如果还有剩余的左括号，可以添加左括号
    如果右括号剩余数量 > 左括号剩余数量，可以添加右括号
    当左右括号都用完，将当前组合加入结果
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    
    /**
     * 回溯函数
     * @param result 结果列表
     * @param sb 当前括号组合
     * @param open 已添加的左括号数量
     * @param close 已添加的右括号数量
     * @param max 总括号对数
     */
    private void backtrack(List<String> result, StringBuilder sb, int open, int close, int max) {
        // 终止条件：字符串长度等于 2*n，说明左右括号都已用完
        if (sb.length() == 2 * max) {
            result.add(sb.toString());
            return;
        }
        
        // 如果左括号数量小于n，可以添加左括号
        if (open < max) {
            sb.append('(');
            backtrack(result, sb, open + 1, close, max);
            sb.deleteCharAt(sb.length() - 1); // 回溯，移除刚添加的左括号
        }
        
        // 如果右括号数量小于左括号数量，可以添加右括号
        if (close < open) {
            sb.append(')');
            backtrack(result, sb, open, close + 1, max);
            sb.deleteCharAt(sb.length() - 1); // 回溯，移除刚添加的右括号
        }
    }
}
/*
维护左右括号的计数，确保任何时候左括号数 >= 右括号数
使用StringBuilder而不是String可以提高性能
回溯时记得删除最后添加的字符，恢复状态
这个问题的本质是在决策树中找出所有有效路径
 */
// @lc code=end



/*
// @lcpr case=start
// 3\n
// @lcpr case=end

// @lcpr case=start
// 1\n
// @lcpr case=end

 */

