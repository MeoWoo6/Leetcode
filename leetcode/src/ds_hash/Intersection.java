package ds_hash;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Intersection {
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] res = intersection(nums1, nums2);
    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> inters = new HashSet<Integer>();
        for (int nums : nums1){
            set1.add(nums);
        }
        for (int nums : nums2){
            if(set1.contains(nums)){ // here use contains not add
                inters.add(nums);
            }
        }
        int[] res = new int[inters.size()];
        int index = 0;
        for (int value : inters){
            res[index++] = value;
        }
        return res;
    }
}
