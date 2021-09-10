// 15. 三数之和
// https://leetcode-cn.com/problems/3sum/

package ds_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while(left < right){
                if((nums[left] + nums[right] + nums[i]) == 0){
                    List<Integer> tuples = new ArrayList<>();
                    tuples.add(nums[i]);
                    tuples.add(nums[left]);
                    tuples.add(nums[right]);
                    res.add(tuples);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    while (left < right && nums[right] == nums[right + 1]) right--;

                }else if((nums[left] + nums[right] + nums[i]) > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans; // 我没有判断这个
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break; // 我也没加这个== 如果大于0 后面的都为正数，那就不可能三数之和为零
            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去除nums[i]重复
            int target = -nums[i]; // 嗯。。有target看上去好看点
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]))); // 好的 学习下这个写法
                    left++; right--; // 不管咋地 这里都要++ --
                    while (left < right && nums[left] == nums[left - 1]) left++; // 嗯！这里的left<right 一定得要，不然会out of bounds
                    while (left < right && nums[right] == nums[right + 1]) right--; //同上
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }
}
