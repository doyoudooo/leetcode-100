/*
 * @lc app=leetcode.cn id=46 lang=java
 * @lcpr version=30204
 *
 * [46] 全排列
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); // 存储所有排列结果
        List<Integer> path = new ArrayList<>();      // 当前排列路径
        boolean[] used = new boolean[nums.length];   // 标记数字是否使用过
        backtrack(nums, path, used, res);
        return res;


    }
    private void backtrack(int[] nums,List<Integer> path,boolean[] used,List<List<Integer>> res){
        // 如果当前路径长度等于数字数组长度，说明找到一个完整的排列
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path)); // 将当前路径添加到结果中
            return;
        }

        
        // 遍历数字数组，尝试每个数字
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue; // 如果数字已经使用过，跳过
            path.add(nums[i]);    // 将数字添加到当前路径
            used[i] = true;       // 标记数字为已使用
            backtrack(nums, path, used, res); // 递归调用，继续构建排列
            path.remove(path.size() - 1); // 回溯，移除最后一个数字
            used[i] = false;      // 标记数字为未使用，准备下一个排列
        }
    }



}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [0,1]\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

