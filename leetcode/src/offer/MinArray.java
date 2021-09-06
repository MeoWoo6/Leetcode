// 旋转数组中的最小数
// https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
package offer;
// 方法一：二分查找
// 注意：充分利用数组的有序性，而不是暴力遍历
// 更新right left指针
// right 的重要性
public class MinArray {
    public int minArray(int[] numbers) {
        int len = numbers.length;
        int left = 0;
        int right = len - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(numbers[mid] < numbers[right]){
                right = mid;
            }else if(numbers[mid] > numbers[right]){
                left = mid + 1;
            }else{
                right--;
            }
        }
        return numbers[left];
    }
}

