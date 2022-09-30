package mediumMatrix;

public class _1254_NumberOfClosedIslands {
    char[][] grid;
    //0 and 1 are reversed in this task
    //close island - island + no land on the border
    public int closedIsland(int[][] grid) {
        this.grid = new char[grid.length][grid[0].length];
        for (int y = 0; y<grid.length; y++)
        for (int x = 0; x<grid[0].length; x++)
            this.grid[y][x] = grid[y][x] == 1 ? '0' : '1';

        int count = 0;
        for(int y=0;y<grid.length;y++)
            for(int x=0;x<grid[y].length;x++)
                if(this.grid[y][x] == '1'){
                    markLandCheckAdjacentRecursively(y, x);
                    if(isClosedIsland()) count++;
                    ChangeTemporaryToPermanentLandMarkings();
                }

        return count;
    }

    private boolean isClosedIsland(){
        for (int y = 0; y<grid.length; y++)
        for (int x = 0; x<grid[0].length; x++)
            if(this.grid[y][x] == 'Z' &&
                (x==0 || y==0 || x==grid[0].length-1 || y==grid.length-1)) return false;
        return true;
    }

    private void markLandCheckAdjacentRecursively(int y, int x){
        if(grid[y][x] == '0' || grid[y][x] == 'X' || grid[y][x] == 'Z') return;
        grid[y][x] = 'Z';
        leftMarkLand(y, x);
        rightMarkLand(y, x);
        upMarkLand(y, x);
        downMarkLand(y, x);
    }

    private void leftMarkLand(int y, int x){
        if(x==0) return;
        if(grid[y][x-1] == '1') markLandCheckAdjacentRecursively(y, x-1);
    }

    private void rightMarkLand(int y, int x){
        if(x == grid[0].length-1) return;
        if(grid[y][x+1] == '1') markLandCheckAdjacentRecursively(y, x+1);
    }

    private void upMarkLand(int y, int x){
        if(y == 0) return;
        if(grid[y-1][x] == '1') markLandCheckAdjacentRecursively(y-1, x);
    }

    private void downMarkLand(int y, int x){
        if(y == grid.length-1) return;
        if(grid[y+1][x] == '1') markLandCheckAdjacentRecursively(y+1, x);
    }

    private void ChangeTemporaryToPermanentLandMarkings(){
        for (int y = 0; y< grid.length; y++)
            for (int x = 0; x< grid[0].length; x++)
                if (grid[y][x] == 'Z') grid[y][x] = 'X';
    }

    public void run() {
        System.out.println("_1254_NumberOfClosedIslands");
        System.out.println("Expected: 2 Actual: " + closedIsland(new int[][]{
                {1,1,1,1,1,1,1},
                {1,0,0,0,0,0,1},
                {1,0,1,1,1,0,1},
                {1,0,1,0,1,0,1},
                {1,0,1,1,1,0,1},
                {1,0,0,0,0,0,1},
                {1,1,1,1,1,1,1}}));
        System.out.println("Expected: 2 Actual: " + closedIsland(new int[][]{
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}}));
    }
}
