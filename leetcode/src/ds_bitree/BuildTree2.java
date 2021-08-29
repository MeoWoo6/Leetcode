package ds_bitree;

import java.util.HashMap;
import java.util.Map;

// 给定前序和中序，还原二叉树
public class BuildTree2 {
    int[] preorder;
    int[] inorder;
    int rootIndex;
    Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 第一次忘了加 this.xxx = xxx 导致helper函数出现NullPointerException
        // The NullPointerException (NPE) occurs when you declare a variable but did not create an object and assign it
        // to the variable before trying to use the contents of the variable (called dereferencing).
        this.preorder = preorder;
        this.inorder = inorder;
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        rootIndex = 0;
        return helper(0, inorder.length - 1);
    }

    public TreeNode helper(int leftIndex, int rightIndex){
        if(leftIndex > rightIndex){
            return null;
        }
        int val = preorder[rootIndex];
        TreeNode root = new TreeNode(val);
        int index = inorderMap.get(val);
        rootIndex++;
        // 这里注意左右端是leftIndex, rightIndex 而不是0和length-1
        // 迭代的过程中 区间左右端点会变化，如果使用错误，在正确递归次数内
        // 无法完成，即if(leftIndex > rightIndex)无法在正确次数终止，
        // 那么rootIndex会++到IndexOutOfBoundsException
        root.left = helper(leftIndex, index-1);
        root.right = helper(index+1, rightIndex);
        return root;
    }
}
