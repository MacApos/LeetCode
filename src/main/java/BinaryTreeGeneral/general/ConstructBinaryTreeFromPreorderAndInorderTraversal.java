package BinaryTreeGeneral.general;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Integer[] completeInorder = {4, 2, 5, 1, null, 3, 6};
        TreeNode node = TreeNode.createNodeInorderTraversal(completeInorder);
        TreeNode treeNode = buildTree(preorder, inorder);
    }

    public static int getIndexOf(int[] array, int value) {
        int index = 0;
        for (int i : array) {
            if (i == value) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public static TreeNode buildTreeRecursively(int root, int nextNode, int[] preorder, int[] inorder) {
        int preorderIdx1 = getIndexOf(preorder, root);
        int preorderIdx2 = getIndexOf(preorder, nextNode);

        int inorderIdx1 = getIndexOf(inorder, root);
        int inorderIdx2 = getIndexOf(inorder, nextNode);

        TreeNode treeNode = new TreeNode(root);
        if (inorder.length == 1) {
            return treeNode;
        }

        if (inorderIdx2 < inorderIdx1) { // -> left
            int[] preorderCopy = Arrays.copyOfRange(preorder, preorderIdx2, preorder.length);
            int[] inorderCopy = Arrays.copyOfRange(inorder, 0, inorderIdx2);
            treeNode.left = buildTreeRecursively(nextNode, nextNode + 1, preorderCopy, inorderCopy);
        } else { // -> right

        }

        return treeNode;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode treeNode = buildTreeRecursively(preorder[0], preorder[1], preorder, inorder);


        return treeNode;
    }
}
