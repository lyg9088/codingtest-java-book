package week7;

public class P65_JumpAndTeleport {
    public int solution(int n) {
        return Integer.toBinaryString(n).replace("0","").length();
    }
}
