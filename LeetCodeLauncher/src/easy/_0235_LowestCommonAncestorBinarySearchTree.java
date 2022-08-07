package easy;

import Utilities.TreeNode;

import static Utilities.TreeNode.print_r;

public class _0235_LowestCommonAncestorBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode next = root;

        while(true){
            if(next.val == p.val){
                return p;
            }
            if(next.val == q.val){
                return q;
            }
            if((p.val > next.val && q.val < next.val) ||
                    (p.val < next.val && q.val > next.val)){
                return next;
            }
            if(p.val > next.val){
                next = next.right;
            }
            else{
                next = next.left;
            }
        }
    }

    public void run() {
        System.out.println("_0235_LowestCommonAncestorBinarySearchTree");

        System.out.println("Given:");
        var sb = new StringBuffer();
        print_r(prepareTestNodes(), 0, sb);
        System.out.println(sb);
        System.out.println("Search for LCA for 2 and 8, Expected: 6, Actual: "
                + lowestCommonAncestor(prepareTestNodes(), new TreeNode(2), new TreeNode(8)).val);
        System.out.println("Search for LCA for 2 and 4, Expected: 2, Actual: "
                + lowestCommonAncestor(prepareTestNodes(), new TreeNode(2), new TreeNode(4)).val);
    }

    public TreeNode prepareTestNodes(){
        var x = new TreeNode(3);
        var y = new TreeNode(5);

        var a = new TreeNode(0);
        var b = new TreeNode(4, x, y);
        var c = new TreeNode(7);
        var d = new TreeNode(9);

        var left = new TreeNode(2, a, b);
        var right = new TreeNode(8, c, d);

        var root = new TreeNode(6, left, right);

        return root;
    }
}
