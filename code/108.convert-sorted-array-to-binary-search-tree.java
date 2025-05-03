/*
 * @lc app=leetcode.cn id=108 lang=java
 * @lcpr version=30204
 *
 * [108] 将有序数组转换为二叉搜索树
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        /*
         * 如何才能使用有序数组构建出平衡的二叉搜索树呢？
         * 我们可以使用分治法来解决这个问题。
         * 我们可以选择数组的中间元素作为根节点，然后递归地对左半部分和右半部分进行相同的操作。
         * 这样可以确保每个节点的左子树和右子树的高度差不超过1，从而构建出平衡的二叉搜索树。
         * 
         */

        return buildBST(nums, 0, nums.length - 1);

    }
    private TreeNode buildBST(int[] nums, int left, int right) {
        // 基本情况：如果左索引大于右索引，返回null
        if (left > right) {
            return null;
        }
        // 选择中间元素作为根节点
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // 递归构建左子树和右子树
        root.left = buildBST(nums, left, mid - 1);//为社么使左半部分呢？因为中间元素是根节点，左半部分是小于根节点的元素
        root.right = buildBST(nums, mid + 1, right);
        return root;
        
    }
}
// @lc code=end



/*
// @lcpr case=start
// [-10,-3,0,5,9]\n
// @lcpr case=end

// @lcpr case=start
// [1,3]\n 
// @lcpr case=end

 */

