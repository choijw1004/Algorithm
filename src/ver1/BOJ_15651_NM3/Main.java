package BOJ_15651_NM3;
import java.util.*;

public class Main {
    private static void backTracking(int n, int m, List<Integer> list, int cnt){
        if(m == cnt){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < list.size(); i++){
                sb.append(list.get(i) + " ");
            }
            System.out.println(sb.toString().trim());
            return;
        }

        for(int i = 1; i <= n; i++){
            list.add(i);
            backTracking(n,m,list,cnt+1);
            list.remove(list.size()-1);
        }

    }
    private static void solution(int n, int m){
        List<Integer> list = new ArrayList<>();
        backTracking(n,m,list,0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        solution(n,m);
    }
}
