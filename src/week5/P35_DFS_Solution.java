package week5;

import java.util.ArrayList;
import java.util.Arrays;

public class P35_DFS_Solution {
    public static void main(String[] args) {
        // 개념은 책으로 익혔음. 여기는 책에 문제풀이 연습한거..(ㅋㅋㅋ주로 뒤로 갈수록 저자님 풀이 타이핑이 주이지만..^^ 하나씩 익혀가는거지머..)
        // 깊이 우선 탐색(Depth First Search), 너비 우선 탐색(Breadth First Search), 다익스트라(Dijkstra) 알고리즘, 벨만 포드 알고리즘 드뎌 영접!ㅋㅋㅋㅋㅋㅋ
        // 개념은 코딩테스트합격자되기_자바편으로 익혔음!!!
        // DFS - 스택, 재귀 활용, BFS - 큐 활용 -> 방문 처리 시점이 다름 (책에 잘 나옴)
        // 다익스트라 - 최단 거리, 벨만-포드 : 음의 가중치 가질 때

        /*
        * 1. 문제 쪼개서 분석
        * 깊이 우선 탐색으로 모든 그래프의 노드를 순회하는 함수 solution()을 작성하세요.
        * 시작노드 start, [출발노드, 도착노드] 쌍들이 들어 있는 리스트 : graph, 반환값은 그래프의 시작 노드부터 모든 노드를 깊이 우선 탐색으로 지행한 순서대로 노드가 저장된 리스트
        * 2. 제약사항 파악 및 테스트케이스 추가
        * [제약조건]
        * 노드의 최대 개수를 100개를 넘지 않는다.
        * 시작 노드부터 시작해서 모든 노드를 방문할 수 있는 경로가 항상 있다.
        * 그래프의 노드는 문자열이다.
        *
        *
        * 3. 입출력사항 분석
        * graph [['1','2'],['2','3'],['3','4'],['4','5']], start '1', n : 5, return ['1', '2', '3', '4', '5']
        * graph [['1','2'],['1','3'],['2','4'],['2','5'],['3','6'],['5','6']], start '1', n : 6, return ['1','2','4','5','6','3']
        *
        * * 이 문제는 탐색 순서에 따라 정답이 여러 개일 수 있습니다.
        *
        * */
        int[][] graph = {{1,2},{2,3},{3,4},{4,5}};
        int start = 1;
        int n = 5;
        System.out.println(Arrays.toString(solution(graph, start, n)));
    }


    // 인접 리스트를 저장할 ArrayList 배열
    private static ArrayList<Integer>[] adjList;

    // 방문 여부를 저장할 boolean 배열
    private static boolean[] visited;
    private static ArrayList<Integer> answer;

    private static int[] solution(int[][] graph, int start, int n) {
        // 1. 인접 리스트 초기화
        adjList = new ArrayList[n+1];
        for (int i=0; i<adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 2. 그래프를 인접 리스트로 변환
        for (int[] edge : graph) {
            System.out.println("edge[0] : "+edge[0]);
            System.out.println("edge[1] : "+edge[1]);
            System.out.println();
            adjList[edge[0]].add(edge[1]); // 인덱스가 시작 노드, 값이 연결된 도착 노드 형태로 저장하는 것...
        }
        System.out.println(Arrays.toString(adjList));

        // DFS를 순회한 결과를 반환
        visited = new boolean[n + 1];
        answer = new ArrayList<>();
        dfs(start); // 7. 시작 노드에서 기핑 우선 탐색 시작

        // 8. DFS 탐색 결과 반환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    // 3. DFS 탐색 메서드
    private static void dfs(int now) { // 재귀함수로 깊이 우선 탐색(DFS) 할때 로직 그대로
        System.out.println("new =>"+now);
        visited[now] = true; // 4. 현재 노드를 방문했음을 저장
        answer.add(now); // 5. 현재 노드를 결과 리스트에 추가
        // 6. 현재 노드와 인접한 노드 순회
        for (int next : adjList[now]) {
            System.out.println("adList[now]:"+now);
            System.out.println("next : "+next);
            if (!visited[next]) {
                dfs(next); // 재귀함수 활용!
            }
        }
    }
}