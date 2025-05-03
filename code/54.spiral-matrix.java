/*
 * @lc app=leetcode.cn id=54 lang=java
 * @lcpr version=30204
 *
 * [54] 螺旋矩阵
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start

import java.util.ArrayList;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Scanner sc = new Scanner(System.in);

        // // 1. 读取矩阵的维度 m 和 n
        // int m = sc.nextInt();
        // int n = sc.nextInt();

        // // 2. 创建矩阵
        // int[][] matrix = new int[m][n];

        // // 3. 读取矩阵元素
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         matrix[i][j] = sc.nextInt();
        //     }
        // }

        List<Integer> result=new ArrayList<>();
        //处理空界限
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int m=matrix.length;//m是矩阵的宽
        int n=matrix[0].length;//长
        int top=0;//上边界
        int bottom=m-1;//下边界 
        int left=0;//左边界
        int right=n-1;//右边界
        while (top<=bottom && left<=right) {
            //从左到右遍历上边界
            for (int i=left;i<=right;i++){
                result.add(matrix[top][i]);
            }
            top++;//上边界下移

            //从上到下遍历右边界
            for (int i=top;i<=bottom;i++){
                result.add(matrix[i][right]);
            }
            right--;//右边界左移

            //判断是否越界
            if (top<=bottom){
                //从右到左遍历下边界
                for (int i=right;i>=left;i--){
                    result.add(matrix[bottom][i]);
                }
                bottom--;//下边界上移
            }

            //判断是否越界
            if (left<=right){
                //从下到上遍历左边界
                for (int i=bottom;i>=top;i--){
                    result.add(matrix[i][left]);
                }
                left++;//左边界右移
            }
        }
        return result;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [[1,2,3],[4,5,6],[7,8,9]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,2,3,4],[5,6,7,8],[9,10,11,12]]\n
// @lcpr case=end

 */

