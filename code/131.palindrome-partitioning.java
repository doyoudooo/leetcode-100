/*
 * @lc app=leetcode.cn id=131 lang=java
 * @lcpr version=30204
 *
 * [131] 分割回文串
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

/*
    尝试所有可能的分割方案
    对于每个位置，有两种选择：切分或不切分
    只有当切分出的子串是回文串时，才继续递归
    当遍历到字符串末尾时，将当前分割方案加入结果集
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(s, 0, path, result);
        return result;
    }
    private void backtrack(String s, int start, List<String> path, List<List<String>> result) {
    //1.终止条件：已处理完成整个字符串
    if (start>=s.length()) {
        result.add(new ArrayList<>(path));
        return;
    }
    //尝试所有可能的分割点
    for(int end =start;end<s.length();end++){
        //如果从start到end的子串是回文串
        if (isPalindrome(s, start, end)) {
        // 加入当前回文串 
        path.add(s.substring(start, end+1));
        //递归处理剩余部分
        backtrack(s, end+1, path, result); 
        //回溯
        path.remove(path.size()-1);      
        }
    }  
}

private boolean isPalindrome(String s,int start,int end){
    while (start<end) {
        if (s.charAt(start)!=s.charAt(end)) {
            return false;
        }
        start++;
        end--;
    }
    return true;
}
/*总结一下这个题目就是：这个题目要求我们将字符串分割成多个回文串 

    1.我们可以使用回溯算法来解决这个问题，尝试所有可能的分割方案
    2.对于每个位置，我们有两种选择：切分或不切分
    3.只有当切分出的子串是回文串时，才继续递归
    4.当遍历到字符串末尾时，将当前分割方案加入结果集
 */
}
// @lc code=end



/*
// @lcpr case=start
// "aab"\n
// @lcpr case=end

// @lcpr case=start
// "a"\n
// @lcpr case=end

 */

