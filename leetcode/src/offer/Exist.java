// 12. 矩阵中的路径
// https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
package offer;
// 方法一：dfs
// 注意：方向矩阵dx dy的利用；visited的处理

public class Exist {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, words, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] words, int i, int j, int k){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[k]){
            return false;
        }
        if(k == words.length - 1){
            return true;
        }
        board[i][j] = '\0';
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for(int q = 0; q < 4; q++){
            int m = i + dx[q];
            int n = j + dy[q];
            if(dfs(board, words, m, n, k+1)){
                return true;
            }
        }
        board[i][j] = words[k];
        return false;
    }
}
