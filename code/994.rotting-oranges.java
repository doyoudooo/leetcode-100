/*
 * @lc app=leetcode.cn id=994 lang=java
 * @lcpr version=30204
 *
 * [994] 腐烂的橘子
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        //多源广度优先搜索问题（Multi-source BFS）
        //1.判断网格是否为空或长度为0 
        /* 思路
            * 1.首先，我们需要遍历整个网格，找到所有腐烂的橘子，并将它们加入队列中。
            * 2.然后，我们需要使用广度优先搜索（BFS）来处理队列中的每个腐烂的橘子。
            * 3.对于每个腐烂的橘子，我们需要检查它的四个相邻位置（上、下、左、右），
            * 如果相邻位置是新鲜的橘子，我们就将它腐烂，并将其加入队列中。
            * 4.最后，我们需要检查是否还有新鲜的橘子，如果有，就返回-1，否则返回腐烂所需的时间。
            * 5.我们还需要使用一个变量来记录腐烂的时间，每次处理完一层的腐烂橘子，就将时间加1。
            * 6.最后，我们需要返回腐烂所需的时间。
            * 7.如果没有新鲜的橘子，就返回0。
         * 
         */
        
 // 多源广度优先搜索问题（Multi-source BFS）
 if (grid == null || grid.length == 0) {
    return 0;
}

int rows = grid.length;// 行数
int cols = grid[0].length;// 列数
Queue<int[]> queue = new LinkedList<>();// 队列用于存储腐烂橘子的坐标
int freshCount = 0;// 新鲜橘子数量

// 1. 初始化队列，统计新鲜橘子数量
for (int i = 0; i < rows; i++) { // 遍历行
    for (int j = 0; j < cols; j++) {// 遍历列
        if (grid[i][j] == 2) { // 初始腐烂橘子入队
            queue.offer(new int[]{i, j});// 将腐烂橘子坐标加入队列
        } else if (grid[i][j] == 1) { // 统计新鲜橘子
            freshCount++;// 新鲜橘子数量加一
        }
    }
}

// 如果没有新鲜橘子，直接返回0
if (freshCount == 0) {
    return 0;
}

int minutes = 0;// 腐烂所需的分钟数
// 定义四个方向
int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上, 下, 左, 右

// 2. BFS过程
while (!queue.isEmpty()) {//// 当队列不为空时
    int levelSize = queue.size(); // 当前层的腐烂橘子数量
    boolean rottenInThisMinute = false; // 标记这一分钟是否有橘子变腐烂，初始为false，没有腐烂则不增加分钟数

    for (int i = 0; i < levelSize; i++) {// 遍历当前层的腐烂橘子
        int[] current = queue.poll();// 取出当前腐烂橘子坐标
        int r = current[0];// 行坐标
        int c = current[1];//

        // 检查四个方向的邻居
        for (int[] dir : directions) {// 遍历四个方向
            int nr = r + dir[0];// 新行坐标
            int nc = c + dir[1];/// 新列坐标

            // 检查边界和是否是新鲜橘子
            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {// 如果新鲜橘子
                // 变腐烂
                grid[nr][nc] = 2; // 将新鲜橘子标记为腐烂
                freshCount--;     // 新鲜橘子数量减一
                queue.offer(new int[]{nr, nc}); // 将新腐烂的橘子加入队列
                rottenInThisMinute = true; // 标记发生了腐烂
            }
        }
    }

    // 如果在这一分钟内有橘子变腐烂，时间加一
    // 注意：只有当队列在下一轮还有元素时（即rottenInThisMinute为true），才增加分钟数
    // 并且只有在处理完当前层的所有橘子后才增加分钟数
    if (rottenInThisMinute) {
         minutes++;
    }
     // 如果队列空了，但是这一分钟没有腐烂新的橘子，说明上一分钟是最后一分钟
     // 或者如果一开始就没有腐烂橘子能影响新鲜橘子，rottenInThisMinute会一直是false
     // minutes的增加逻辑放在这里更准确：只要处理完一层并且有橘子被腐烂，时间就+1
     // 修正：时间应该在处理完一层后，如果队列非空（意味着下一分钟还有橘子要处理）才增加
     // 再次修正：最简单的方式是，只要队列非空，就处理一层，处理完一层如果还有新鲜橘子没处理完，时间就+1
     // 最终修正：计算层数即可。minutes初始为0，每处理完一层（即外层while循环的一次迭代），如果队列非空（意味着下一层还有），则minutes++。
     // 但上面的rottenInThisMinute逻辑更符合“分钟”的概念。
}


// 3. 结果判断
// 如果所有新鲜橘子都腐烂了 (freshCount == 0)，返回总分钟数
// 否则，返回-1
return freshCount == 0 ? minutes : -1;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[2,1,1],[1,1,0],[0,1,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[2,1,1],[0,1,1],[1,0,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[0,2]]\n
// @lcpr case=end

 */

