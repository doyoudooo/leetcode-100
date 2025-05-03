/*
 * @lc app=leetcode.cn id=78 lang=java
 * @lcpr version=30204
 *
 * [78] 子集
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        /*
* 这是一个典型的回溯问题，我们可以用以下方式解决：
对于每个元素，我们都有两个选择：
选择这个元素（加入当前子集）
不选择这个元素（不加入当前子集）
递归树:
         */
        List<List<Integer>> result = new ArrayList<>();//双重列表，存储所有子集//每个子集是一个列表
        // tempList(new ArrayList<>())是一个临时列表，用于存储当前子集
        backtrack(result, new ArrayList<>(), nums, 0);
//从0开始，表示从第一个元素开始, 即从nums[0]开始
        // 递归函数的参数是result, tempList, nums和start
        return result;
    }

    // 递归函数，result是存储所有子集的列表，tempList是当前子集的列表，nums是输入数组，start是当前元素的索引
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {//递归回溯函数
        //1. 添加当前子集到结果列表中
        result.add(new ArrayList<>(tempList));//一开始是空的子集[]，然后添加元素  这里使用new ArrayList<>(tempList)是为了创建一个新的列表，避免后续的修改影响到结果列表中的子集

        //2. 遍历数组，从start开始
        for (int i = start; i < nums.length; i++) {//
            tempList.add(nums[i]);//将当前元素添加到子集中
            //3. 递归调用，继续构建子集，start是i+1，表示下一个元素
            backtrack(result, tempList, nums, i + 1);
            //4. 回溯，移除最后一个元素，准备下一个子集
            // 这里使用tempList.remove(tempList.size() - 1)是为了移除最后一个元素，准备下一个子集
            tempList.remove(tempList.size() - 1);
        }
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n
// @lcpr case=end

 */

