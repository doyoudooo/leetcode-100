/*
 * @lc app=leetcode.cn id=33 lang=java
 * @lcpr version=30204
 *
 * [33] 搜索旋转排序数组
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // 找到目标值
            }  // 判断 [left...mid] 是否有序
            if (nums[left] <= nums[mid]) {
                // 左半部分有序
                if (nums[left] <= target && target < nums[mid]) {
                    // target 在有序的左半部分
                    right = mid - 1;
                } else {
                    // target 在右半部分
                    left = mid + 1;
                }
            } else {
                // 右半部分 [mid...right] 有序
                if (nums[mid] < target && target <= nums[right]) {
                    // target 在有序的右半部分
                    left = mid + 1;
                } else {
                    // target 在左半部分
                    right = mid - 1;
                }
            }
        }
        return -1; // 未找到目标值
    }
}
// @lc code=end



/*
// @lcpr case=start
// [4,5,6,7,0,1,2]\n0\n
// @lcpr case=end

// @lcpr case=start
// [4,5,6,7,0,1,2]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n0\n
// @lcpr case=end

 */

