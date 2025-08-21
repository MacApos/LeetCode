package BinaryTreeGeneral.general;

import lombok.Data;

@Data
public class Node {
    private String data;
    private Node left;
    private Node right;

    public Node(String data) {
        this.data = data;
    }
}
