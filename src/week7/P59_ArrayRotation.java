package week7;

public class P59_ArrayRotation {
    // 1. 2차원 배열을 인자로 받고, 90도 회전시키는 메서드
    private static int[][] rotate90(int[][] arr) {
        // 2. 배열의 크기 저장
        int n = arr.length;
        // 3. 배열의 크기와 동일한 2차원 배열 생성(초깃값은 0)
        int[][] rotatedArr = new int[n][n];

        // 4. 배열을 90도 회전
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                rotatedArr[j][n-i-1] = arr[i][j];
            }
        }

        // 5. 90도 회전한 배열 반환
        return rotatedArr;
    }
}
