package BOJ_2437_저울;
import java.util.*;

public class Main {
    public static int solution(int[] weights){
        int ans = 0;

        Arrays.sort(weights);
        int result = 1;
        for (int weight : weights) {
            if (weight > result) break;
            result += weight;
        }
        ans = result;

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weights = new int[n];
        for(int i = 0 ; i < n; i++){
            weights[i] = sc.nextInt();
        }

        System.out.println(solution(weights));

    }
}
