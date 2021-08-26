package ds_bitree;

public class IsSymmetric {
    public static boolean isSym(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }

        if(left == null || right == null){
            return false;
        }

        return ((left.val == right.val) && isSym(left.left, right.right) && isSym(left.right, right.left));

    }
    public boolean isSymmetric(TreeNode root) {
        return isSym(root, root);
    }
}
