package easyBSTree;

import Utilities.TreeNode;
import java.util.HashSet;
import java.util.Set;

public class _0653_TwoSumIVInputBST {
    Set<Integer> set;
    int k;

    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        this.k = k;
        return dfsTraversalWithTargetSearch(root);
    }

    private boolean dfsTraversalWithTargetSearch(TreeNode root){
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfsTraversalWithTargetSearch(root.left)
                || dfsTraversalWithTargetSearch(root.right);
    }

    public void run() {
        System.out.println("_0653_TwoSumIVInputBST");
        System.out.println("Expected: true   Actual: " + findTarget(prepareTestTree(), 9));
        System.out.println("Expected: false   Actual: " + findTarget(prepareTestTree(), 10));
    }

    private TreeNode prepareTestTree(){
        var a = new TreeNode(4);
        var b = new TreeNode(5);
        var l = new TreeNode(2, a, b);
        var r = new TreeNode(3);
        return new TreeNode(1, l, r);
    }
}
