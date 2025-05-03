/*
 * @lc app=leetcode.cn id=239 lang=java
 * @lcpr version=30204
 *
 * [239] 滑动窗口最大值
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 处理边界情况
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1]; // 结果数组
        
        // 双端队列 - 存储元素索引，而非元素值
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; i++) {
            // 步骤1: 移除队列中已经不在当前窗口的元素
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            
            // 步骤2: 移除队列中所有小于当前元素的值
            // 它们不可能是最大值了
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            // 步骤3: 将当前元素添加到队列
            deque.offerLast(i);
            
            // 步骤4: 当窗口长度达到k时，记录结果
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return result;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,3,-1,-3,5,3,6,7]\n3\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

 */

