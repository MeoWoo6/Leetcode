package cupcup;

public class StoreWater {
    public static void main(String[] args) {
        int[] bucket = {9, 0, 1};
        int[] vat = {1, 2, 2};
        System.out.print(storeWater(bucket, vat));
    }

    public static int storeWater(int[] bucket, int[] vat) { //自己参考题解 写的代码，执行时间很长。。。
        int sum = 0;
        for(int i = 0; i < vat.length; i++){
            sum += vat[i];
        }
        if(sum == 0){
            return 0;
        }
        int upgrade = 0;
        int maxtotal = 10101;
        int total = maxtotal;
        for(int pour = 1; pour < maxtotal; pour++){
            for(int j = 0; j < bucket.length; j++){
                int upforthis = (int) Math.ceil((double) vat[j] / pour) - bucket[j];
                if(upforthis > 0){
                    upgrade += upforthis;
                }
            }
            total = Math.min(total, upgrade + pour);
            upgrade = 0;
        }
        return total;
    }

    public static int storeWater2(int[] bucket, int[] vat){
        int max = 0;
        for(int v:vat)//找水缸中最大容量和判断是否全为0 放在一起
            if(max < v) max = v;
        if(max == 0) return 0;
        int n = bucket.length;
        int ans = Integer.MAX_VALUE; //这个可以，
        for(int i = 1; i <= 10000; i++) { //
            int per = 0;
            int cur = i;
            for(int j = 0; j < n; j++) {
                per = (vat[j] + i - 1) / i; //啊！这里处理的好棒，向上取整

                cur += Math.max(0, per - bucket[j]); //需要升级次数，这里用max(0, ...)很巧妙，不用单独考虑小于0的情况
            }
            ans = Math.min(ans, cur);
        }
        return ans;
    }
}
