package BOJ_11650_좌표정렬하기;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        for(int i = 0; i < n; i++){
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }

        Arrays.sort(nums, (a,b) -> {
            if(a[0] == b[0]) return Integer.compare(a[1] , b[1]);
            else return Integer.compare(a[0],b[0]);
        });

        for(int[] num : nums){
            System.out.println(num[0] + " " +num[1]);
        }
    }
}
