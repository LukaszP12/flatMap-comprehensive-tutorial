package pl.piwowarski.flatMapDemo.streams.tree_example;

import java.util.stream.Stream;

class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode childA = new TreeNode(2);
        TreeNode childB = new TreeNode(3);
        TreeNode childC = new TreeNode(4);
        TreeNode childD = new TreeNode(5);

        root.addChild(childA);
        root.addChild(childB);
        childA.addChild(childC);
        childB.addChild(childD);

        Main tree = new Main();
        tree.flatten(root)
                .map(TreeNode::getValue)
                .forEach(System.out::println);
    }

    public Stream<TreeNode> flatten(TreeNode node) {
        if (node == null) {
            return Stream.empty();
        }

        return Stream.concat(Stream.of(node),
                node.getChildren().stream().flatMap(this::flatten)
        );
    }
}
