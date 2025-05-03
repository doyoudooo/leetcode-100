/*
 * @lc app=leetcode.cn id=15 lang=java
 * @lcpr version=30204
 *
 * [15] 三数之和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List <List<Integer>> result=new ArrayList<>();
        //先排序，再去重和使用双指针
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
                //如果第一个数大于0，因为已排序，不肯能三者和为0
            if(nums[i]>0) break;

            //跳过重复的第一个数
            if (i>0 && nums[i]==nums[i-1]) {
                continue;
            }

            //双指针在剩余部分寻找和为-nums[i]的两个数
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum < 0) {
                    // 和太小，左指针右移
                    left++;
                } else if (sum > 0) {
                    // 和太大，右指针左移
                    right--;
                } else {
                    // 找到一组解
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // 跳过重复元素
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    // 继续寻找其他解
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [-1,0,1,2,-1,-4]\n
// @lcpr case=end

// @lcpr case=start
// [0,1,1]\n
// @lcpr case=end

// @lcpr case=start
// [0,0,0]\n
// @lcpr case=end

 */

