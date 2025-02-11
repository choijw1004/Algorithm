package BOJ_14921_용액합성하기;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];

        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        int left = 0;
        int right = N - 1;
        int minDiff = Integer.MAX_VALUE;
        int bestSum = 0;

        while(left < right){
            int sum = nums[left] + nums[right];
            int diff = Math.abs(sum);

            if(diff < minDiff){
                minDiff = diff;
                bestSum = sum;
            }

            if(sum < 0){
                left++;
            } else {
                right--;
            }
        }
        System.out.println(bestSum);
    }
}
