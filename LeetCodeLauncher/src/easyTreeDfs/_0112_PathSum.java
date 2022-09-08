package easyTreeDfs;

import Utilities.TreeNode;

public class _0112_PathSum {
    public boolean hasPathSum(TreeNode node, int targetSum) {
        if(node == null) return false;
        if(node.left == null && node.right == null) return node.val == targetSum;

        return hasPathSum(node.left, targetSum - node.val) ||
               hasPathSum(node.right, targetSum - node.val);
    }

    public void run() {
        System.out.println("_0112_PathSum");
        System.out.println("Expecte: true Actual: " +hasPathSum(prepareTestNodes1(), 22));
        System.out.println("Expecte: false Actual: " +hasPathSum(prepareTestNodes1(), 23));
        System.out.println("Expecte: true Actual: " +hasPathSum(prepareTestNodes1(), 26));
        System.out.println("Expecte: true Actual: " +hasPathSum(prepareTestNodes2(), 4));
        System.out.println("Expecte: false Actual: " +hasPathSum(prepareTestNodes2(), 5));
    }

    private TreeNode prepareTestNodes1(){
        var rrr = new TreeNode(1);
        var rr = new TreeNode(4, null, rrr);
        var rl = new TreeNode(13);
        var r = new TreeNode(8, rl, rr);

        var lll = new TreeNode(7);
        var llr = new TreeNode(2);
        var ll = new TreeNode(11, lll, llr);
        var l = new TreeNode(4, ll, null);

        return new TreeNode(5, l, r);
    }

    private TreeNode prepareTestNodes2(){
        var r = new TreeNode(3);
        var l = new TreeNode(2);

        return new TreeNode(1, l, r);
    }
}
