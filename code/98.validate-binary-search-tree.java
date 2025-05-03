/*
 * @lc app=leetcode.cn id=98 lang=java
 * @lcpr version=30204
 *
 * [98] 验证二叉搜索树
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
    public boolean isValidBST(TreeNode root) {
        //
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);

    }
    /*
* 验证二叉搜索树需要确保：
节点的左子树所有节点值都小于当前节点
节点的右子树所有节点值都大于当前节点
左右子树也都是二叉搜索树
     */

     private boolean validate(TreeNode node, long min, long max) {
        // 空节点认为是有效的BST
        if (node == null) {
            return true;
        }
        
        // 检查当前节点值是否在合法范围内
        if (node.val <= min || node.val >= max) {
            return false;
        }
        
        // 递归验证左右子树
        // 左子树的所有节点值必须小于当前节点值
        // 右子树的所有节点值必须大于当前节点值
        return validate(node.left, min, node.val) 
            && validate(node.right, node.val, max);
    }

}
// @lc code=end



/*
// @lcpr case=start
// [2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// [5,1,4,null,null,3,6]\n
// @lcpr case=end

 */

