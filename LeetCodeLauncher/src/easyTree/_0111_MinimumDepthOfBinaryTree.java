package easyTree;

import Utilities.TreeNode;

public class _0111_MinimumDepthOfBinaryTree {
    private int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        min = Integer.MAX_VALUE;
        if(root==null) return 0;
        findDeepestWithMinTracking(0, root);
        return min;
    }

    private void findDeepestWithMinTracking(int deep, TreeNode node) {
        if (node == null) return;
        deep++;
        if(isLeaf(node)) {
            if(deep < min) min = deep;
            return;
        }

        findDeepestWithMinTracking(deep, node.left);
        findDeepestWithMinTracking(deep, node.right);
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    public void run() {
        System.out.println("_0111_MinimumDepthOfBinaryTree: ");
        System.out.println("Expected: 2   Actual: " + minDepth(prepareTestTree1()));
        System.out.println("Expected: 5   Actual: " + minDepth(prepareTestTree2()));
    }

    private TreeNode prepareTestTree1() {
        var a = new TreeNode(15);     //     3
        var b = new TreeNode(7);      //    / \
                                          //   9  20
        var r = new TreeNode(20, a, b);//     / \
        var l = new TreeNode(9);      //     15  7

        return new TreeNode(3, l, r);
    }

    private TreeNode prepareTestTree2() {
        var c = new TreeNode(5);
        var b = new TreeNode(4, c, null);
        var a = new TreeNode(3, b, null);
        var l = new TreeNode(2, a, null);
        return new TreeNode(1, l, null);
    }
}
