package pl.piwowarski.flatMapDemo.streams.TreeNode;

import java.util.OptionalInt;
import java.util.stream.Stream;

class TreeDemo {
    public static void main(String[] args) {
        // Build tree
        TreeNode root = new TreeNode(1);
        TreeNode childA = new TreeNode(2);
        TreeNode childB = new TreeNode(3);
        TreeNode childC = new TreeNode(4);
        TreeNode childD = new TreeNode(5);

        root.addChild(childA);
        root.addChild(childB);
        childA.addChild(childC);
        childB.addChild(childD);

        // Calculate sum
        TreeDemo demo = new TreeDemo();
        int sum = demo.sumValues(root);
        System.out.println("Sum of all tree values: " + sum);

        System.out.println("Max value: " + demo.maxValue(root).orElseThrow());
        System.out.println("Min value: " + demo.minValue(root).orElseThrow());
    }

    public Stream<TreeNode> flatten(TreeNode node) {
        if (node == null) {
            Stream.empty();
        }
        return Stream.concat(
                Stream.of(node),
                node.getChildren().stream().flatMap(this::flatten)
        );
    }

    // find max value
    public OptionalInt maxValue(TreeNode root) {
        return flatten(root)
                .mapToInt(TreeNode::getValue)
                .max();
    }

    public OptionalInt minValue(TreeNode root) {
        return flatten(root)
                .mapToInt(TreeNode::getValue)
                .min();
    }

    // sum all values using flatten()
    public int sumValues(TreeNode root) {
        return flatten(root)
                .mapToInt(TreeNode::getValue)
                .sum();
    }
}
