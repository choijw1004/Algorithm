package BOJ_2493_탑;
import java.util.*;

public class Main {
    private static void solution(int[] towers){
        StringBuilder sb = new StringBuilder();
        int n = towers.length;
        int[] ans = new int[n];
        Stack<Integer> s = new Stack<>();


        for(int curr = n-1; curr >0; curr--){
            while(!s.isEmpty() && towers[s.peek()] < towers[curr]){
                int prev = s.pop();
                ans[prev] = curr + 1;
            }
            s.push(curr);
        }
        for (int i = 0; i < n; i++){
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString());

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] towers = new int[N];

        for(int i = 0 ; i < N; i++){
            towers[i] = sc.nextInt();
        }
        solution(towers);
    }
}
