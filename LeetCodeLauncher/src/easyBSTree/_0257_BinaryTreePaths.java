package easyBSTree;

import Utilities.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class _0257_BinaryTreePaths {
    private List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        dfsTraversalWithPathTracking("", root);
        return list;
    }

    private void dfsTraversalWithPathTracking(String path, TreeNode node) {
        if (node == null) return;

        if(path.isEmpty()) path = String.valueOf(node.val);
        else path += "->" + node.val;

        if(isLeaf(node)) {
            list.add(path);
            return;
        }

        dfsTraversalWithPathTracking(path, node.left);
        dfsTraversalWithPathTracking(path, node.right);
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    public void run() {
        System.out.println("_0257_BinaryTreePaths: ");
        System.out.println("Expected: [\"1->2->5\",\"1->3\"]   Actual: " + binaryTreePaths(prepareTestTree()));
    }

    private TreeNode prepareTestTree() {
        var x = new TreeNode(5);
        var r = new TreeNode(3);
        var l = new TreeNode(2, null, x);
        return new TreeNode(1, l, r);
    }
}
