/*
 * @lc app=leetcode.cn id=94 lang=java
 * @lcpr version=30204
 *
 * [94] 二叉树的中序遍历
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.List;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        //中序遍历 左中右
        List<Integer> result=new ArrayList<>();
        inorder(root, result);
        return result;

    }
    private void inorder(TreeNode node,List<Integer> result){
        //基本情况:如果节点为空,直接返回
        if (node==null) {
            return ;
        }
        //递归遍历左子树
        inorder(node.left, result);
        //访问当前节点
        result.add(node.val);
        //递归遍历右子树
        inorder(node.right, result);



    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,null,2,3]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

