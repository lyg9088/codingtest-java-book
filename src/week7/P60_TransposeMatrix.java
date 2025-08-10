package week7;

public class P60_TransposeMatrix {
    private static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        // 1. 결과 행렬을 0으로 초기화
        int[][] result = new int[3][3];
        // 2. 행렬 곱셈을 수행
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                for (int k=0; k<3; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    private static int[][] transposeMatrix(int[][] matrix) {
        // 3. 결과 행렬을 0으로 초기화
        int[][] result = new int[3][3];

        // 전치 행렬을 계산
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    private static int[][] solution(int[][] matrix1, int[][] matrix2) {
        // 주어진 두 행렬을 곱합
        int[][] multiplied = multiplyMatrices(matrix1, matrix2);

        // 곱셈 결과의 전치 행렬을 계산
        int[][] transposed = transposeMatrix(multiplied);
        return transposed;
    }
}
