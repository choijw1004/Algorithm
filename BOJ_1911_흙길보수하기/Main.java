package BOJ_1911_흙길보수하기;
import java.util.*;

public class Main {
    public static int solution(int[][] dummys, int l){
        int ans = 0;
        int coverEnd = 0;

        Arrays.sort(dummys, (a,b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1],b[1]);
            else return Integer.compare(a[0],b[0]);
        });

        for(int[] dummy : dummys){
            int s = dummy[0];
            int e = dummy[1];

            if(coverEnd < s ) coverEnd = s;

            while(coverEnd < e){
                ans++;
                coverEnd += l;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();

        int[][] dummys = new int[n][2];
        for(int i = 0; i < n; i++){
            dummys[i][0] = sc.nextInt();
            dummys[i][1] = sc.nextInt();
        }
        System.out.println(solution(dummys, l));

    }
}
