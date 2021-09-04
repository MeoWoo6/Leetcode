// 剑指offer04 二维数组中的查找
// https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/

// 方法一：
// 把二维数组看成二叉搜索树
package offer;

public class FindNumberIn2DArray {
    // int[][] matrix;
    // int target;
    // public boolean findNumberIn2DArray(int[][] matrix, int target) {
    //     this.matrix = matrix;
    //     this.target = target;
    //     int n = matrix.length;
    //     if(n == 0){
    //         return false;
    //     }
    //     int m = matrix[0].length;
    //     return findNumber(0, m-1);
    // }

    // public boolean findNumber(int n, int m){
    //     if(n >= matrix.length || m < 0){
    //         return false;
    //     }
    //     int flag = matrix[n][m];
    //     if(flag == target){
    //         return true;
    //     }else if(flag > target){
    //         findNumber(n+1, m);
    //     }else{
    //         findNumber(n, m-1);
    //     }
    //     return false;
    // }
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)
        {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
}
