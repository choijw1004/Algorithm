package BOJ_13144_LOUN;
import java.util.*;

public class Main {
    public static int solution(int[] nums){
        int n = nums.length;
        int ans = 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        HashSet<Integer> hs = new HashSet<>();

        while(right < n){
            int num = nums[right];
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
