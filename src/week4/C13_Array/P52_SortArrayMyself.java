package week4.C13_Array;

import java.util.Arrays;

public class P52_SortArrayMyself {

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> o1.charAt(n) == o2.charAt(n) ? o1.compareTo(o2) : Character.compare(o1.charAt(n), o2.charAt(n)));
        return strings;
    }
}

// 시간 복잡도 : N은 strings의 길이... Arrays.sort()메서드의 시간 복잡도를 고려하면 최종 시간 복잡도는 O(NlogN) 입니다.

// Arrays.sort() 메서드 시간복잡도
// 1. 기본형 배열(int[], double[] 등 primitive type)
// - Java 7 이상에서는 Dual-Pivot QuickSort 알고리즘 사용
// - 시간복잡도 : 평균 O(nlog n), 최악 O(n^2)
// - 하지만, Dual-pivot QuickSort는 일반 QuickSort보다 분할 효율이 좋아서 실제로는 매우 빠릅니다.
// - 안정 정렬(Stable sort) X

// 2. 객체 배열(Integer[], String[] 등 참조형)
// - Java 7 이상에서는 Timsort 알고리즘 사용 (병합정렬 + 삽입정렬 혼합)
// - 시간복잡도 : 평균 O(n log n), 최선(부분적으로 정렬된 경우) O(n), 최악 O(nlog n)
// - 안정정렬(stable sort) O (동일한 값의 순서 보장)

