/*
 * @lc app=leetcode.cn id=128 lang=java
 * @lcpr version=30204
 *
 * [128] 最长连续序列
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        // 1. 将所有数字放入一个哈希集合中，方便快速查找
        Set <Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int longestStreak=0;// 用于记录最长连续序列的长度
        // 2. 遍历哈希集合中的每个数字
        for(int num:set){
         // 3. 检查当前数字是否是一个连续序列的开始
        //    如果 num - 1 不在集合中，说明 num 是一个潜在的起点        
        if(!set.contains(num-1)){
            int currentnum=num;
            int currentStreak=1;// 当前连续序列的长度至少为一
            
        // 4. 从当前数字开始，向后查找连续的数字,如果存在，则更新当前数字和当前序列长度
            while(set.contains(++currentnum)){
                currentStreak++;
        }
// 5. 更新最长连续序列的长度
            longestStreak=Math.max(longestStreak,currentStreak);

        }      
        }
        // 6. 返回最长连续序列的长度
        return longestStreak;


    }
}
// @lc code=end



/*
// @lcpr case=start
// [100,4,200,1,3,2]\n
// @lcpr case=end

// @lcpr case=start
// [0,3,7,2,5,8,4,6,0,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,0,1,2]\n
// @lcpr case=end

 */

