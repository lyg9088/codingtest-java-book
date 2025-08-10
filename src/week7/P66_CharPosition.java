package week7;

import java.util.HashMap;

public class P66_CharPosition {
    // 1. 보드의 경계 좌표를 벗어나는지 확인하는 메서드
    private static boolean isInBounds(int x, int y, int dx, int dy) {
        return Math.abs(x+dx) <= width && Math.abs(y+dy) <= height;
    }
    private static int width, height;

    public int[] solution(String[] keyinput, int[] board) {
        // 2. 캐릭터의 초기 위치
        int x=0, y=0;
        // 3. 각 방향에 대한 움직임
        HashMap<String, int[]> moves = new HashMap<>();
        moves.put("up", new int[]{0,1});
        moves.put("down", new int[]{0,-1});
        moves.put("left", new int[]{-1,0});
        moves.put("right", new int[]{1,0});

        // 4. 게임 경계 좌표
        width = board[0]/2;
        height = board[1]/2;

        for (String key: keyinput) {
            // 5. 방향키에 따른 오프셋
            int dx = moves.get(key)[0];
            int dy = moves.get(key)[1];
            // 6. 게임 맵의 크기를 벗어나지 않는지 확인
            if (isInBounds(x,y,dx,dy)) {
                x += dx;
                y += dy;
            }
        }
        // 7. 캐릭터의 위치를 반환합니다.
        return new int[]{x,y};
    }
}
