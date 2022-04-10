import java.util.Arrays;

/**
 * 1.8
 *
 * O 행렬 : M x N 행렬의 한 원소가 0일 경우, 해당 원소가 속한 행과 열의 모든
 * 원소를 0으로 설정하는 알고리즘을 작성하라.
 *
 * */
public class Problem1_8 {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,1,1,1,0}, {1,1,1,1,1}, {0,1,1,1,1}, {1,1,1,1,1}};
        set_zero(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    // 같은 행과 열에 있는 값을 모두 0으로 만들 것이기 때문에, 정확히 몇행 몇열에 있는지 알 필요는 없다.
    private static void set_zero(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        boolean[] rowZero = new boolean[rowLen]; // 해당 행에 0이 있는지 체크
        boolean[] colZero = new boolean[colLen]; // 해당 열에 0이 있는지 체크

        // 1. 값이 0인 곳을 찾아 행,열 인덱스 저장
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(matrix[i][j] == 0) {
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }

        // 2. 행의 원소 전부 0으로 바꿔준다.
        for (int i = 0; i < rowLen; i++) {
            if(rowZero[i]) changeRow(matrix, i);

        }

        // 3. 열의 원소 전부 0으로 바꿔준다.
        for (int j = 0; j < colLen; j++) {
            if(colZero[j]) changeCol(matrix, j);
        }

    }

    // 해당 열의 원소를 전부 0으로 바꿔주는 함수
    private static void changeCol(int[][] matrix, int col) {
        for (int j = 0; j < matrix.length; j++) {
            matrix[j][col] = 0;
        }
    }

    // 해당 행의 원소를 전부 0으로 바꿔주는 함수
    private static void changeRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }
}