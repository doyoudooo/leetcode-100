/*
 * @lc app=leetcode.cn id=226 lang=java
 * @lcpr version=30204
 *
 * [226] 翻转二叉树
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
    public TreeNode invertTree(TreeNode root) {
        //还是用迭代的思想，将左右节点呼唤
        if (root==null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp=root.right;

        root.right=root.left;
        root.left=temp;

        return root;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [4,2,7,1,3,6,9]\n
// @lcpr case=end

// @lcpr case=start
// [2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

