package easySortBfs;

import Utilities.TreeNode;

public class _0101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {


        return false;
    }

    public void run() {
        System.out.println("_101_SymmetricTree: ");
        System.out.println("Input: symmetric,  Expected: true   Actual: " + isSymmetric(prepareTestTree1()));
        System.out.println("Input: non symmetric,  Expected: false   Actual: " + isSymmetric(prepareTestTree1()));
    }

    private TreeNode prepareTestTree1(){
        var a = new TreeNode(3);
        var b = new TreeNode(4);
        var c = new TreeNode(4);
        var d = new TreeNode(3);

        var left = new TreeNode(2, a, b);
        var right = new TreeNode(2, c, d);

        var root = new TreeNode(1, left, right);

        return root;
    }

    private TreeNode prepareTestTree2(){
        var b = new TreeNode(3);
        var d = new TreeNode(3);

        var left = new TreeNode(2, null, b);
        var right = new TreeNode(2, null, d);

        var root = new TreeNode(1, left, right);

        return root;
    }
}
