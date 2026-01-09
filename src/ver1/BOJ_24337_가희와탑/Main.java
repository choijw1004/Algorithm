package BOJ_24337_가희와탑;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        int[] ans = new int[N];

        Stack<Integer> stack = new Stack<>();
        Arrays.fill(ans,-1);

        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }

        for(int i = 0 ; i < N; i++){
            while(!stack.isEmpty() && stack.peek() < nums[i]){
                ans[i] = stack.pop();
            }

            stack.push(nums[i]);
        }


    }
}
