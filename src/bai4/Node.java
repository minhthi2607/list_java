package bai4;

public class Node {
    Object data;
    Node next;

    public Node(Object data) {
        this.data = data;
        next = null;
    }

    public Object getData() {
        return data;
    }
}
