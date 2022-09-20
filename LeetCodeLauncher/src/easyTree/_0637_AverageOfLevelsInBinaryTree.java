package easyTree;

import Utilities.TreeNode;

import java.util.*;

public class _0637_AverageOfLevelsInBinaryTree {
    private Map<Integer, Double> numberOfNodesPerLevel;
    private Map<Integer, Double> sumOfNodesValuesPerLevel;

    public List<Double> averageOfLevels(TreeNode root) {
        numberOfNodesPerLevel = new HashMap<>();
        sumOfNodesValuesPerLevel = new HashMap<>();
        List<Double> list = new ArrayList<>();

        bfsTraversalWithLevelTracking(1, root);

        for (var num : numberOfNodesPerLevel.entrySet()){
            var sum = sumOfNodesValuesPerLevel.get(num.getKey());
            var avg = sum / num.getValue();
            list.add(avg);
        }

        return list;
    }

    private void bfsTraversalWithLevelTracking(int level, TreeNode root){
        if(root == null) return;
        numberOfNodesPerLevel.merge(level, 1.0, Double::sum);
        sumOfNodesValuesPerLevel.merge(level, (double)root.val, Double::sum);
        level++;
        bfsTraversalWithLevelTracking(level, root.left);
        bfsTraversalWithLevelTracking(level, root.right);
    }

    public void run() {
        System.out.println("_0637_AverageOfLevelsInBinaryTree: ");
        System.out.println("Expected: [1.00000,2.50000,4.50000]   Actual: "
                + averageOfLevels(prepareTestTree()));
    }

    private TreeNode prepareTestTree(){
        var a = new TreeNode(4);
        var b = new TreeNode(5);
        var l = new TreeNode(2, a, b);
        var r = new TreeNode(3);
        return new TreeNode(1, l, r);
    }
}
