/*
 * @lc app=leetcode.cn id=48 lang=java
 * @lcpr version=30204
 *
 * [48] 旋转图像
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
        /**
     * 将 n x n 矩阵顺时针旋转 90 度 (原地操作)
     * 方法：先转置，再水平翻转
     * @param matrix n x n 的二维矩阵
     */
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix.length != matrix[0].length) {
            // 如果不是有效的 n x n 矩阵，直接返回
            return;
        }

        // 获取矩阵的维度 (n x n)
        int n = matrix.length;
        // 步骤一：转置矩阵 (沿主对角线翻转)
        // 想象沿左上到右下的对角线对折，交换对称位置的元素
        for (int i = 0; i < n; i++) {
            // j 从 i + 1 开始，确保只遍历对角线一侧，避免重复交换
            for (int j = i + 1; j < n; j++) {
                // 交换 matrix[i][j] 和 matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 转置完成后，原来的第 i 行变成了第 i 列，原来的第 j 列变成了第 j 行

        // 步骤二：水平翻转矩阵的每一行
        // 就像把每一行看作一个独立的数组，然后原地反转这个数组
        for (int i = 0; i < n; i++) {
            // 使用双指针法翻转第 i 行
            int left = 0;       // 指向行首
            int right = n - 1;  // 指向行尾
            // 当左指针还在右指针左边时，继续交换
            while (left < right) {
                // 交换 matrix[i][left] 和 matrix[i][right]
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                // 移动指针，向中间靠拢
                left++;
                right--;
            }
            // 当 left >= right 时，第 i 行翻转完成
        }
        // 经过转置和水平翻转两步后，矩阵 matrix 现在已经被原地顺时针旋转了 90 度

    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,2,3],[4,5,6],[7,8,9]]\n
// @lcpr case=end

// @lcpr case=start
// [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]\n
// @lcpr case=end

 */

