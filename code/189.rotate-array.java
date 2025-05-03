/*
 * @lc app=leetcode.cn id=189 lang=java
 * @lcpr version=30204
 *
 * [189] 轮转数组
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
     int n=nums.length;
     //1.处理k，使其再【0,n-1】范围内
     
     k%=n;
     if (k==0) {
        return;
     }

     //2.三次反转
     reverse(nums,0, n-1);//反转真个数组
     reverse(nums, 0, k-1);//反转钱k个元素
     reverse(nums, k, n-1);//反转后n-k个元素

     

    }
    /**
     * 辅助方法：反转数组 nums 的指定区间 [start, end]
     * @param nums 数组
     * @param start 起始索引（包含）
     * @param end 结束索引（包含）
     */
    private void reverse(int[] nums,int start,int end){
        while (start<end) {
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }

    }

}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5,6,7]\n3\n
// @lcpr case=end

// @lcpr case=start
// [-1,-100,3,99]\n2\n
// @lcpr case=end

 */

