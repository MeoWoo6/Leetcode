// 1. 两数之和
// https://leetcode-cn.com/problems/two-sum/
package ds_hash;
import java.util.Map;
import java.util.HashMap;

public class TwoSum {
    // 官方题解
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>(); // 嗯 这个我记得==
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) { // 嚯！这个判定条件妙啊 可以避免同一个元素重复使用
                return new int[]{hashtable.get(target - nums[i]), i}; // 啥时候用{} 啥时候用（）
            }
            hashtable.put(nums[i], i); // 存储的是值和坐标
        }
        return new int[0];
    }
}
