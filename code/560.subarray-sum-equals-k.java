/*
 * @lc app=leetcode.cn id=560 lang=java
 * @lcpr version=30204
 *
 * [560] 和为 K 的子数组
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int subarraySum(int[] nums, int k) {
        // 记录结果：和为k的子数组数量
        int count = 0;
        // 记录前缀和
        int sum = 0;
        // 哈希表：key是前缀和，value是该前缀和出现的次数
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        
        // 初始化：前缀和为0的情况出现1次（空数组）
        prefixSumCount.put(0, 1);
        
        for (int num : nums) {
            // 累加前缀和
            sum += num;
            
            // 查找是否存在sum-k的前缀和
            // 如果存在，说明从之前某个位置到当前位置的子数组和为k
            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }
            
            // 更新前缀和的出现次数
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,1,1]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3]\n3\n
// @lcpr case=end

 */

