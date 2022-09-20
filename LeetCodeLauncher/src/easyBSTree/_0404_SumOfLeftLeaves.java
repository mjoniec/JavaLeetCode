package easyBSTree;

import Utilities.TreeNode;

public class _0404_SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;

        if(isLeaf(root.left)){
            sum +=root.left.val;
        }
        else{
            sum += sumOfLeftLeaves(root.left);
        }

        if(isLeaf(root.right)){
            //for right leaves we do not sum up
        }
        else{
            sum += sumOfLeftLeaves(root.right);
        }

        return sum;
    }

    private boolean isLeaf(TreeNode node){
        return node != null && node.left == null && node.right == null;
    }

    public void run() {
        System.out.println("_0404_SumOfLeftLeaves");
        System.out.println("Expecte: 24 Actual: " + sumOfLeftLeaves(prepareTestNodes1()));
    }

    private TreeNode prepareTestNodes1(){
        var rr = new TreeNode(7);
        var rl = new TreeNode(15);

        var r = new TreeNode(20, rl, rr);
        var l = new TreeNode(9);

        return new TreeNode(3, l, r);
    }
}
