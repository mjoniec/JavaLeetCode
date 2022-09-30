package mediumMatrix;

public class _0695_MaxAreaOfIsland {
    //what needs to be added to 200 search for islands
    //temporary land marker for current island recursive loop land search
    //count current island temporary marker - max
    //permanent land marker for outer loop to exit
    //possible markers: 0 1 X Z
    char[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = new char[grid.length][grid[0].length];
        for (int y = 0; y<grid.length; y++)
        for (int x = 0; x<grid[0].length; x++)
            this.grid[y][x] = grid[y][x] == 1 ? '1' : '0';

        int max = 0;
        for(int y=0;y<grid.length;y++)
        for(int x=0;x<grid[y].length;x++)
            if(this.grid[y][x] == '1'){
                markLandCheckAdjacentRecursively(y, x);
                max = Math.max(max, countIslandLand());
                ChangeTemporaryToPermanentLandMarkings();
            }

        return max;
    }

    private int countIslandLand(){
        var count = 0;
        for (int yy = 0; yy<grid.length; yy++)
        for (int xx = 0; xx<grid[0].length; xx++)
            if(this.grid[yy][xx] == 'Z') count++;
        return count;
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
        System.out.println("_0695_MaxAreaOfIsland");
        System.out.println("Expected: 6 Actual: " + maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0},
                }));
    }
}
