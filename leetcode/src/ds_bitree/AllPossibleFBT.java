package ds_bitree;
import java.util.ArrayList;
import java.util.List;

// 方法一：递归
// 注意：这里的iterator得到的结果不正确。。官方题解是用的for each循环

public class AllPossibleFBT {
    public List<TreeNode> allPossibleFBT(int n) {
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

            // Iterator<TreeNode> leftnodes = leftTree.iterator();
            // Iterator<TreeNode> rightnodes = rightTree.iterator();
            // if(leftnodes.hasNext()){
            //     if(rightnodes.hasNext()){
            //         TreeNode root = new TreeNode(0);
            //         root.left = leftnodes.next();
            //         root.right = rightnodes.next();
            //         res.add(root);
            //     }
            // }

//            for (int x = 0; x < N; ++x) {
//                int y = N - 1 - x;
//                for (TreeNode left: allPossibleFBT(x))
//                    for (TreeNode right: allPossibleFBT(y)) {
//                        TreeNode bns = new TreeNode(0);
//                        bns.left = left;
//                        bns.right = right;
//                        ans.add(bns);
//                    }
//            }
        }
        return res;
    }
}















