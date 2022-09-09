package easyMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class _1030_MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] out = new int[rows * cols][2];
        var list = new ArrayList<Cell>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                list.add(new Cell(i,j,
                        Math.abs(i - rCenter) + Math.abs(j - cCenter)));
            }
        }

        Collections.sort(list, Comparator.comparingInt(c -> c.d));

        int index = 0;
        for (var cell:list) {
            out[index][0] = cell.i;
            out[index][1] = cell.j;
            index++;
        }

        return out;
    }

    public class Cell{
        public Cell(int i, int j, int d){
            this.i = i;
            this.j = j;
            this.d = d;
        }

        public int i;
        public int j;
        public int d;
    }

    public void run() {
        System.out.println("_1030_MatrixCellsInDistanceOrder: ");
        System.out.println("Expected (multiple possible): [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]   Actual: " +
                Arrays.deepToString(allCellsDistOrder(2, 3, 1, 2)));
    }
}
