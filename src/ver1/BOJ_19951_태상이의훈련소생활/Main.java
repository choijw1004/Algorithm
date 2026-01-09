package BOJ_19951_태상이의훈련소생활;
import java.util.*;

public class Main {
    private static String solution(int[] ground, int[][] changes) {
        int n = ground.length;
        StringBuilder ans = new StringBuilder();
        int[] diff = new int[n + 1];

        for (int[] c : changes) {
            int start = c[0] - 1;
            int end = c[1] - 1;
            int capa = c[2];

            diff[start] += capa;
            diff[end + 1] -= capa;
        }

        int acc = 0;
        for (int i = 0; i < n; i++) {
            acc += diff[i];
            ans.append(acc + ground[i] + " ");
        }
        return ans.toString().trim();

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ground = new int[n];
        int[][] changes = new int[m][3];
        for (int i = 0; i < n; i++) ground[i] = sc.nextInt();

        for (int i = 0; i < m; i++) {
            changes[i][0] = sc.nextInt();
            changes[i][1] = sc.nextInt();
            changes[i][2] = sc.nextInt();
        }

        System.out.println(solution(ground,changes));
    }
}

