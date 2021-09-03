// 22. 括号生成
// https://leetcode-cn.com/problems/generate-parentheses/
package ds_bitree;
// 方法一：递归
// 注意：考虑递归的边界条件 左括号，右括号数
// 22，25行的if条件设计得很巧

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    List<String> res = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        getParenthesis(n, 0, 0, "");
        return res;
    }

    public void getParenthesis(int n, int left, int right, String s){
        if(left == n && right == n){
            res.add(s);
        }else{
            if(left < n){
                getParenthesis(n, left+1, right, s+"(");
            }
            if(right < n && right < left){
                getParenthesis(n, left, right+1, s+")");
            }
        }
    }
}
