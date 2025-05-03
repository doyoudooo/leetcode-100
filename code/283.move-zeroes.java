/*
 * @lc app=leetcode.cn id=283 lang=java
 * @lcpr version=30204
 *
 * [283] 移动零
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0; // 指向应该放置非零元素的位置
        
        // 第一次遍历，将所有非零元素移到数组前面
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
        }
        
        // 第二次遍历，将剩余位置填充为0
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [0,1,0,3,12]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

