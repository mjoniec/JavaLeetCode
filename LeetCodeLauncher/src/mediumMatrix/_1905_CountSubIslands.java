package mediumMatrix;

import java.util.ArrayList;

public class _1905_CountSubIslands {
    //0 - water
    //1 - land
    //2,3,4... -land belonging to island with given id
    //do ids for grid1 and grid2
    //foreach island in grid2 check if each corresponding land in grid1 has the same id
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int id = 2;
        for(int y=0;y<grid1.length;y++)
        for(int x=0;x<grid1[y].length;x++)
            if(grid1[y][x] == 1) markLandCheckAdjacentRecursively(y, x, grid1, id++);

        id = 2;
        for(int y=0;y<grid1.length;y++)
        for(int x=0;x<grid1[y].length;x++)
            if(grid2[y][x] == 1) markLandCheckAdjacentRecursively(y, x, grid2, id++);

        int count = 0;
        for(int i = 2; i<id; i++) if(isIslandCorresponding(grid1, grid2, i)) count++;
        return count;
    }

    private boolean isIslandCorresponding(int[][] grid1, int[][] grid2, int id){
        var correspondingIds = new ArrayList<Integer>();
        for(int y=0;y<grid1.length;y++)
        for(int x=0;x<grid1[y].length;x++)
            if(grid2[y][x] == id) correspondingIds.add(grid1[y][x]);

        //no water
        if(correspondingIds.stream().anyMatch(i->i==0)) return false;
        //all corresponding ids are to be from the same island else fails
        if(!correspondingIds.stream().allMatch(i->i==correspondingIds.get(0))) return false;

        return true;
    }

    private void markLandCheckAdjacentRecursively(int y, int x, int[][]grid, int id){
        if(grid[y][x] == 0 || grid[y][x] == id) return;
        grid[y][x] = id;
        leftMarkLand(y, x, grid, id);
        rightMarkLand(y, x, grid, id);
        upMarkLand(y, x, grid, id);
        downMarkLand(y, x, grid, id);
    }

    private void leftMarkLand(int y, int x, int[][]grid, int id){
        if(x==0) return;
        if(grid[y][x-1] == 1) markLandCheckAdjacentRecursively(y, x-1, grid, id);
    }

    private void rightMarkLand(int y, int x, int[][]grid, int id){
        if(x == grid[0].length-1) return;
        if(grid[y][x+1] == 1) markLandCheckAdjacentRecursively(y, x+1, grid, id);
    }

    private void upMarkLand(int y, int x, int[][]grid, int id){
        if(y == 0) return;
        if(grid[y-1][x] == 1) markLandCheckAdjacentRecursively(y-1, x, grid, id);
    }

    private void downMarkLand(int y, int x, int[][]grid, int id){
        if(y == grid.length-1) return;
        if(grid[y+1][x] == 1) markLandCheckAdjacentRecursively(y+1, x, grid, id);
    }

    public void run() {
        System.out.println("_1254_NumberOfClosedIslands");
        System.out.println("Expected: 3 Actual: " + countSubIslands(
                new int[][]{
                    {1,1,1,0,0},
                    {0,1,1,1,1},
                    {0,0,0,0,0},
                    {1,0,0,0,0},
                    {1,1,0,1,1}},
                new int[][]{
                    {1,1,1,0,0},
                    {0,0,1,1,1},
                    {0,1,0,0,0},
                    {1,0,1,1,0},
                    {0,1,0,1,0}}
                ));
    }
}
