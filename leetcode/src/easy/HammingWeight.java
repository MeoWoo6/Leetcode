package easy;
// 191. 位1的个数
// https://leetcode-cn.com/problems/number-of-1-bits/

// 方法一：n在第i位为1 if and only if n & 1<<i 结果为1
// 方法二：n & (n-1) 结果消一个1 需要几次运算变成0 说明有几个1
// 方法三：java 自带算法 还没研究

// 注意：
// 1. 1<<i 等价与2^n 其中 << 是位运算
// 2. & 是 位 与 运算


public class HammingWeight {
    public int hammingWeight1(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            if( ( n & (1<<i) ) != 0){
                count++;
            }
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n &= n-1;
        }
        return count;
    }

    public int hammingWeight3(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;
    }
}
