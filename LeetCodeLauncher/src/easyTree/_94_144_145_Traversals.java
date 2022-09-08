package easyTree;

import Utilities.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _94_144_145_Traversals {

    public List<Integer> preorderTraversal(TreeNode root) {
        var list = new ArrayList<Integer>();

        preorder(root, list);

        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        var list = new ArrayList<Integer>();

        inorder(root, list);

        return list;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        var list = new ArrayList<Integer>();

        postorder(root, list);

        return list;
    }

    //3 DFS traversals:
    private void preorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;

        nums.add(root.val);
        preorder(root.left, nums);
        preorder(root.right, nums);
    }

    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;

        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    private void postorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;

        postorder(root.left, nums);
        postorder(root.right, nums);
        nums.add(root.val);
    }

    public void run() {
        System.out.println("_94_144_145_Traversals: ");
        System.out.println("Input: preorder,  Expected: 1,2,4,5,3   Actual: "
                + Arrays.toString(preorderTraversal(prepareTestTree()).toArray()));
        System.out.println("Input: inorder,  Expected: 4,2,5,1,3   Actual: "
                + Arrays.toString(inorderTraversal(prepareTestTree()).toArray()));
        System.out.println("Input: postorder,  Expected: 4,5,2,3,1   Actual: "
                + Arrays.toString(postorderTraversal(prepareTestTree()).toArray()));
    }

    private TreeNode prepareTestTree(){
        var a = new TreeNode(4);              //     1
        var b = new TreeNode(5);              //    / \
                                                  //   2  3
        var l = new TreeNode(2, a, b);        //  / \
        var r = new TreeNode(3);              //  4  5

        return new TreeNode(1, l, r);
    }
}
