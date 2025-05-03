/*
 * @lc app=leetcode.cn id=35 lang=java
 * @lcpr version=30204
 *
 * [35] 搜索插入位置
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意 right 的初始值
        //二分查找
        while (left<=right) {
            int mid=left+(right-left)/2;//防止一簇溢出
            if (nums[mid]==target) {
                return mid; // 找到目标值，返回索引
            } else if (nums[mid] < target) {
                left = mid + 1; // 目标值在右半部分
            } else {
                right = mid - 1; // 目标值在左半部分
                
            }
            
        }
        return left;
        // 如果没有找到目标值，返回插入位置
        }
}
// @lc code=end



/*
// @lcpr case=start
// [1,3,5,6]\n5\n
// @lcpr case=end

// @lcpr case=start
// [1,3,5,6]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,3,5,6]\n7\n
// @lcpr case=end

 */

