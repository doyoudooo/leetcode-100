/*
 * @lc app=leetcode.cn id=53 lang=java
 * @lcpr version=30204
 *
 * [53] 最大子数组和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        //1.处理边界情况
        if (nums==null||nums.length==0) {
            return 0;
        }

        //用第一个数字初始化我们的关键变量
        int globalMaxSum=nums[0];//全局最大和
        int currentMaxSum=nums[0];


        //从第二个数字开始遍历（索引从1开始）

        for(int i=1;i<nums.length;i++){
            int current_number=nums[i];

            //是扩展之前的最佳结尾块，还是重新开始
            //
            currentMaxSum=Math.max(current_number,currentMaxSum+current_number);

            //
            globalMaxSum=Math.max(currentMaxSum, globalMaxSum);


        }
        return globalMaxSum;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [-2,1,-3,4,-1,2,1,-5,4]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

// @lcpr case=start
// [5,4,-1,7,8]\n
// @lcpr case=end

 */

