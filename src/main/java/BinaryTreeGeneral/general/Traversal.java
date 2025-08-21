package BinaryTreeGeneral.general;

public class Traversal {
    static Node a = new Node("A");
    static Node b = new Node("B");
    static Node c = new Node("C");
    static Node d = new Node("D");
    static Node e = new Node("E");
    static Node f = new Node("F");
    static Node g = new Node("G");

    static {
        a.setLeft(b);
        a.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setLeft(f);
        c.setRight(g);
    }

    public static void main(String[] args) {
        System.out.println("""
                     A
                    / \\
                  B     C
                 / \\   / \\
                D   F  G   H
                """);


//        left -> root -> right
        System.out.print("In order: ");
        inOrder(a);
        System.out.println();

//        left -> right -> root
        System.out.print("Post order: ");
        postOrder(a);
        System.out.println();

//        root -> left -> right
        System.out.print("Pre order: ");
        preOrder(a);
        System.out.println();
    }

    private static void preOrder(Node root) {
        Node left = root.getLeft();
        Node right = root.getRight();
        System.out.print(root.getData() + ", ");
        if (left != null) {
            inOrder(left);
        }
        if (right != null) {
            inOrder(right);
        }
    }

    public static void inOrder(Node root) {
        Node left = root.getLeft();
        Node right = root.getRight();
        if (left != null) {
            inOrder(left);
        }
        System.out.print(root.getData() + ", ");
        if (right != null) {
            inOrder(right);
        }
    }

    public static void postOrder(Node root) {
        Node left = root.getLeft();
        Node right = root.getRight();
        if (left != null) {
            postOrder(left);
        }
        if (right != null) {
            postOrder(right);
        }
        System.out.print(root.getData() + ", ");
    }

}
