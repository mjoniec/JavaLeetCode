package easyBSTree;

import Utilities.TreeNode;

import java.util.*;

public class _0104_MaximumDepthOfBinaryTree {
    private int maxDepth(TreeNode root){
        if(root == null) return 0;

        var list = new ArrayList<Integer>();
        var stack = new Stack<TreeNode>();

        root.val = 1;//starting depth
        stack.add(root);

        while(!stack.isEmpty()){
            var node = stack.remove(0);
            list.add(node.val);

            if(node.left != null) {
                node.left.val = node.val + 1;
                stack.add(node.left);
            }
            if(node.right != null) {
                node.right.val = node.val + 1;
                stack.add(node.right);
            }
        }

        return Collections.max(list);
    }

    public void run() {
        System.out.println("_0104_MaximumDepthOfBinaryTree: ");
        System.out.println("Expected: 3   Actual: " + maxDepth(prepareTestTree()));
    }

    private TreeNode prepareTestTree(){
        var a = new TreeNode(15);              //     3
        var b = new TreeNode(7);               //    / \
                                                   //   9  20
        var r = new TreeNode(20, a, b);        //     / \
        var l = new TreeNode(9);              //    15  7

        return new TreeNode(3, l, r);
    }
}
