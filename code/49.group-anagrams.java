/*
 * @lc app=leetcode.cn id=49 lang=java
 * @lcpr version=30204
 *
 * [49] 字母异位词分组
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //创建hash表，键是排序之后的字符串，只是原始字符串
        Map< String,List<String>> map =new HashMap<>();
        
        for(String s : strs){
            //对字符串转化为字符数组进行排序
            char[] chars=s.toCharArray();
            Arrays.sort(chars);
            String sortedString= new String (chars);

            //如果键不存在，创建新列表
            if(!map.containsKey(sortedString)){
                map.put(sortedString,new ArrayList<>());
            }
            //在就加进去(先获取，再添加)
            map.get(sortedString).add(s);
        }
        //最后返回字符数组
        return new ArrayList<>(map.values());
    }
}
// @lc code=end



/*
// @lcpr case=start
// ["eat", "tea", "tan", "ate", "nat", "bat"]\n
// @lcpr case=end

// @lcpr case=start
// [""]\n
// @lcpr case=end

// @lcpr case=start
// ["a"]\n
// @lcpr case=end

 */

