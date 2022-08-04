package easy;

import Utilities.TreeNode;

import static Utilities.TreeNode.print_r;

public class _0226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public void run() {
        System.out.println("_0226InvertBinaryTree");
        System.out.println("Given: [4,2,7,1,3,6,9] Expected: [4,7,2,9,6,3,1]");

        System.out.println("Given formatted:");
        var sb = new StringBuffer();
        print_r(prepareTestNodes(), 0, sb);
        System.out.println(sb);

        System.out.println("Actual formatted:");
        sb = new StringBuffer();
        print_r(invertTree(prepareTestNodes()), 0, sb);
        System.out.println(sb);
    }

    public TreeNode prepareTestNodes(){
        var a = new TreeNode(1);
        var b = new TreeNode(3);
        var c = new TreeNode(6);
        var d = new TreeNode(9);

        var left = new TreeNode(2, a, b);
        var right = new TreeNode(7, c, d);

        var root = new TreeNode(4, left, right);

        return root;
    }
}
