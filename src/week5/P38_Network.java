package week5;

public class P38_Network {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(solution(n,computers));
    }

    private static boolean[] visit;
    private static int[][] computer;

    private static void dfs(int now) { // now : 현재 방문하는 노드
        visit[now] = true; // 1. 현재 노드 방문 처리
        for (int i=0; i<computer.length; i++) {
            // 2. 연결되어 있으며 방문하지 않은 노드라면
            if (computer[now][i] == 1 && !visit[i]) {
                dfs(i); // 3. 해당 노드를 방문하러 이동
            }
        }
    }

    public static int solution(int n, int[][] computers) { // computers : 그래프
        int answer = 0;
        computer = computers;
        visit = new boolean[n]; // 4. 방문 여부를 저장할 배열

        for (int i = 0; i < n; i++) {
            if (!visit[i]) { // 5. 아직 방문하지 않은 노드라면 해당 노드를 시작으로 깊이 우선 탐색 진행
                dfs(i);
                answer++; // 6. DFS로 연결된 노드들을 모두 방문하면서 네트워크 개수 증가
            }
        }
        return answer;
    }
}
