package BOJ_5014_스타트링크;
import java.util.*;

public class Main {
    public static int solution(int top, int start, int target, int up , int down){
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()){
            int c = q.poll();

            if(c == target) return ans;

            if(c <= top){
                if(c < target) q.offer(c +2);
                else{
                    if(c > target) q.offer(c -1);
                }
            }
            ans++;
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int top = sc.nextInt();
        int start = sc.nextInt();
        int target = sc.nextInt();
        int up = sc.nextInt();
        int down = sc.nextInt();

        System.out.println(solution(top,start,target,up,down));

    }
}
