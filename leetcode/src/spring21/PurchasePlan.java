package spring21;

import java.util.Arrays;

public class PurchasePlan {
    public static void main(String[] args) {
        int[] nums = {2,2,1,9};
        int target = 10;
        System.out.println(purchasePlans(nums, target));
    }
    // 复杂度太高O(N*2)，超出时间限制
    public static int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i =0; i < nums.length; i++){
            int maxindex = nums.length;
            for(int j = i+1; j < maxindex; j++){
                if((nums[i] + nums[j]) <= target){
                    count++;
                }else{
                    maxindex = j;
                    break;
                }
            }
        }
        return (int)(count % (1e9 + 7));
    }

    //双指针法
    //双指针法相比之前的两层循环好处在于，当left+right满足<=target条件时，没有必要再去遍历left和小于right的对
    public static int purchasePlans2(int[] nums, int target){
        Arrays.sort(nums);
        long count = 0;
        long mod = (long) 1.000000007E9;
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            if((nums[left] + nums[right]) > target){
                right--;
            }else{
                count += right - left;
                count = count % mod;
                left++;
            }
        }
        return (int)count;
    }


}
