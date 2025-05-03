/*
 * @lc app=leetcode.cn id=543 lang=java
 * @lcpr version=30204
 *
 * [543] 二叉树的直径
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
    // 用于记录最大直径
    private int maxDiameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return maxDiameter;
    }
    private int calculateHeight(TreeNode node) {
        // 基本情况：空节点的高度为0
        if (node == null) {
            return 0;
        }
        
        // 递归计算左右子树的高度
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        
        // 更新最大直径（左子树高度 + 右子树高度）
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        
        // 返回当前节点的高度（左右子树中较大的高度 + 1）
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n
// @lcpr case=end

 */

