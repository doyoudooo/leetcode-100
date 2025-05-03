/*
 * @lc app=leetcode.cn id=11 lang=java
 * @lcpr version=30204
 *
 * [11] 盛最多水的容器
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        //左右指正
        int left=0;
        int right=height.length-1;//max index
        int maxArea=0;

        while (left<right) {
            int currentArea= Math.min(height[left], height[right])*(right-left);

            //更新
            maxArea=Math.max(maxArea, currentArea);
            //游动较短的的那个指正

            if (height[left]<height[right]) {
                left++;
                
            }else{
                right--;//注意--
            }
        }
        return maxArea;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,8,6,2,5,4,8,3,7]\n
// @lcpr case=end

// @lcpr case=start
// [1,1]\n
// @lcpr case=end

 */

