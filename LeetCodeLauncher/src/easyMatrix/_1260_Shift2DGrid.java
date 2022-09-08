package easyMatrix;

import java.util.ArrayList;
import java.util.List;

public class _1260_Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        var list = new ArrayList<Integer>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                list.add(grid[i][j]);
            }
        }

        while (k-- > 0) {
            list.add(0, list.remove(list.size() - 1));
        }

        List<List<Integer>> outputList = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < grid.length; i++) {
            var tmpList = new ArrayList<Integer>();

            for (int j = 0; j < grid[0].length; j++) {
                tmpList.add(list.get(index++));
            }

            outputList.add(tmpList);
        }

        return outputList;
    }

    public void run() {
        System.out.println("_1260_Shift2DGrid: ");
        System.out.println("Expected: [[9,1,2],[3,4,5],[6,7,8]]   Actual: " + shiftGrid(prepareTestGrid(), 1));
    }

    private int[][] prepareTestGrid(){
        return new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}};
    }
}
