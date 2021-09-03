package easy;

// 方法二：
// 利用偶数n中1的个数 等于n/2中1的个数，奇数n则比n/2多一个
// 同样地，之前的计算结果可以保存，提高计算速度
public class CountBits2 {
    public int[] countBits(int n) {
        int[] count = new int[n+1];
        for(int i = 1; i <= n; i++){
            count[i] = count[i >> 1] + (i & 1);
        }
        return count;
    }
}
