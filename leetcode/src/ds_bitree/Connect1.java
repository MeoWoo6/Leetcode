package ds_bitree;
//填充每个节点的下一个右侧节点指针（完美/不完美 二叉树）
//利用层序遍历，栈
import java.util.ArrayDeque;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Connect1 {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        //构建一个栈，按层存放
        Queue<Node> q = new ArrayDeque<Node>();
        Node node = root;
        q.offer(node);
        while(!q.isEmpty() && node != null){
            int size = q.size();
            for(int i = 0; i < size; i++){
                node = q.poll();
                // node.next = q.peek();
                // 一开始没有判断i是否小于size-1 这样不能分割每一层
                if(i < size-1){
                    node.next = q.peek();
                }else{
                    node.next = null;
                }
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
        }
        return root;
    }
}
