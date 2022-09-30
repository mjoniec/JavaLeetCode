package mediumMatrix;

public class _0200_NumberOfIslands {
    char[][] _grid;
    public int numIslands(char[][] grid) {
        _grid = grid;
        var islands = 0;
        for(int y=0;y<grid.length;y++) {
            for(int x=0;x<grid[y].length;x++) {
                if(grid[y][x] == '1'){
                    MarkLandCheckAdjacentRecursively(y, x);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void MarkLandCheckAdjacentRecursively(int y, int x){
        if(_grid[y][x] != '1' || _grid[y][x] == 'X') return;
        _grid[y][x] = 'X';

        left(y, x);
        right(y, x);
        up(y, x);
        down(y, x);
    }

    private void left(int y, int x){
        if(x==0) return;
        if(_grid[y][x-1] == '0') return;
        if(_grid[y][x-1] == 'X') return;
        if(_grid[y][x-1] == '1') MarkLandCheckAdjacentRecursively(y, x-1);
    }

    private void right(int y, int x){
        if(x == _grid[0].length-1) return;
        if(_grid[y][x+1] == '0') return;
        if(_grid[y][x+1] == 'X') return;
        if(_grid[y][x+1] == '1') MarkLandCheckAdjacentRecursively(y, x+1);
    }

    private void up(int y, int x){
        if(y == 0) return;
        if(_grid[y-1][x] == '0') return;
        if(_grid[y-1][x] == 'X') return;
        if(_grid[y-1][x] == '1') MarkLandCheckAdjacentRecursively(y-1, x);
    }

    private void down(int y, int x){
        if(y == _grid.length-1) return;
        if(_grid[y+1][x] == '0') return;
        if(_grid[y+1][x] == 'X') return;
        if(_grid[y+1][x] == '1') MarkLandCheckAdjacentRecursively(y+1, x);
    }

    public void run() {
        System.out.println("_0200_NumberOfIslands");
        System.out.println("Expected: 3 Actual: " + numIslands(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
    }
}
