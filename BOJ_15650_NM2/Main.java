package BOJ_15650_NM2;
import java.util.*;

public class Main {
    private static void backTracking(int n, int m, List<Integer> list, boolean[] used){
        if(list.size() == m){
            StringBuilder sb = new StringBuilder();

            for(int i = 0 ; i < m; i++){
                sb.append(list.get(i) + " ");
            }

            System.out.println(sb.toString().trim());
        }

        for(int i = 1; i <= n; i++){
            if(used[i]) continue;
            if (!list.isEmpty() && list.get(list.size() - 1) > i) continue;

            used[i] = true;
            list.add(i);

            backTracking(n,m,list,used);

            list.remove(list.size()-1);
            used[i] = false;
        }
    }

    private static void solution(int n, int m){
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[n+1];

        backTracking(n,m,list,used);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        solution(n,m);

    }
}
