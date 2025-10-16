package Graphs.Util;

public record AdjacentListNode(int v, int weight) {
    @Override
    public String toString() {
        return String.format("{%d, %d}", v,weight);
    }
}
