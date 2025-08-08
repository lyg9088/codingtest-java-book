package week4.C13_Array;

import java.util.ArrayList;

public class P55_TheMostBigNumber {
    public String solution(int[] numbers) {
        // 1. int형 정수 배열을 문자열로 바꾸어 list에 저장
        ArrayList<String> list = new ArrayList<>();
        for (int number: numbers) {
            list.add(String.valueOf(number));
        }

        // 2. 조합하여 비교하여 더 큰 수를 기준으로 내림차순 정렬
        list.sort((o1, o2) -> {
           int a = Integer.parseInt(o1+o2);
           int b = Integer.parseInt(o2+o1);
           return Integer.compare(b, a);
        });

        // 3. 정렬된 수를 나열하여 문자열로 만듬
        StringBuilder sb = new StringBuilder();
        for (String str: list) {
            sb.append(str);
        }

        // 4. 문자열을 반환, 맨 앞에 "0"이 있는 경우는 "0"만 반환
        return sb.charAt(0) == '0'? "0": sb.toString();
    }
}
