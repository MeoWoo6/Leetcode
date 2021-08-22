package ds_hash;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();
        while(true){
            if(n == 1){
                return true;
            }else if(!nums.add(n)){
                return false;
            }else{
                n = squareDigits(n);
            }
        }
    }

    private static int squareDigits(int n) {
        int sum = 0;
        while(n != 0){
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }


}
