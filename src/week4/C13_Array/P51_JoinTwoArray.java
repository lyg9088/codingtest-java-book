package week4.C13_Array;

public class P51_JoinTwoArray {
    private static int[] solution(int[] arr1, int[] arr2) {
        // 정렬된 배열을 저장할 배열 생성
        int[] merged = new int[arr1.length+arr2.length];
        int k=0, i=0, j=0; // 3개 배열의 인덱스 초기화

        // 두 배열을 순회하면서 정렬된 배열을 생성
        while (i<arr1.length && j<arr2.length) {
            merged[k++] = arr1[i] <= arr2[j]? arr1[i++] : arr2[j++];
        }

        // arr1이나 arr2 중 남아 있는 원소들을 정렬된 배열 뒤에 추가
        while (i<arr1.length) {
            merged[k++] = arr1[i++];
        }
        while (j<arr2.length) {
            merged[k++] = arr2[j++];
        }
        return merged;
    }
}
