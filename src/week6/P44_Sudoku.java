package week6;

import java.util.Arrays;

public class P44_Sudoku {
    private static class Block {
        int i,j;
        public Block(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static int[][] Board;

    private static boolean isValid(int num, int row, int col) {
        // 1. 현재 위치에 num이 들어갈 수 있는지 검사
        return !(inRow(num, row) || inCol(num,col) || inBox(num,row,col));
    }

    private static boolean inRow(int num, int row) {
        // 2. 해당 행에 num이 있는지 확인
        return Arrays.stream(Board[row]).anyMatch(n->n == num);
    }

    private static boolean inCol(int num, int col) {
        // 3. 해당 열에 num이 있는지 확인
        for (int i = 0; i < 9; i++) {
            if (Board[i][col] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean inBox(int num, int row, int col) {
        // 4. 현재 위치의 3x3 박스에 num이 있는지 확인
        int boxRow = (row/3) *3;
        int boxCol = (col/3) *3;

        for (int i = boxRow; i < boxRow+3; i++) {
            for (int j = boxCol; j < boxCol+3; j++) {
                if (Board[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

private static Block findEmptyPosition() {
    // 5. 스도쿠 보드에서 비어 있는 위치 반환
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (P44_Sudoku.Board[i][j] == 0) {
                return new P44_Sudoku.Block(i,j);
            }
        }
    }
    return null;
}

private static boolean findSolution() {
    // 6. 비어있는 위치에 가능한 숫자를 넣어가며 스도쿠 해결
    P44_Sudoku.Block emptyPos = findEmptyPosition();
    // 7. 빈칸이 없으면 스도쿠가 해결된 것으로 간주
    if (emptyPos == null)
        return true;

    int row = emptyPos.i;
    int col = emptyPos.j;

        for (int num =1; num <=9; num++) {
            if (isValid(num, row, col)) {
                P44_Sudoku.Board[row][col] = num;
                // 8. 다음 빈칸을 재귀 탐색
                if (findSolution()) {
                    return true;
                }
                // 9. 가능한 숫자가 없으면 원래의 0으로 되돌림
                Board[row][col] = 0;
            }
        }
         return false;
    }

    private static int[][] solution(int[][] board) {
        Board = board;
        findSolution();
        return board;
    }
}