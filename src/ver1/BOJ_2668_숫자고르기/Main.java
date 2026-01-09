package BOJ_2668_숫자고르기;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer>[] g = new ArrayList[n+1];

        for(int i = 1; i<= n; i++){
            g[i] = new ArrayList<>();
        }

        for(int i = 1; i<=n; i++){
            int u = i;
            int v = sc.nextInt();
            g[u].add(v);
            g[v].add(u);
        }

        


    }
}
