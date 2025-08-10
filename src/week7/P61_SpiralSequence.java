package week7;

public class P61_SpiralSequence {
    private static int[][] solution(int n) {
        // 1. n크기의 2차원 배열 생성
        int[][] snailArray = new int[n][n];
        int num = 1; // 2. 달팽이 수열의 시작 숫자

        // 3. 행과 열의 시작과 끝 인덱스를 설정
        int startRow = 0, endRow = n-1;
        int startCol = 0, endCol = n-1;

        while (startRow <= endRow && startCol <= endCol) {
            // 4. 첫 번째 행 채우기
            for (int i=startCol; i<=endCol; i++) {
                snailArray[startRow][i] = num++;
            }
            startRow++;

            // 5. 마지막 열 채우기
            for (int i=startRow; i<=endRow; i++) {
                snailArray[i][endCol] = num++;
            }

            // 6. 마지막 행 채우기
            if (startRow <= endRow) {
                for (int i=endCol; i>=startCol; i--) {
                    snailArray[endRow][i] = num++;
                }
                endRow--;
            }

            // 7. 첫 번째 열 채우기
            if (startCol <= endCol) {
                for (int i=endRow; i>=startRow; i--) {
                    snailArray[i][startCol] = num++;
                }
                startCol++;
            }
        }
        return snailArray;

    }
}
