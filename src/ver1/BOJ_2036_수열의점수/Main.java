package BOJ_2036_수열의점수;
import java.util.*;

public class Main {
    public static int solution(int[] nums){
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;

        for(int i = 0; i < n ;i++){
            pq.offer(nums[i]);
        }



        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
        }

        System.out.println(solution(nums));
    }
}
