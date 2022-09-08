package easyMatrix;

import java.util.Arrays;

public class _0867_TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] out = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                out[j][i] = matrix[i][j];
            }
        }

        return out;
    }

    public void run() {
        System.out.println("_0867_TransposeMatrix: ");
        System.out.println("Expected: [[1,4,7],[2,5,8],[3,6,9]]   Actual: " + Arrays.deepToString(transpose(prepareTestGrid())));
    }

    private int[][] prepareTestGrid(){
        return new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}};
    }
}
