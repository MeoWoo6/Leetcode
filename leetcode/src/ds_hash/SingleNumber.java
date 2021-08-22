// 只出现一次的数字
package ds_hash;


import java.util.*;

public class SingleNumber {
    public static void main(String[] args) {

    }
    public int singleNumber(int[] nums) {
//        Map<Integer, Integer> freq = new HashMap<>();
//        for(int i = 0; i < nums.length; i++){
//            if(!freq.containsKey(nums[i])){
//                freq.put(nums[i], 1);
//            }else{
//                freq.put(nums[i], 2);
//            }
//        }
//
//        Iterator freqIterator = freq.entrySet().iterator();
//        while(freqIterator.hasNext()){
//            Map.Entry mapElement = (Map.Entry)freqIterator.next();
//            if((int)mapElement.getValue() == 1){
//                return (int)mapElement.getKey();
//            }
//        }
//        return -1;

//      Use HashSet directly
        Set<Integer> single = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if (!single.add(nums[i])){
                single.remove(nums[i]);
            }
        }
        if(single.isEmpty()){
            return -1;
        }else{
            return single.iterator().next();
        }
    }
//    public int singleNumber(int[] nums) {
//        Set<Integer> dup = new HashSet<>();
//        for (int num : nums) if (!dup.add(num)) dup.remove(num);
//        return dup.isEmpty() ? -1 : dup.iterator().next();
//    }
}
