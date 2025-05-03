/*
 * @lc app=leetcode.cn id=240 lang=java
 * @lcpr version=30204
 *
 * [240] 搜索二维矩阵 II
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        // 获取矩阵的行数和列数
        int rows = matrix.length;
        int cols = matrix[0].length;

        // 从右上角开始搜索 (row = 0, col = cols - 1)
        int row = 0;
        int col = cols - 1; 

        // 当没有越界时继续搜索
        while (row < rows && col >= 0) {
            // 获取当前位置的值
            int current = matrix[row][col];
            
            if (current == target) {
                // 找到目标值，返回 true
                return true;
            } else if (current > target) {
                // 当前值比目标大，目标一定在左边
                // 排除当前列，向左移动
                col--;
            } else {
                // 当前值比目标小，目标一定在下方
                // 排除当前行，向下移动
                row++;
            }
        }
        // 搜索完毕，未找到目标值
        return false;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n5\n
// @lcpr case=end

// @lcpr case=start
// [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]\n20\n
// @lcpr case=end

 */

