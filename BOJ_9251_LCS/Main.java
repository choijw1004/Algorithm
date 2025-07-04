package BOJ_9251_LCS;
import java.util.*;

public class Main {
    static int[][] DP;
    static String a, b;

    public static int calcuLCS(String a, String b){
        int n = a.length();
        int m = b.length();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    DP[i][j] = DP[i-1][j-1] + 1;
                }
                else DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
            }
        }

        return DP[n][m];

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
