package cupcup;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 方法二
// 广度优先搜索
// 时间复杂度 O(n^k) **实际运行比深度优先以及动态规划慢很多，可能是队列存储的问题
// 空间复杂度 O(m+n+n^k) 其中n^k为队列的空间开销
public class NumWays2 {
    public static int numWays(int n, int[][] relation, int k) {
        List<List<Integer>> edges = new ArrayList<List<Integer>>();
        int ways = 0;
        for(int i = 0; i < n; i++){
            edges.add(new ArrayList<Integer>());
        }
        for(int[] ints : relation){
            edges.get(ints[0]).add(ints[1]);
        }

        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0);
        int steps = 0;
        while(!q.isEmpty() && steps < k){
            steps++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int start = q.poll();
                List<Integer> ends = edges.get(start);
                for(int end : ends){
                    q.offer(end);
                }
            }
        }

        if(steps == k){
            int size = q.size();
            for(int i = 0; i < size; i++){
                if(q.poll() == n - 1){
                    ways++;
                }
            }
        }

        return ways;

    }
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int[][] relation = {{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}};
        numWays(n, relation, k);
    }
}
