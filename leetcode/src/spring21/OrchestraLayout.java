package spring21;

public class OrchestraLayout {
    public static void main(String[] args) {
        //1 <= num <= 10^9, 0 <= Xpos, Ypos < num
//        int num = 971131546;
//        int Xpos = 966980466;
//        int Ypos = 531910024;
        int num = 4;
        int Xpos = 2;
        int Ypos = 1;

        //输出5
        System.out.print(orchestraLayout(num, Xpos, Ypos));
    }
    public static int orchestraLayout(int num, int xPos, int yPos){
        long totalnum = (long) num * num; // 总共有多少个数
        int mod = 9;
        int res = 0;
        long totalcircle = (long) num / 2; // 总共有几圈
        long poscircle; //给定坐标的数在第几圈
        long position;
        long len;
        long len_next;
        // 处理中心点，保持奇数偶数边长圈数一样
        if(xPos == yPos && (xPos + yPos) == (num - 1)){
            res = (int) (totalnum % mod);
            if(res == 0){
                res = 9;
            }
            return res;
        }
        // 确定该点所在圈
        if((xPos + yPos) > (num - 1)){
            long max = Math.max(xPos, yPos);
            poscircle = (long) num - max;
        }else {
            long min = Math.min(xPos, yPos);
            poscircle = (long) min + 1;
        }
        len = (long) (num - (poscircle - 1) * 2);
        len_next = (long) (num - poscircle * 2);
        // 确定该点处于上/下半圈
        if(xPos < yPos){ //上半圈 由该圈起点坐标定位
//            long start = (long) ((totalnum - (long) Math.pow((num - (poscircle - 1) * 2), 2)) + 1);
            long start = (long) (num + len) * (num - len) + 1;
            position = (long) start + xPos + yPos - (poscircle-1) * 2;
        }else{ //下半圈 由下一圈起点坐标定位
//            long start = (long) ((totalnum - (long) Math.pow((num - poscircle * 2), 2)) + 1);
            long start = (long) (num + len_next) * (num - len_next) + 1;
            position = (long) start - (xPos + yPos - (poscircle-1) * 2);
        }
        res = (int) (position % mod);
        if(res == 0){
            res = 9;
        }
        return res;
    }
}
