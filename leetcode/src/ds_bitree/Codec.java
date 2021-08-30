package ds_bitree;

import apple.laf.JRSUIUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public static String serialize(TreeNode root) {
        //这里要小心处理逗号的位置，不然会出现两个逗号连一块，
        //split还需要对empty string进行处理
        String res ="";
        if(root == null){
            res += "null";
        }else{
            res = root.val + "," + serialize(root.left) + "," + serialize(root.right);
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        Queue<String> q = new LinkedList<String>(Arrays.asList(dataArray));
        return mydeserialize(q);
    }

    public static TreeNode mydeserialize(Queue<String> q){
        //这个bug找了好久，果然是菜鸡。。。原来用的是 == 来判断
        if(q.peek().equals("null")){
            q.poll();
            return null;
        }

        int val = Integer.parseInt(q.poll());
        TreeNode root = new TreeNode(val);
        root.left = mydeserialize(q);
        root.right = mydeserialize(q);
        return root;
    }

    public static void main(String[] args) {
//        String data = "1,2,3,null,null,4,5";
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String data = serialize(root);
        deserialize(data);
    }
}
