package cupcup;

public class NumWays3 {
    public int numWays(int n, int[][] relation, int k) {
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 0; i < k; i++){
            int[] next = new int[n];
            for(int[] edges : relation){
                next[edges[1]] += dp[edges[0]];
            }
            dp = next;
        }
        return dp[n-1];
    }
}
