/*
 * @lc app=leetcode.cn id=230 lang=java
 * @lcpr version=30204
 *
 * [230] 二叉搜索树中第 K 小的元素
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
    public int kthSmallest(TreeNode root, int k) {
        //中序遍历二叉搜索树，得到一个有序的数组
        //然后返回第k个元素
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        //返回第k个元素
        return result.get(k - 1);
    }
    private void inorder(TreeNode node, List<Integer> result) {
        //基本情况:如果节点为空,直接返回
        if (node == null) {
            return;
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
// [3,1,4,null,2]\n1\n
// @lcpr case=end

// @lcpr case=start
// [5,3,6,2,4,null,null,1]\n3\n
// @lcpr case=end

 */

