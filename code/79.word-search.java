/*
 * @lc app=leetcode.cn id=79 lang=java
 * @lcpr version=30204
 *
 * [79] 单词搜索
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        // 尝试以每个单元格为起点进行搜索
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
     // 回溯函数，检查从(i,j)开始是否能找到word[k..]
     private boolean backtrack(char[][] board, String word, int i, int j, int k) {
        // 1. 如果已经匹配了整个单词，返回true
        if (k == word.length()) {
            return true;
        }
        
        // 2. 检查边界条件和当前字符是否匹配
        int rows = board.length;
        int cols = board[0].length;
        
        if (i < 0 || i >= rows || j < 0 || j >= cols || board[i][j] != word.charAt(k)) {
            return false;
        }
        
        // 3. 标记当前单元格为已访问（避免重复使用）
        char temp = board[i][j];
        board[i][j] = '#';  // 使用特殊字符标记
        
        // 4. 向四个方向搜索剩余部分
        boolean found = backtrack(board, word, i+1, j, k+1) ||  // 下
                        backtrack(board, word, i-1, j, k+1) ||  // 上
                        backtrack(board, word, i, j+1, k+1) ||  // 右
                        backtrack(board, word, i, j-1, k+1);    // 左
        
        // 5. 恢复当前单元格的值（回溯）
        board[i][j] = temp;
        
        return found;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCCED"\n
// @lcpr case=end

// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"SEE"\n
// @lcpr case=end

// @lcpr case=start
// [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]\n"ABCB"\n
// @lcpr case=end

 */

