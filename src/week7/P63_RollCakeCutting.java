package week7;

import java.util.HashMap;
import java.util.HashSet;

public class P63_RollCakeCutting {
    public int solution(int[] topping) {
        // 1. 결괏값을 저장할 변수 초기화
        int answer = 0;

        // 2. 토핑의 개수를 세어서 해시맵에 저장
        HashMap<Integer, Integer> toppingMap = new HashMap<>();
        for (int t : topping) {
            toppingMap.put(t, toppingMap.getOrDefault(t, 0) +1);
        }

        // 3. 토핑의 종류를 저장할 해시셋
        HashSet<Integer> toppingSet = new HashSet<>();

        // 4. 롤케이크를 하나씩 해시셋에 넣으면서 확인
        for (int t: topping) {
            // 5. 해시셋에 토핑을 추가하고, 해당 토핑의 전체 개수를 해시맵에서 줄임
            toppingSet.add(t);
            toppingMap.put(t, toppingMap.get(t)-1);

            // 6. 토핑의 전체 개수가 0이면 해시맵에서 제거
            if (toppingMap.get(t) == 0) {
                toppingMap.remove(t);
            }

            // 7. 토핑의 종류의 수가 같다면
            if (toppingSet.size() == toppingMap.size()) {
                answer++;
            }
        }
        // 8. 공평하게 나눌 수 있는 방법의 수 반환
        return answer;
    }
}
