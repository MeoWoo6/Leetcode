// 前n个数字二进制中1的个数
// https://leetcode-cn.com/problems/w3tCBm/
package easy;
// 方法一：
// 延续HammingWeight里的方法，并且利用前面已经计算的结果

public class CountBits {
    public int[] countBits(int n) {
        int[] count = new int[n+1];//default 0
        for(int i = 1; i <= n; i++){
            count[i] = count[i & (i-1)] + 1;
        }
        return count;
    }
}
