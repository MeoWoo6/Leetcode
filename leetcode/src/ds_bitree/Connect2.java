package ds_bitree;
// 填充每个节点的下一个右侧节点指针（完美二叉树）
// 利用递归

public class Connect2 {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }

        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null){
                root.right.next = root.next.left;
            }
//          root.right.next=root.next!=null?root.next.left:null;
            connect(root.left);
            connect(root.right);
        }

        return root;

    }
}
