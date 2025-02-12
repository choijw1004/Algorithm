package BOJ_7453_합이0네정수;
import java.util.*;

public class Main {

    public static int sol(int[][] nums){
        List<Integer> g1 = new ArrayList<>();
        List<Integer> g2 = new ArrayList<>();
        List<Integer> g3 = new ArrayList<>();
        List<Integer> g4 = new ArrayList<>();

        int cnt = 0;

        for(int j = 0; j < 4; j++){
            for(int i = 0; i < nums.length; i++){
                if(j == 0 ){
                    g1.add(nums[i][j]);
                }
                else if(j == 1){
                    g2.add(nums[i][j]);
                }
                else if(j == 2){
                    g3.add(nums[i][j]);
                }
                else{
                    g4.add(nums[i][j]);
                }

            }
        }
        List<Integer> sum1 = new ArrayList<>();
        List<Integer> sum2 = new ArrayList<>();

        for(int i = 0 ; i < g1.size(); i++){
            for(int j = 0; j < g2.size(); j++){
                sum1.add(g1.get(i) + g2.get(j));
                sum2.add(g3.get(i) + g4.get(j));
            }
        }
        Collections.sort(sum1);
        Collections.sort(sum2);
        for(int i = 0 ; i < sum1.size(); i++){
            int n1 = sum1.get(i);
            int upper = upper_bound(sum2, -(n1));
            int lower = lower_bound(sum2, -(n1));

            cnt += upper - lower ;
        }

        return cnt;
    }

    public static int lower_bound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public static int upper_bound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] nums = new int[N][4];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < 4; j++){
                nums[i][j] = sc.nextInt();
            }
        }
        System.out.println(sol(nums));

    }
}
