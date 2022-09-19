package easyTree;

import Utilities.TreeNode;

public class _0110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        var leftNodes = findDeepest(1,root.left);
        var rightNodes = findDeepest(1, root.right);

        return Math.abs(leftNodes - rightNodes) <= 1;
    }

    private int findDeepest(int deep, TreeNode node){
        if (node == null) return deep;

        deep++;

        if(isLeaf(node)) {
            return deep;
        }
        else{
            var leftNodes = node.left == null ? deep : findDeepest(deep, node.left);
            var rightNodes = node.right == null ? deep : findDeepest(deep, node.right);

            return Integer.max(leftNodes, rightNodes);
        }
    }

    private boolean isLeaf(TreeNode node){
        return node != null && node.left == null && node.right == null;
    }

    public void run() {
        System.out.println("_0110_BalancedBinaryTree: ");
        System.out.println("Expected: true    Actual: " + isBalanced(prepareTestTree1()));
        System.out.println("Expected: false   Actual: " + isBalanced(prepareTestTree2()));
        System.out.println("Expected: false   Actual: " + isBalanced(prepareTestTree3()));
    }

    private TreeNode prepareTestTree1(){
        var a = new TreeNode(4);              //     1
        var b = new TreeNode(5);              //    / \
                                                  //   2  3
        var l = new TreeNode(2, a, b);        //  / \
        var r = new TreeNode(3);              //  4  5

        return new TreeNode(1, l, r);
    }

    private TreeNode prepareTestTree2(){
        var x = new TreeNode(6);
        var y = new TreeNode(7);

        var a = new TreeNode(4, x, y);        //     1
        var b = new TreeNode(5);              //    / \
                                                  //   2  3
        var l = new TreeNode(2, a, b);        //  / \
        var r = new TreeNode(3);              // 4  5
                                                // / \
        return new TreeNode(1, l, r);       // 6  7
    }

    //[1,null,2,null,3] if parent is null supposed children are omitted during insertion ?
    //https://leetcode.com/problems/balanced-binary-tree/discuss/35897/Explain-test-case%3A-1null2null3
    private TreeNode prepareTestTree3(){            //     1
        var rr = new TreeNode(3);               //    / \
        var r = new TreeNode(2, null, rr);  //       2
                                                    //      / \
        return new TreeNode(1, null, r);        //     3
    }
}
