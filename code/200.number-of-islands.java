/*
 * @lc app=leetcode.cn id=200 lang=java
 * @lcpr version=30204
 *
 * [200] 岛屿数量
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    /*
     * 遍历整个网络，发现一个未访问的陆地节点，计数器加一，同时将这个节点
     * 以及与之相连的所有陆地节点标记为已访问。这样就可以统计出一个岛屿的数量。
     */
    
    public int numIslands(char[][] grid) {
        //1.判断网格是否为空或长度为0
        if (grid == null || grid.length == 0) return 0;
        int count = 0;// 统计岛屿数量
        for (int i = 0; i < grid.length; i++) {// 遍历行
            for (int j = 0; j < grid[0].length; j++) {// 遍历列
                if (grid[i][j] == '1') {// 如果当前节点是陆地
                    count++;// 计数器加一
                    markVisited(grid, i, j);// 标记与之相连的陆地节点为已访问
                }
            }
        }
        return count;
    }

    private void markVisited(char[][] grid, int i, int j) {
        // 1.判断当前节点是否越界
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        // 2.判断当前节点是否是水或已访问
        if (grid[i][j] == '0') return;
        // 3.将当前节点标记为已访问
        grid[i][j] = '0';
        // 4.递归标记与之相连的陆地节点为已访问
        markVisited(grid, i + 1, j);// 下
        markVisited(grid, i - 1, j);// 上
        markVisited(grid, i, j + 1);// 右
        markVisited(grid, i, j - 1);// 左
    }
    //总之，通过这个岛屿数量的算法，我们可以很方便地统计出一个网格中有多少个岛屿。


}
// @lc code=end



/*
// @lcpr case=start
// [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]\n
// @lcpr case=end

// @lcpr case=start
// [["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]\n
// @lcpr case=end

 */

