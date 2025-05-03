/*
 * @lc app=leetcode.cn id=238 lang=java
 * @lcpr version=30204
 *
 * [238] 除自身以外数组的乘积
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 1. 边界处理
        if (nums == null || nums.length == 0) {
            return new int[0]; // 或者根据需要返回 null 或抛出异常
        }
        int n = nums.length;
        int[] answer = new int[n];

        // 2. 第一遍：计算前缀积（不包括当前元素）并存入 answer 数组
        // answer[i] 将存储 nums[0] * ... * nums[i-1]
        answer[0] = 1; // 第一个元素左边没有元素，前缀积为 1
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

    // 3. 第二遍：计算后缀积并与前缀积合并
        int rightProduct = 1; // 用于存储当前位置右侧所有元素的乘积
        for (int i = n - 1; i >= 0; i--) {
            // 对于索引 i，answer[i] 已经包含了左侧的乘积
            // 现在需要乘以右侧的乘积 rightProduct
            answer[i] = answer[i] * rightProduct;
            // 更新 rightProduct，为下一个位置 (i-1) 做准备
            rightProduct *= nums[i]; // 将当前元素乘入后缀积
        }



        return answer;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4]\n
// @lcpr case=end

// @lcpr case=start
// [-1,1,0,-3,3]\n
// @lcpr case=end

 */

