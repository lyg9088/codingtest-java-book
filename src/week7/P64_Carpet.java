package week7;

public class P64_Carpet {
    public int[] solution(int brown, int yellow) {
        // 1. 격자의 총 개수 (붉은색 격자 + 흰색 격자)
        int totalSize = brown + yellow;
        // 2. 세로 길이의 범위는 3부터 (붉은색 격자 + 흰색 격자)의 제곱근
        int sqrt = (int)Math.sqrt(totalSize);
        for (int vertical = 3; vertical <= sqrt; vertical++) {
            // 3. 사각형 구성이 되는지 확인
            if (totalSize % vertical == 0) {
                // 4. 사각형의 가로 길이
                int horizontal = (int)(totalSize / vertical);
                // 5. 카펫 형태로 만들 수 있는지 확인
                if (brown == (horizontal + vertical - 2)*2) {
                    return new int[]{horizontal, vertical}; // 6. [가로 길이, 세로 길이]
                }
            }
        }
        return new int[]{}; // 7. 만약 다을 찾지 못했다면 빈 리스트를 반환
    }
}
