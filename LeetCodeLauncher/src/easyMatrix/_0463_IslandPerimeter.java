package easyMatrix;

public class _0463_IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        int sum = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    sum += countBorders(grid, i, j);
                }
            }
        }

        return sum;
    }

    private int countBorders(int[][] grid, int i, int j){
        var sum = 0;

        //up
        if (i == 0 || grid[i-1][j] == 0) sum++;

        //down
        if (i == grid.length - 1 || grid[i+1][j] == 0) sum++;

        //left
        if (j == 0 || grid[i][j-1] == 0) sum++;

        //right
        if (j == grid[0].length - 1 || grid[i][j+1] == 0) sum++;

        return sum;
    }

    public void run() {
        System.out.println("_0463_IslandPerimeter: ");
        System.out.println("Expected: 16   Actual: " + islandPerimeter(prepareTestGrid()));
    }

    private int[][] prepareTestGrid(){
        return new int[][]{
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}};
    }
}
