/*
 * @lc app=leetcode.cn id=114 lang=java
 * @lcpr version=30204
 *
 * [114] 二叉树展开为链表
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
    private TreeNode prev = null; // 用于记录上一个处理的节点

    public void flatten(TreeNode root) {
        if (root == null) return;
        
        // 保存右子树，因为后面会被覆盖
        TreeNode right = root.right;
        // 保存左子树，因为后面会被覆盖
        TreeNode left = root.left;
        
        // 如果有前一个节点，将其右指针指向当前节点
        if (prev != null) {
            prev.right = root;
            prev.left = null;
        }
        
        prev = root; // 更新 prev
        
        // 递归处理左右子树
        flatten(left);
        flatten(right);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,5,3,4,null,6]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

