/*
 * @lc app=leetcode.cn id=101 lang=java
 * @lcpr version=30204
 *
 * [101] 对称二叉树
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
    public boolean isSymmetric(TreeNode root) {
        //递归判断
    // 基本情况 1，俩个都为空，对称
    if (root==null) {
        return true;
        
    }
return isMiroor(root.left, root.right);

    }

    public boolean isMiroor(TreeNode left,TreeNode right){
        //1
        if (left==null&& right ==null) {
            return true;
        }
        
        //2.有一个为空
        if(left==null&&right!=null){
            return false;
        }
        if(left!=null&&right==null){
            return false;
        }
        //3.俩个都不为空 递归比较左子树的值和右子树的值是否一样
        if (left.val!=right.val) {
            return false;
        }
        //4.递归比较左子树的左节点和右子树的右节点是否对称
        //递归比较左子树的右节点和右子树的左节点是否对称    
        return isMiroor(left.left, right.right)&&isMiroor(left.right, right.left);


    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,2,3,4,4,3]\n
// @lcpr case=end

// @lcpr case=start
// [1,2,2,null,3,null,3]\n
// @lcpr case=end

 */

