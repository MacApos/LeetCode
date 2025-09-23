package BinaryTreeGeneral;

import BinaryTreeGeneral.general.TreeNode;
import lombok.val;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/?envType=study-plan-v2&envId=top-interview-150
 */

public class LowestCommonAncestorOfBinaryTree {

    public static void main(String[] args) {
        TreeNode node = TreeNode.createNodeBreadthFirst(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4, null, null, null, null});
        TreeNode node2 = TreeNode.createNodeBreadthFirst(new Integer[]{3, 5, 1, 6, 2, 0, 8});
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(8);
        TreeNode treeNode = lowestCommonAncestor(node2, p, q);
    }

    public static void recursion(TreeNode root, TreeNode p, TreeNode q, Deque<TreeNode> list,
                                 Deque<TreeNode> pList, Deque<TreeNode> qList) {
        if (root == null) {
            return;
        }

        list.add(root);
        if (root.val == p.val) {
            pList.addAll(list);
        }
        if (root.val == q.val) {
            qList.addAll(list);
        }
        if (!pList.isEmpty() && !qList.isEmpty()) {
            return;
        }
        recursion(root.left, p, q, list, pList, qList);
        recursion(root.right, p, q, list, pList, qList);

        list.pollLast();
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }

        if(root.val==p.val){
            return root;
        }
        if(root.val==q.val){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

//        Nodes are on both sides of tree
        if(left!=null && right!=null){
            return root;
        }

        if(left==null){
            return right;
        } else {
            return left;
        }

    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        ArrayDeque<TreeNode> pList = new ArrayDeque<>();
        ArrayDeque<TreeNode> qList = new ArrayDeque<>();
        recursion(root, p, q, new ArrayDeque<>(), pList, qList);

        System.out.println(pList.stream().map(n -> String.valueOf(n.val)).collect(Collectors.joining(", ")));
        System.out.println(qList.stream().map(n -> String.valueOf(n.val)).collect(Collectors.joining(", ")));

        while (pList.peekLast().val != qList.peekLast().val) {
            if (pList.size() > qList.size()) {
                pList.pollLast();
            } else {
                qList.pollLast();
            }
        }
        return qList.peekLast();
    }
}
