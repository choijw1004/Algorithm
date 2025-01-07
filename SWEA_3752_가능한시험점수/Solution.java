package SWEA_3752_가능한시험점수;
import java.util.*;

public class Solution {
    static int N;
    static int[] nums;
    static HashSet<Integer> scores;

    public static void dfs(int index, int sum){
        if(index == N){
            scores.add(sum);
            return;
        }

        dfs(index + 1, sum + nums[index]);
        dfs(index + 1, sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {

            N = sc.nextInt();
            nums = new int[N];
            scores = new HashSet<>();

            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }
            dfs(0, 0);

            System.out.println("#" +tc + " " + scores.size());

        }
    }
}
