package easyTree;

import Utilities.TreeNode;

public class _0110_BalancedBinaryTree {
    private boolean unbalancedFound = false;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        var deep = findDeepest(1, root);
        return deep != 0;
    }

    private int findDeepest(int deep, TreeNode node) {
        if(unbalancedFound) return 0;
        if (node == null) return deep;
        deep++;
        if(isLeaf(node)) return deep;

        var leftDeep = findDeepest(deep, node.left);
        var rightDeep = findDeepest(deep, node.right);

        if(Math.abs(leftDeep - rightDeep) > 1){
            unbalancedFound = true;
            return 0;
        }

        return Integer.max(leftDeep, rightDeep);
    }

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    public void run() {
        System.out.println("_0110_BalancedBinaryTree: ");
        System.out.println("Expected: true    Actual: " + isBalanced(prepareTestTree1()));
        System.out.println("Expected: false   Actual: " + isBalanced(prepareTestTree2()));
        System.out.println("Expected: false   Actual: " + isBalanced(prepareTestTree103()));
        System.out.println("Expected: false   Actual: " + isBalanced(prepareTestTree203()));
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
        var x = new TreeNode(4);
        var y = new TreeNode(4);

        var a = new TreeNode(3, x, y);        //     1
        var b = new TreeNode(3);              //    / \
                                                  //   2  2
        var l = new TreeNode(2, a, b);        //  / \
        var r = new TreeNode(2);              // 3  3
                                                // / \
        return new TreeNode(1, l, r);       // 4  4
    }

    //[1,null,2,null,3] if parent is null supposed children are omitted during insertion ?
    //https://leetcode.com/problems/balanced-binary-tree/discuss/35897/Explain-test-case%3A-1null2null3
    private TreeNode prepareTestTree103() {          //    1
        var rr = new TreeNode(3);               //    / \
        var r = new TreeNode(2, null, rr);//         2
                                                  //       / \
        return new TreeNode(1, null, r);      //      3
    }

    //[1,2,2,3,null,null,3,4,null,null,4]
    private TreeNode prepareTestTree203() {
        var rr = new TreeNode(3);
        var r = new TreeNode(2, null, rr);
        return new TreeNode(1, null, r);
    }
}
