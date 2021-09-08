// 13. 机器人的运动范围
// https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
package offer;
// 方法一：dfs
// 注意：数位之和计算利用到了小技巧，也可用bitSum实现
public class MovingCount {
    int m, n, k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }
    public int dfs(int i, int j, int si, int sj) {
        if(i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }

    /*
    private int bitSum(int index) {
        int sum = 0;
        while(index / 10 != 0){
            sum += index % 10;
            index /= 10;
        }
        sum += index;
        return sum;
    }
     */
}
