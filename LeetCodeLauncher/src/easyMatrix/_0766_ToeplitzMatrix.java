package easyMatrix;

public class _0766_ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void run() {
        System.out.println("_0766_ToeplitzMatrix: ");
        System.out.println("Expected: false   Actual: " + isToeplitzMatrix(prepareTestGrid1()));
        System.out.println("Expected: true   Actual: " + isToeplitzMatrix(prepareTestGrid2()));
    }

    private int[][] prepareTestGrid1(){
        return new int[][]{
                {1,2},
                {2,2}};
    }

    private int[][] prepareTestGrid2(){
        return new int[][]{
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}};
    }
}
