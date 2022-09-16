package easyTree;

import Utilities.TreeNode;

public class _0100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }

        if((p == null || q == null) || (p.val != q.val)){
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public void run() {
        System.out.println("_0100_SameTree");
        System.out.println("Expected true Actual: " + isSameTree(prepareTestNodes(), prepareTestNodes()));
        System.out.println("Expected false Actual: " + isSameTree(prepareTestNodes2(), prepareTestNodes3()));

    }

    public TreeNode prepareTestNodes(){
        var left = new TreeNode(2);
        var right = new TreeNode(3);

        var root = new TreeNode(1, left, right);

        return root;
    }

    public TreeNode prepareTestNodes2(){
        var right = new TreeNode(2);
        var root = new TreeNode(1, null, right);

        return root;
    }

    public TreeNode prepareTestNodes3(){
        var left = new TreeNode(2);
        var root = new TreeNode(1, left, null);

        return root;
    }
}
