    package BOJ_2512_예산;
    import java.util.*;

    //120 110 140 150
    //243

    // 120 110 140 150 = 230 290 = 520
    // 더 작게

    public class Main {
        public static int solution(int[] nums, int n, int max, int target){
            int left = 1;
            int right = target;
            int ans = 0;

            while(left <= right){
                int mid = (left + right) / 2;
                int sum = 0;

                for(int i = 0 ; i < n; i++){
                    int num = nums[i];

                    if(num >= mid){
                        sum += mid;
                    }
                    else{
                        sum += num;
                    }
                }

                if(sum <= max) {
                    ans = mid;
                    left = mid + 1;
                }
                else right = mid -1;
            }
            return ans;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int[] nums = new int[n];
            int target = 0;
            for(int i = 0 ; i < n; i++){
                nums[i] =sc.nextInt();
                target = Math.max(target, nums[i]);
            }

            int max = sc.nextInt();

            System.out.println(solution(nums, n, max, target));
        }
    }
