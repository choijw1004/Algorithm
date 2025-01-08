package BOJ_9251_LCS;
import java.util.*;

public class Main {
    static int[][] DP;
    static String a, b;

    public static int calcuLCS(String a, String b){
        int aLen = a.length();
        int bLen = b.length();

        int res = -1;

        for (int i = 1; i < aLen + 1; i++) {
            for (int j = 1; j < bLen + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                }
                else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
                res = Math.max(DP[i][j], res);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.next();
        b = sc.next();

        int aLen = a.length();
        int bLen = b.length();

        DP = new int[aLen + 1][bLen + 1];

        int ans = calcuLCS(a, b);
        System.out.println(ans);

    }
}
