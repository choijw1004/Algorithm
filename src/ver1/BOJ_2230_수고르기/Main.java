package BOJ_2230_수고르기;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int mindiff = sc.nextInt();
        int[] nums = new int[N];

        for(int i = 0 ; i < N; i++){
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        int left = 0;
        int right = 0;

        int ans = Integer.MAX_VALUE;

        while(left < N && right < N) {
            int diff = nums[right] - nums[left];

            if(diff >= mindiff){
                ans = Math.min(diff, ans);
                left++;
            }
            else{
                right++;
            }
        }
        System.out.println(ans);
    }
}
