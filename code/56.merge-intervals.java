/*
 * @lc app=leetcode.cn id=56 lang=java
 * @lcpr version=30204
 *
 * [56] 合并区间
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[][] merge(int[][] intervals) {
        //1.处理边界情况
        if(intervals==null|| intervals.length==0){
            return intervals;
        }

        //2.按照区间起点排序
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));

        //3.遍历列表
        List<int []> merged=new ArrayList<>();
        //将第一个区间放入结果列表
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval=intervals[i];
            //获取列表中最后一个区间的
            int[] lastMergedInterval=merged.get(merged.size()-1);

            //检查是否重叠 当前区间的 start <= 上一个合并区间的 end
           if (currentInterval[0]<=lastMergedInterval[1]) {
            // 有重叠，合并区间，更新上一个合并区间的 end
            // end 取两者 end 的最大值
            lastMergedInterval[1] = Math.max(lastMergedInterval[1], currentInterval[1]);

           } else {
            // 没有重叠，将当前区间作为一个新的合并区间加入结果列表
            merged.add(currentInterval);
           } 
        }
        // 4. 将 List<int[]> 转换为 int[][]
        return merged.toArray(new int[merged.size()][]);
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,3],[2,6],[8,10],[15,18]]\n
// [[1, 6], [8, 10], [15, 18]]
// @lcpr case=end

// @lcpr case=start
// [[1,4],[4,5]]\n
// [[1, 5]]
// @lcpr case=end

 */


// @lc code=end



/*
// @lcpr case=start
// [[1,3],[2,6],[8,10],[15,18]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,4],[4,5]]\n
// @lcpr case=end

 */

