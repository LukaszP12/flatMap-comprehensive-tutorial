package pl.piwowarski.flatMapDemo.streams.TreeNode;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    private int value;
    private List<TreeNode> children = new ArrayList<>();

    public TreeNode(int value) {
        this.value = value;
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public int getValue() {
        return value;
    }
}
