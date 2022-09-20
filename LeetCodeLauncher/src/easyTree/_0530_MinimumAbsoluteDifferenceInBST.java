package easyTree;

import Utilities.TreeNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class _0530_MinimumAbsoluteDifferenceInBST {
    private Queue<Integer> queue = new PriorityQueue<>();
    public int getMinimumDifference(TreeNode root) {
        queue = new PriorityQueue<>(Comparator.reverseOrder());
        var min = Integer.MAX_VALUE;
        dfsTraversalWithValuesUnpacking(root);

        while(queue.size() > 1){
            var diff = Math.abs(queue.remove() - queue.peek());
            if(diff < min) min = diff;
        }

        return min;
    }

    private void dfsTraversalWithValuesUnpacking(TreeNode node) {
        if (node == null) return;
        queue.add(node.val);
        dfsTraversalWithValuesUnpacking(node.left);
        dfsTraversalWithValuesUnpacking(node.right);
    }

    public void run() {
        System.out.println("_0530_MinimumAbsoluteDifferenceInBST: ");
        System.out.println("Expected: 1   Actual: " + getMinimumDifference(prepareTestTree()));
        System.out.println("Expected: 1   Actual: " + getMinimumDifference(prepareTestTree2()));
        System.out.println("Expected: 1   Actual: " + getMinimumDifference(prepareTestTree3()));
    }

    private TreeNode prepareTestTree() {
        var x = new TreeNode(2);
        var r = new TreeNode(4);
        var l = new TreeNode(3, null, x);
        return new TreeNode(1, l, r);
    }

    private TreeNode prepareTestTree2() {
        var y = new TreeNode(49);
        var x = new TreeNode(12);
        var r = new TreeNode(48, x, y);
        var l = new TreeNode(0, null, null);
        return new TreeNode(1, l, r);
    }

    private TreeNode prepareTestTree3() {
        var r = new TreeNode(7);
        var l = new TreeNode(4);
        return new TreeNode(5, l, r);
    }
}
