package week7;

public class P62_BinaryConversion {
    public int[] solution(String s) {

        // 1. 이진 변환 횟수를 저장하는 변수
        int countTransform = 0;
        // 2. 제거된 모든 0의 개수를 저장하는 변수
        int countZero = 0;

        // 3. s가 '1'이 아닌 동안 계속 반복
        while (!s.equals("1")) {
            // 4. 이진 변환 횟수를 1 증가
            countTransform++;
            // 5. s에서 '0'의 개수를 세어 countZero에 누적
            int zero = s.replace("1", "").length();
            countZero +=zero;
            // 6. s에서 '1'의 개수를 세고, 이를 이진수로 반환
            // Integer.toBinaryString() 메서드를 활용
            s = Integer.toBinaryString(s.length() - zero);
            // 7. 이진 변환 횟수와 제거된 모든 '0'의 개수를 배열에 담아 반환
        }
        return new int[]{countTransform, countZero};
    }
}
