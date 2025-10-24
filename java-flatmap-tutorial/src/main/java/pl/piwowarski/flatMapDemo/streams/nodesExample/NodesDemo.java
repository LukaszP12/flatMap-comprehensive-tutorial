package pl.piwowarski.flatMapDemo.streams.nodesExample;

class NodesDemo {

    public static void main(String[] args) {
        Node node7 = new Node(null, 9);
        Node node6 = new Node(node7, 8);
        Node node5 = new Node(node6, 7);
        Node node4 = new Node(node5, 6);
        Node node3 = new Node(node4, 5);
        Node node2 = new Node(node3, 4);
        Node node1 = new Node(node2, 3);

        int allNodesSum = node1.getAllNodesSum(node1);
        System.out.println("allNodesSum: " + allNodesSum);
    }
}
