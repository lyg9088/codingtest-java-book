package week4.C10_Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class P31_Poketmon {
    public static void main(String[] args) {
        /*
        * N마리의 포켓몬 중 N/2마리를 가져가도 됨.
        * 포켓몬에 번호를 붙여 구분. 같은 종류의 포켓몬은 같은 번호임.
        * 최대한 다양한 종류의 포켓못을 가지길 원하기 때문에 최대한 많은 종류으의 포켓몬을 얻을 수 있는 N/2마리를 선택하려 함.
        *
        * [ 제약조건 ]
        * nums : 포켓몬의 종류 번호가 담긴 1차원 배열
        * nums 길이 : 1 이상 10,000 이하의 자연수. 항상 짝수.
        * 포켓몬의 종류 번호는 1 이상 200,000 이하의 자연수
        * 가장 많은 종류의 포켓몬을 선택하는 방법이 여러 가지일 때에도, 선택할 수 있는 포켓몬 종류 개수의 최댓값 하나만 반환하면 됨
        *
        * [ 입출력 ]
        * nums                result
        * [3, 1, 2, 3]          2
        * [3, 3, 3, 2, 2, 4]    3
        * [3, 3, 3, 2, 2, 2]    2
        * */

        System.out.println(solution(new int[]{3, 1, 2, 3}));
    }

    public static int solution(int[] nums) {
        // 1. nums 리스트에서 중복을 제거한 집합(set)을 구함
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        // 2. 포켓몬의 총 수
        int n = nums.length;
        // 3. 선택할 포켓몬의 수
        int k = n/2;
        // 4. 중복을 제거한 포켓몬의 종류 수와 선택할 포켓몬의 수 중 작은 값 반환
        return Math.min(k, set.size()); // 왜 더 작은 값을 return 할까?
        // 중복을 제거한 집합의 총 사이즈가 선택할 수 있는 최대 포켓몬 수니까... 그것보다 큰거는 말이 안되서 그렇다.
        // 정말 저자님 말대로 자료구조만 잘 선택해도..
    }
}
