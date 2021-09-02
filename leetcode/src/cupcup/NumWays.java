package cupcup;
// LCP07 传递信息
// https://leetcode-cn.com/problems/chuan-di-xin-xi/
// n: the number of members
// m: the length of the relation array
// k: steps

import java.util.ArrayList;
import java.util.List;
// 方法一
// 深度优先搜索
// 时间复杂度 O(n^k)
// 空间复杂度 O(m+n+k)
public class NumWays {
    int n, k, ways; // 成员变量需要
    List<List<Integer>> edgelist; //方便得到邻居

    public int numWays(int n, int[][] relation, int k) {
        ways = 0;
        this.k = k;
        this.n = n;
        edgelist = new ArrayList<List<Integer>>();
        for(int i = 0; i < n; i++){
            edgelist.add(new ArrayList<Integer>());
        }
        for (int[] ints : relation) {
            edgelist.get(ints[0]).add(ints[1]);
        }
        dfs(0, 0);
        return ways;
    }

    public void dfs(int curr, int steps){
        if(steps == k){
            if(curr == n-1){
                ways++;
            }
            return;
        }
        for(int next : edgelist.get(curr)){
            dfs(next, steps+1);
        }
    }
}
