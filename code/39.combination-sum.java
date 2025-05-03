/*
 * @lc app=leetcode.cn id=39 lang=java
 * @lcpr version=30204
 *
 * [39] 组合总和
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /*
这是一个典型的回溯算法问题：
对于每个数字，我们有两种选择：选取或不选取
如果选取，由于可以重复使用，我们仍然可以再次选择它
当组合总和等于目标值时，将该组合加入结果
         */
    List<List<Integer>> result = new ArrayList<>();//双重列表，存储所有组合//每个组合是一个列表
    List<Integer> tempList = new ArrayList<>();//临时列表，用于存储当前组合

    backtrack(result, tempList, candidates, target, 0);//从0开始，表示从第一个元素开始
    return result;
    }

    //回溯
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int target, int start) {
        //1. 如果目标值为0，说明找到一个组合，将其添加到结果列表中
        if (target == 0) {
            result.add(new ArrayList<>(tempList));//使用new ArrayList<>(tempList)是为了创建一个新的列表，避免后续的修改影响到结果列表中的组合
            return;
        }
        //2. 如果目标值小于0，说明当前组合不合法，返回
        if (target < 0) return;

        //3. 遍历数组，从start开始
        for (int i = start; i < candidates.length; i++) {
            tempList.add(candidates[i]);//将当前元素添加到组合中
            //4. 递归调用，继续构建组合，start是i，表示可以重复使用当前元素
            backtrack(result, tempList, candidates, target - candidates[i], i);//注意这里是target - candidates[i]，表示减去当前元素的值
            //5. 回溯，移除最后一个元素，准备下一个组合
            tempList.remove(tempList.size() - 1);//这里使用tempList.remove(tempList.size() - 1)是为了移除最后一个元素，准备下一个组合
        }
}
}
// @lc code=end



/*
// @lcpr case=start
// [2,3,6,7]\n7\n
// @lcpr case=end

// @lcpr case=start
// [2,3,5]\n8\n
// @lcpr case=end

// @lcpr case=start
// [2]\n1\n
// @lcpr case=end

 */

