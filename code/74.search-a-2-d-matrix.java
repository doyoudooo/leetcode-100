/*
 * @lc app=leetcode.cn id=74 lang=java
 * @lcpr version=30204
 *
 * [74] 搜索二维矩阵
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
// 这段代码采用了一种非常巧妙的方法：将二维矩阵视为一个展开后的一维有序数组，然后在这个虚拟的一维数组上执行标准的二分查找。
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //判断矩阵是否为空
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //获取行数和列数
        int rows = matrix.length;
        int cols = matrix[0].length;
        //二分查找的左边界和右边界
        int left = 0;
        int right = rows * cols - 1;
        //二分查找
        while (left <= right) {
            //计算中间位置
            int mid = left + (right - left) / 2;
            //计算中间位置对应的行和列
            int midValue = matrix[mid / cols][mid % cols];//为什么要用mid/cols和mid%cols来计算行和列呢？因为我们可以将二维矩阵视为一个展开后的一维有序数组，mid/cols表示行数，mid%cols表示列数。
            //如果中间值等于目标值，返回true
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1; //目标值在右半部分
            } else {
                right = mid - 1; //目标值在左半部分
            }
        }
        return false; //如果没有找到目标值，返回false
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n3\n
// @lcpr case=end

// @lcpr case=start
// [[1,3,5,7],[10,11,16,20],[23,30,34,60]]\n13\n
// @lcpr case=end

 */

