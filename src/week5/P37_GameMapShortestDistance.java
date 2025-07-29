package week5;

import java.util.ArrayDeque;

// 역시 저자님 말대로 분석 설계가 70퍼센트 같다.
// 이런 문제도 어떤 알고리즘을 써야하고, 해당 알고리즘을 알고 보니까
// 저자님이 왜 이렇게 썼는지 이해도 되고ㅠㅠ
// 그래서 알고리즘만 이해하면 풀 수 있어서 유명한 알고리즘이겠지 싶긴 한데..
// 그나마 이해되는게 감사하고, 반복 학습해야겠다 생각이 든다..
// 이직도 중요하지만, 기본이 탄탄한 부끄럽지 않은 IT인이 되자..

public class P37_GameMapShortestDistance {
    public static void main(String[] args) {
        // 게임 맵 최단 거리 - BFS 활용..
        // 지나갈수 있는 곳은 1, 벽은 0
        // 처음 캐릭터는 (1,1), 상대 팀 진영은 (n, m) 위치에 있음
        // 이 문제처럼.. 지나가야 하는 길의 최소개수를 반환하는... -> BFS 써야겠구나! 생각..

        // 저자님 풀이 보면서, 표현방식 익힘...
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }
    // 1. 이동할 수 있는 방향을 나타내는 배열 rx, ry 선언
    private static final int[] rx = {0, 0, 1, -1};
    private static final int[] ry = {1, -1, 0, 0};

    private static class Node {
        int r, c;
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int solution(int[][] maps) {
        // 2. 맴의 크기를 저장하는 변수 선언
        int N = maps.length;
        int M = maps[0].length; // 문제 풀다보면 2차원 배열 접근법에 대한 이해가 빨라지는듯

        // 3. 최단 거리를 저장할 배열 생성
        int[][] dist = new int[N][M];

        // 4. bfs 탐색을 위한 큐 생성
        ArrayDeque<Node> queue = new ArrayDeque<>();

        // 5. 시작 정점에 대해서 큐에 추가 최단 거리 저장
        queue.addLast(new Node(0,0));
        dist[0][0] = 1; // 처음에 시작 정점...

        // 6. queue가 빌 때까지 반복
        while(!queue.isEmpty()) {
            Node now = queue.pollFirst();

            // 7. 현재 위치에서 이동할 수 있는 모든 방향
            for (int i=0; i<4; i++) {
                int nr = now.r + rx[i];
                int nc = now.c + ry[i];

                // 8. 맵 밖으로 나가는 경우 예외 처리
                if (nr<0 || nc<0 || nr >= N || nc >= M) {
                    continue;
                }

                // 9. 벽으로 가는 경우 예외 처리
                if (maps[nr][nc] == 0) {
                    continue;
                }

                // 10. 이동한 위치가 처음 방문하는 경우, queue에 추가하고 거리 갱신
                if (dist[nr][nc] == 0) {
                    queue.addLast(new Node(nr, nc));
                    dist[nr][nc] = dist[now.r][now.c]+1;
                }
            }
        }

        // 목적지까지 최단 거리 반환, 목적지에 도달하지 못한 경우에는 -1 반환
        return dist[N-1][M-1] == 0? -1: dist[N-1][M-1];
    }
}
