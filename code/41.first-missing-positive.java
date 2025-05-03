/*
 * @lc app=leetcode.cn id=41 lang=java
 * @lcpr version=30204
 *
 * [41] 缺失的第一个正数
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int firstMissingPositive(int[] nums) {
        // // 1. 排序数组
        // Arrays.sort(nums);

        // // 2. 遍历排序后的数组，查找缺失的第一个正数
        // int expected = 1; // 期望找到的最小正整数
        // for (int num : nums) {
        //     // 只关心正数
        //     if (num > 0) {
        //         // 如果当前数字小于期望值，说明是重复的或者更小的正数，跳过
        //         if (num < expected) {
        //             continue;
        //         } 
        //         // 如果当前数字等于期望值，说明找到了，期望值加 1
        //         else if (num == expected) {
        //             expected++;
        //         } 
        //         // 如果当前数字大于期望值，说明期望值 expected 没有出现，它就是答案
        //         else { // num > expected
        //             return expected;
        //         }
        //     }
        // }

        // // 3. 如果遍历完数组，说明从 1 到数组中最大正数（或更大）都按顺序存在
        // // 缺失的第一个正数就是最后更新的 expected 值
        // return expected;


        int n = nums.length;
        // 1. 原地哈希：将数字 x 放到索引 x-1 的位置
        for (int i = 0; i < n; i++) {
            // 循环条件：
            // 1. nums[i] 是正数
            // 2. nums[i] 在有效下标范围内 (<= n)
            // 3. nums[i] 不在它应该在的位置 (nums[nums[i] - 1] != nums[i])
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // 交换 nums[i] 和 nums[nums[i] - 1]
                int expectedIndex = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[expectedIndex];
                nums[expectedIndex] = temp;
                // 注意：交换后 nums[i] 变了，while 循环会继续检查新的 nums[i]
            }
        }

        // 2. 查找第一个 nums[i] != i + 1 的位置
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1; // 缺失的第一个正数是 i + 1
            }
        }

        // 3. 如果 [1, n] 都存在，则缺失的是 n + 1
        return n + 1;


    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,0]\n
// @lcpr case=end

// @lcpr case=start
// [3,4,-1,1]\n
// @lcpr case=end

// @lcpr case=start
// [7,8,9,11,12]\n
// @lcpr case=end

 */

