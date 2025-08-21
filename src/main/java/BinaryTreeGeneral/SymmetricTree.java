package BinaryTreeGeneral;

import BinaryTreeGeneral.general.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode nodes1 = TreeNode.createNodeBreadthFirst(new Integer[]{1, 2, 2, 4, 3, 3, 4});
        TreeNode nodes2 = TreeNode.createNodeBreadthFirst(new Integer[]{1, 2, 2, null, 3, null, 3});
        boolean symmetric = isSymmetric(nodes2);
        System.out.println(symmetric);
    }

    public static boolean isSymmetric(TreeNode root) {
        List<TreeNode> left = processLeft(root.left, new ArrayList<>());
        List<TreeNode> right = processRight(root.right, new ArrayList<>());

        left.forEach(n -> System.out.println(n.val));
        right.forEach(n -> System.out.println(n.val));

        for (int i = 0; i < left.size(); i++) {
            TreeNode l = left.get(i);
            TreeNode r = right.get(i);

            if(l==null || r==null){
                if(l!=r){
                    return false;
                }
            } else {
                if(l.val!=r.val){
                    return false;
                }
            }
        }
        return true;
    }

    public static List<TreeNode> processLeft(TreeNode node, List<TreeNode> nodes) {
        nodes.add(node);
        if (node != null) {
            processLeft(node.left, nodes);
            processLeft(node.right, nodes);
        }
        return nodes;
    }

    public static List<TreeNode> processRight(TreeNode node, List<TreeNode> nodes) {
        nodes.add(node);
        if (node != null) {
            processRight(node.right, nodes);
            processRight(node.left, nodes);
        }
        return nodes;
    }
}
