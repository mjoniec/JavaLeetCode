package easyBSTree;

import Utilities.TreeNode;

import static Utilities.TreeNode.print_r;

public class _0617_MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        if(root1 == null) return root2;
        if(root2 == null) return root1;

        return new TreeNode(
                root1.val + root2.val,
                mergeTrees(root1.left, root2.left),
                mergeTrees(root1.right, root2.right)
        );
    }

    public void run() {
        System.out.println("_0617_MergeTwoBinaryTrees");

        var sb = new StringBuffer();
        System.out.println("Expected [11,22,33,null, null, 4, 5]  Actual: ");
        print_r(mergeTrees(prepareTestNodes1(), prepareTestNodes2()), 0, sb);
        System.out.println(sb);
    }

    private TreeNode prepareTestNodes1() {
        var y = new TreeNode(5);
        var x = new TreeNode(4);
        var r = new TreeNode(3, x, y);
        var l = new TreeNode(2, null, null);
        return new TreeNode(1, l, r);
    }

    private TreeNode prepareTestNodes2() {
        var r = new TreeNode(30);
        var l = new TreeNode(20);
        return new TreeNode(10, l, r);
    }
}
