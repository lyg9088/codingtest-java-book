package week4.C13_Array;

import java.util.Arrays;

public class P54_KthNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int c=0; c<commands.length; c++) {
            int i = commands[c][0];
            int j = commands[c][1];
            int k = commands[c][2];

            // 1. i번째 부터 j번째까지 자르기
            int[] slicedArr = Arrays.copyOfRange(array, i-1, j);
            // 2. 자른 배열을 정렬하기
            Arrays.sort(slicedArr);
            // 3. k번째 원소 구하기
            answer[c] = slicedArr[k-1];
        }
        return answer;
    }
}

// N : array의 길이, M : commands의 길이
// commands의 각 원소에 대해 배열을 자르는 시간 복잡도는 O(N)이며,
// 이후 정렬을 포함한 시간 복잡도는 O(NlogN)입니다. 이를 M번 반복하므로
// 최종 시간 복잡도는 O(M*NlogN)입니다.
