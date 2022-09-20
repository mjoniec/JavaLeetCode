package easyBSTree;

import Utilities.TreeNode;

public class _0572_SubtreeOfAnotherTree {
    private boolean matchFound = false;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        matchFound = false;
        if(root == null && subRoot == null) return true;
        dfsTraversalWithMatchSubTreeSearch(root, subRoot);
        return matchFound;
    }

    private void dfsTraversalWithMatchSubTreeSearch(TreeNode node, TreeNode subRoot) {
        if (node == null) return;
        if(isSameTree(node, subRoot)){
            matchFound = true;
            return;
        }
        dfsTraversalWithMatchSubTreeSearch(node.left, subRoot);
        dfsTraversalWithMatchSubTreeSearch(node.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if((p == null || q == null) || (p.val != q.val)) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public void run() {
        System.out.println("_0572_SubtreeOfAnotherTree");
        System.out.println("Expected true Actual: " + isSubtree(prepareTestNodes1(), prepareTestNodes2()));
    }

    private TreeNode prepareTestNodes1() {
        var y = new TreeNode(5);
        var x = new TreeNode(4);
        var r = new TreeNode(3, x, y);
        var l = new TreeNode(2, null, null);
        return new TreeNode(1, l, r);
    }

    private TreeNode prepareTestNodes2() {
        var r = new TreeNode(5);
        var l = new TreeNode(4);
        return new TreeNode(3, l, r);
    }
}
