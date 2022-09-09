package easyMatrix;

import java.util.Arrays;

public class _0566_ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(!isReshapeable(mat,r,c)){
            return mat;
        }

        int[] tab = new int[mat.length*mat[0].length];
        int index = 0;

        for (int i=0; i<mat.length; i++) {
            for (int j=0; j<mat[i].length; j++) {
                tab[index++] = mat[i][j];
            }
        }

        int [][]out = new int[r][c];
        index = 0;

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                out[i][j] = tab[index++];
            }
        }

        return out;
    }

    private boolean isReshapeable(int[][] mat, int r, int c){
        return mat.length * mat[0].length == r * c;
    }

    public void run() {
        System.out.println("_0566_ReshapeTheMatrix: ");
        System.out.println("Expected: [1,2,3,4]   Actual: " + Arrays.deepToString(matrixReshape(prepareTestGrid(), 1, 4)));
    }

    private int[][] prepareTestGrid(){
        return new int[][]{
                {1,2},
                {3,4}};
    }
}
