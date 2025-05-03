/*
 * @lc app=leetcode.cn id=207 lang=java
 * @lcpr version=30204
 *
 * [207] 课程表
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Solution {
        /**
     * 使用拓扑排序（基于 BFS - Kahn 算法）判断课程安排是否可行。
     * 思路：
     * 1. 构建邻接表和入度数组。邻接表存储课程依赖关系（bi -> ai），入度数组记录每门课有多少先修课。
     * 2. 初始化队列，将所有入度为 0 的课程（没有先修课要求）加入队列。
     * 3. 进行 BFS：
     *    a. 从队列中取出一门课 u（表示学完了这门课）。
     *    b. 记录已学完的课程数 count 加 1。
     *    c. 遍历所有以 u 为先修课的课程 v：
     *       i. 将课程 v 的入度减 1。
     *       ii. 如果课程 v 的入度变为 0，说明它的所有先修课都已学完，将其加入队列。
     * 4. 检查结果：如果最终学完的课程数 count 等于总课程数 numCourses，则说明不存在循环依赖，可以完成所有课程，返回 true；否则返回 false。
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

// 1. 构建邻接表和入度数组
List<List<Integer>> adj = new ArrayList<>(); 
// 邻接表 adj[i] 存储所有以 i 为先修课的课程列表 adj形状是一个二维数组 例如[[1,0],[2,0]]表示课程1和课程2都依赖于课程0
int[] inDegree = new int[numCourses];      // 入度数组 inDegree[i] 存储课程 i 的先修课数量
    
for (int i = 0; i < numCourses; i++) {// 初始化邻接表 
    // 每门课程的邻接表初始化为空列表
    adj.add(new ArrayList<>());// 例如[[1,0],[2,0]]表示课程1和课程2都依赖于课程0
}

for (int[] prereq : prerequisites) {// 遍历先修课程列表
    int course = prereq[0]; // 要学习的课程
    int pre = prereq[1];    // 先修课程
    adj.get(pre).add(course); // 添加一条从 pre 指向 course 的边
    inDegree[course]++;       // course 的入度加 1
}

// 2. 初始化队列，将所有入度为 0 的课程加入队列
Queue<Integer> queue = new LinkedList<>();// 队列用于存储入度为 0 的课程
for (int i = 0; i < numCourses; i++) {// 遍历所有课程
    if (inDegree[i] == 0) {// 如果课程 i 的入度为 0
        queue.offer(i);///// 将课程 i 加入队列
    }
}

int count = 0; // 记录已完成的课程数量

// 3. 进行 BFS
while (!queue.isEmpty()) {// 当队列不为空时
    int u = queue.poll(); // 取出一门已完成先修课的课程
    count++;             // 完成课程数加 1

    // 遍历以 u 为先修课的课程 v
    for (int v : adj.get(u)) {// 遍历 u 的邻接表
        inDegree[v]--; // 将 v 的入度减 1
        if (inDegree[v] == 0) { // 如果 v 的所有先修课都已完成
            queue.offer(v);    // 将 v 加入队列
        }
    }
}

// 4. 检查结果
return count == numCourses;// 如果已完成的课程数等于总课程数，返回 true；否则返回 false

    }
}

// “这道题考察的是有向图中的环检测问题。我采用了拓扑排序的思路，具体是基于 Kahn 算法（BFS）来实现的。首先，通过邻接表和入度数组构建了课程依赖关系图。然后，将所有入度为 0 的课程（即没有先决条件的课程）放入队列。接着，通过 BFS 不断将完成先决条件的课程出队，并更新其后续课程的入度，将新的入度为 0 的课程入队。最后，通过比较完成的课程总数和总课程数是否相等，来判断是否存在循环依赖，从而确定是否能完成所有课程。

// 这种方法的时间复杂度是 O(V + E)，其中 V 是课程数（节点数），E 是先决条件数（边数），因为我们需要遍历所有节点和边一次。空间复杂度也是 O(V + E)，主要用于存储邻接表、入度数组和队列。
// @lc code=end



/*
// @lcpr case=start
// 2\n[[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// 2\n[[1,0],[0,1]]\n
// @lcpr case=end

 */

