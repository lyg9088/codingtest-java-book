package week4.C10_Set;

import java.util.ArrayList;

public class P30_UnionFind {
    // 부모 저장을 위한 배열
    private static int[] parent;

    // 루트 노드를 찾는 메서드
    private static int find(int x) {
        // 만약 x의 부모가 자기 자신이면, 즉 x가 루트 노드라면 x를 반환
        if (parent[x] ==x) { // 루트노드 찾았다!
            return x;
        }
        // 그렇지 않다면 x의 부모를 찾아서 parent[x]에 저장합니다.
        parent[x] = find(parent[x]);
        return parent[x]; // 찾은 루트 노드를 반환
        // 경로 압축! -> 루트 노트 찾을때까지....반복
    }

    private static void union(int x, int y) {
        int root1 = find(x); // x가 속한 집합의 루트 노드 찾기
        int root2 = find(y); // y가 속한 집합의 루트 노드 찾기
        parent[root2] = root1; // y가 속한 집합을 x가 속한 집합에 합침
    }

    private static Boolean[] solution(int k, int[][] operation) {
        // 노드의 수 만큼 배열 생성
        parent = new int[k];

        // 처음에는 각 노드가 자기 자신을 부모로 가지도록 초기화
        for (int i = 0; i < k; i++) {
            parent[i] = i;
        }

        ArrayList<Boolean> answer = new ArrayList<>();

        for (int[] op : operation) {
            if (op[0] == 0) { // 0 연산이면
                union(op[1], op[2]);
            } else { // 1 연산이면
                answer.add(find(op[1]) == find(op[2]));
            }
        }

        return answer.toArray(new Boolean[0]); // ArrayList<Boolean> -> Boolean[] 으로 바꾸기 위함...
        // Boolean[] 타입이라는 걸 명확히 알려주기 위함
        // new Boolean[0]은 그냥 타입만 알려주고, 크기는 Java가 자동으로 처리해줘서 간편하게 쓰는 관용구
        // 0 길이 배열을 넣어도 Java가 내부에서 크기 자동 맞춰줌 + 타임도 정확히 알려줌
    }
}
