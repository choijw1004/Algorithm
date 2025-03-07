package BOJ_1561_놀이공원;
import java.util.*;

public class Main {
    public static int solution(int n, int m, int[] times){
        if(n <= m) return n;

        long left = 0;
        long right = 0;
        long maxTime = 0;

        for(int i = 0; i < m; i++){
            maxTime = Math.max(maxTime, times[i]);
        }
        right = maxTime * (long)n;

        long T = 0;

        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;
            for(int time : times){
                count += mid / time + 1;
            }

            if(count >= n){
                T = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        long childrenBefore = 0;
        for(int i = 0; i < m; i++){
            childrenBefore += (T - 1) / times[i] + 1;
        }
        LinkedHashMap<Integer,Integer> s = new LinkedHashMap<>();
        long remaining = n - childrenBefore;
        int answer = 0;
        for(int i = 0; i < m; i++){
            if(T % times[i] == 0){
                remaining--;
                if(remaining == 0){
                    answer = i + 1;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] times = new int[m];

        for(int i = 0; i < m; i++){
            times[i] = sc.nextInt();
        }

        System.out.println(solution(n, m, times));
    }
}
