package ds_bitree;

import java.util.HashMap;
import java.util.Map;

//给定后序和中序，还原二叉树
public class BuildTree1 {
    int[] inorder;
    int[] postorder;
    int rootIndex;
    Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        //构建中序遍历的哈希映射（元素，下标）
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        //从后序遍历的最后一个结点开始
        rootIndex = postorder.length - 1;
        return helper(0, inorder.length - 1);
    }

    public TreeNode helper(int leftIndex, int rightIndex){
        if(leftIndex > rightIndex){
            return null;
        }
        int val = postorder[rootIndex];
        TreeNode root = new TreeNode(val);
        int index = inorderMap.get(val);
        rootIndex-- ;
        // 先构建右子树，因为后序遍历的顺序是左-右-根，倒过来那右子树在左子树前；
        root.right = helper(index+1, rightIndex);
        root.left = helper(leftIndex, index-1);
        return root;
    }
}
