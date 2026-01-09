package BOJ_15652_NM4;
import java.util.*;

public class Main {
    private static void backTracking(int n, int m, int cnt, List<Integer> list){
        if(m == cnt){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < list.size(); i++){
                sb.append(list.get(i) + " ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for(int i = 1; i <= n; i++){
            if(list.size() != 0 && list.get(list.size()-1) > i) continue;

            list.add(i);
            backTracking(n,m,cnt+1,list);
            list.remove(list.size()-1);
        }
    }
    private static void solution(int n, int m){
        List<Integer> list = new ArrayList<>();
        backTracking(n,m,0,list);
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();

       solution(n,m);
    }
}
