package pl.piwowarski.flatMapDemo.streams.nodesExample;

import java.util.stream.Stream;

class Node {
    private Node next;
    private int value;

    public Node(Node next, int value) {
        this.next = next;
        this.value = value;
    }

    private Stream<Node> flattedNodes(Node node) {
        if (node == null) {
            return Stream.empty();
        }

        return Stream.concat(Stream.of(node), flattedNodes(node.getNext()));
    }

    public int getAllNodesSum(Node node) {
        if (node == null) {
            return 0;
        }

        return flattedNodes(node)
                .mapToInt(Node::getValue)
                .sum();
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
