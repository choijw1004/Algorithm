package BOJ_6198_옥상정원꾸미기;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0 ; i < n; i++){
            nums[i] = sc.nextInt();
        }

        Stack<Integer> s = new Stack<>();
        long ans = 0;
        for(int i = 0 ; i < n; i++){
            while(!s.isEmpty() && nums[s.peek()] <= nums[i]){
                s.pop();
            }
            ans += s.size();
            s.push(i);
        }
        System.out.println(ans);
    }
}
