package week4.C13_Array;

public class P50_CountingSort {
    private static String solution(String s) {
        int[] counts = new int[26]; // 1. 알파벳 개수(26개)만큼 빈두수 배열 생성

        // 2. 문자열의 각 문제에 대한 빈도수를 count배열에 저장
        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        // 3. 빈도수 배열을 순회하면서 정렬된 문자열을 생성
        StringBuilder sortedStr = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < counts[i]; j++) {
                sortedStr.append((char) (i + 'a'));
            }
        }
        return sortedStr.toString();
    }
}
