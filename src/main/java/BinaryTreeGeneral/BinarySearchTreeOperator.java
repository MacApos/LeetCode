package BinaryTreeGeneral;

import BinaryTreeGeneral.general.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BinarySearchTreeOperator {
    public static void main(String[] args) {
        TreeNode node = TreeNode.createNodeBreadthFirst(new Integer[]{7, 3, 15, null, null, 9, 20});
        BSTIterator bSTIterator = new BSTIterator(node);
        System.out.println(bSTIterator.next());      // return 3
        System.out.println(bSTIterator.next());    // return 7
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 9
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 15
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 20
        System.out.println(bSTIterator.hasNext());

    }


    static class BSTIterator {
        private final Deque<TreeNode> deque = new ArrayDeque<>();

        private void recursion(TreeNode root) {
            if (root == null) {
                return;
            }

            recursion(root.left);
            deque.add(root);
            recursion(root.right);
        }

        private Deque<TreeNode> recursion2(TreeNode node) {
            ArrayDeque<TreeNode> deque = new ArrayDeque<>();
            if (node == null) {
                return deque;
            }
            deque.push(node);

            Deque<TreeNode> leftDeque = recursion2(node.left);
            Deque<TreeNode> rightDeque = recursion2(node.right);

            while (!leftDeque.isEmpty()) {
                deque.addFirst(leftDeque.pollLast());
            }

            while (!rightDeque.isEmpty()) {
                deque.addLast(rightDeque.pollFirst());
            }

            return deque;
        }

        public BSTIterator(TreeNode root) {
            recursion(root);
        }

        public int next() {
            return deque.poll().val;
        }

        public boolean hasNext() {
            return !deque.isEmpty();
        }
    }


}