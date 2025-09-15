package BinaryTreeGeneral.general;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public static Node conversion(TreeNode root){
        if(root==null){
            return null;
        }
        Node node = new Node(root.val);
        node.left = conversion(root.left);
        node.right = conversion(root.right);
        return node;
    }
}
