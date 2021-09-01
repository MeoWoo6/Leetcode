package ds_array;

public class SortColors {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for(int i = 0; i <= right; i++){
            if(nums[i] == 0){
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
            }

            if(nums[i] == 2){
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
                if(nums[i] != 1){
                    i--;
                }
            }
        }
    }
}
