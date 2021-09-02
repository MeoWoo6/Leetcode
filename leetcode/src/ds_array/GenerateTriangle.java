package ds_array;
//118 生成杨辉三角
//https://leetcode-cn.com/problems/pascals-triangle/solution/yang-hui-san-jiao-by-leetcode-solution-lew9/
import java.util.ArrayList;
import java.util.List;

// 方法一
// 迭代，思路简单
// 时间复杂度 O(numRows^2)
// 空间复杂度 O(1)

// 注意：
// 1. `new List<>` is not allowed, since List is interface cannot be initialized,
// but you can `new ArrayList<List<Integer>>();`

// 2. no need set apart numRows == 1 or 2, `if(j == 0 || j == i){...}` solve the boundary value problem.
public class GenerateTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < numRows; i++){
            List<Integer> level = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    level.add(1);
                }else{
                    int val = res.get(i-1).get(j-1) + res.get(i-1).get(j);
                    level.add(val);
                }
            }
            res.add(level);
        }
        return res;
    }
}
