package BOJ_2258_정육점;
import java.util.*;
public class Main {
    public static int solution(int[][] meats, int m){
        int ans = 0;
        int n = meats.length;
        //가격 낮은 순 무게 높은 순
        Arrays.sort(meats, (a,b) -> {
            if(a[1] == b[1]) return b[0] - a[0];
            return a[1] - b[1];
        });
        List<Integer> list = new ArrayList<>();
        int prePrice = 0;
        int weihgt = 0;

        for(int[] meat : meats){
            int w = meat[0];
            int currPrice = meat[1];

            if(currPrice == prePrice) continue;
            else{

            }
        }


        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] meats = new int[n][2];
        int max = 0;
        for(int i = 0 ; i < n; i++){
            meats[i][0] = sc.nextInt();
            meats[i][1] = sc.nextInt();
            max += meats[i][0];
        }
        System.out.println(m > max ? -1 : solution(meats, m) );
    }
}
