package easySortBfs;

import Utilities.TreeNode;

import java.util.Stack;

public class _0101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)  return true;

        var stack = new Stack<TreeNode>();
        TreeNode left, right;

        if(!isSymmetricAddToStack(root.left, root.right, stack)){
            return false;
        }

        while(!stack.empty()){
            if(stack.size() % 2 != 0) return false;//if odd we can stop

            right = stack.pop();
            left = stack.pop();

            //mirror check & add
            if(!isSymmetricAddToStack(left.left, right.right, stack)) return false;
            if(!isSymmetricAddToStack(left.right, right.left, stack)) return false;
        }

        return true;
    }

    private boolean isSymmetricAddToStack(TreeNode left, TreeNode right, Stack<TreeNode> s) {
        if(left == null && right == null){
            return true;
        }
        if(left != null && right == null){
            return false;
        }
        if(left == null && right != null){
            return false;
        }
        if(left.val != right.val) {
            return false;
        }

        s.push(left);
        s.push(right);

        return true;
    }

    public void run() {
        System.out.println("_101_SymmetricTree: ");
        System.out.println("Input: symmetric,  Expected: true   Actual: " + isSymmetric(prepareTestTree1()));
        System.out.println("Input: non symmetric,  Expected: false   Actual: " + isSymmetric(prepareTestTree2()));
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
