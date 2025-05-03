/*
 * @lc app=leetcode.cn id=34 lang=java
 * @lcpr version=30204
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    //O(log n) 的时间复杂度要求强烈暗示需要使用二分查找
    public int[] searchRange(int[] nums, int target) {
        //查找第一个位置
        int first = findFirst(nums, target);
        if (first == -1) {
            return new int[]{-1, -1};
        }

        //查找最后一个位置
        int last = findLast(nums, target);
        //返回结果
        return new int[]{first, last};

    }
      // 查找第一个等于 target 的位置
    private int findFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstPos = -1; // 初始化为 -1，表示未找到

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                // 如果 nums[mid] >= target，说明第一个 target 可能在 mid 或其左侧
                if (nums[mid] == target) {
                    firstPos = mid; // 记录当前找到的 target 位置
                }
                right = mid - 1; // 继续向左搜索更早的位置
            } else { // nums[mid] < target
                // 如果 nums[mid] < target，说明第一个 target 必定在 mid 右侧
                left = mid + 1;
            }
        }
        return firstPos; // 返回找到的第一个位置，或 -1
    }

    // 查找最后一个等于 target 的位置
    private int findLast(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastPos = -1; // 初始化为 -1，表示未找到

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                // 如果 nums[mid] <= target，说明最后一个 target 可能在 mid 或其右侧
                if (nums[mid] == target) {
                    lastPos = mid; // 记录当前找到的 target 位置
                }
                left = mid + 1; // 继续向右搜索更晚的位置
            } else { // nums[mid] > target
                // 如果 nums[mid] > target，说明最后一个 target 必定在 mid 左侧
                right = mid - 1;
            }
        }
        return lastPos; // 返回找到的最后一个位置，或 -1
    }
}
// @lc code=end



/*
// @lcpr case=start
// [5,7,7,8,8,10]\n8\n
// @lcpr case=end

// @lcpr case=start
// [5,7,7,8,8,10]\n6\n
// @lcpr case=end

// @lcpr case=start
// []\n0\n
// @lcpr case=end

 */

