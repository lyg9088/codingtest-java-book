package week4.C10_Set;

import java.util.Arrays;

public class P33_IslandConnect {
    public static void main(String[] args) {
        int[][] costs = new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        System.out.println(solution(4, costs));

    }

    private static int[] parent; // 루트노드

    private static int find(int x) {
        // 1. x가 속한 집합의 루트 노드 찾기
        if (parent[x] == x) { // 현재까지 다리를 높아 연결한 섬의 정보를 집합으로 나타낸 것.
            return x;
        }
        // 2. 경로 압축 : x의 부모를 루트로 설정
        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        // 3. 두 집합을 하나의 집합으로 합치기
        int root1 = find(x); // x의 루트를 찾아 root1에 저장
        int root2 = find(y); // y의 루트를 찾아 root2에 저장
        parent[root2] = root1;
    }

    public static int solution(int n, int[][] costs) {
        // 4. 비용을 기준으로 다리를 오름차순 정렬
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        // 5. parent 배열 초기화
        parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i; // 처음에..인덱스 : 본인값, 값 : 루트노드(자기자신)
        }

        int answer = 0; // 최소 신장 트리의 총비용
        int edges = 0; // 연결된 다리의 수

        for (int[] edge : costs) { // int[]로 도니까 2차원에 접근
            // 6. n-1 개의 다리가 연결된 경우 모든 섬이 연결됨
            if (edges == n-1) {
                break;
            }

            // 7. 현재 다리가 연결하는 두 섬이 이미 연결되어 있는지 확인
            if (find(edge[0]) != find(edge[1])) { // 집합이므로 루트노드가 같으면 연결되어 있는 것...
                // 8. 두 섬을 하나의 집합으로 연결함
                union(edge[0], edge[1]);
                // 9. 현재 다리의 건설 비용을 총비용에 추가
                answer += edge[2];
                // 10. 사용된 다리의 수 1증가
                edges++;
            }
        }
        return answer;
    }
}
