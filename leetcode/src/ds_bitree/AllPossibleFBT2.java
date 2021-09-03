// 894. 所有可能的满二叉树
// https://leetcode-cn.com/problems/all-possible-full-binary-trees/

package ds_bitree;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 方法二：
// 在方法一的基础上使用HashMap，存储之前计算的结果（动态规划）
public class AllPossibleFBT2 {
    Map<Integer, List<TreeNode>> memos = new HashMap();
    public List<TreeNode> allPossibleFBT(int n) {
        if(!memos.containsKey(n)){
            List<TreeNode> res = new ArrayList<TreeNode>();
            if(n % 2 == 0){
                return res;
            }
            if(n == 1){
                TreeNode root = new TreeNode(0);
                res.add(root);
            }

            for(int left = 1; left < n - 1; left+=2){
                int right = n - left - 1;
                List<TreeNode> leftTree = allPossibleFBT(left);
                List<TreeNode> rightTree = allPossibleFBT(right);
                for(int i = 0; i < leftTree.size(); i++){
                    for(int j = 0; j < rightTree.size(); j++){
                        TreeNode root = new TreeNode(0);
                        root.left = leftTree.get(i);
                        root.right = rightTree.get(j);
                        res.add(root);
                    }
                }
            }
            memos.put(n, res);
        }
        return memos.get(n);
    }















}
