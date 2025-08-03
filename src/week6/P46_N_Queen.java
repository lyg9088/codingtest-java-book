package week6;

public class P46_N_Queen {
    private static int N;
    private static boolean[] width;
    private static boolean[] diagonal1;
    private static boolean[] diagonal2;

    // 1. 퀸이 서로 공격할 수 없는 위치에 놓이는 경우의 수를 구하는 함수
    private static int getAns(int y) {
        int ans = 0;
        // 2. 모든 행에 대해서 퀸의 위치가 결정되었을 경우
        if (y==N) {
            // 3. 해결 가능한 경우의 수를 1 증가시킴
            ans++;
        }
        else {
            // 4. 현재 행에서 퀸이 놓일 수 있는 모든 위치를 시도 -> y(행), i(열), y는 아래로..
            for (int i = 0; i < N; i++) {
                // 5. 해당 위치에 이미 퀸이 있는 경우, 대각선상에 퀸이 있는 경우 스킵
                if (width[i] || diagonal1[i+y] || diagonal2[i-y+N]) {
                    continue;
                }

                // 6. 해당 위치에 퀸을 놓음
                width[i] = diagonal1[i+y] = diagonal2[i-y+N] = true;
                // 7. 다음 행으로 이동하여 재귀적으로 해결 가능한 경우의 수 찾기
                ans += getAns(y+1);
                // 8. 해당 위치에 놓인 퀸을 제거함
                width[i] = diagonal1[i+y] = diagonal2[i-y+N] = false;
            }
        }
        return ans;
    }

    public int solution(int n) {
        N = n;
        width= new boolean[n];
        diagonal1 = new boolean[n*2];
        diagonal2 = new boolean[n*2];
        int answer = getAns(0);
        return answer;
    }
}
