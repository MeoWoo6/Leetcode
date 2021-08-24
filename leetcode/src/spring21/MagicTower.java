package spring21;

import java.util.PriorityQueue;

// 1 <= nums.length <= 10^5
// -10^5 <= nums[i] <= 10^5
public class MagicTower {
    public static void main(String[] args) {
        int[] nums = {-1, -1, 10};
        System.out.print(magicTower(nums));
    }
    public static int magicTower(int[] nums){
        int count = 0;
        long blood = 1;
//        if the sum is negative, then return -1
        for(int i = 0; i < nums.length; i++){
            blood += nums[i];
        }
        if(blood < 0){
            return -1;
        }else{
            blood = 1;
        }
//        if not, then we can visit all rooms
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                pq.offer(nums[i]);
            }
            blood += nums[i];
            if(blood <= 0){
                count++;
                blood -= pq.poll();
            }
        }
        return count;
    }
}
