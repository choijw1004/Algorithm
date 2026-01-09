package BOJ_3584_가장가까운공통조상;
import java.util.*;

public class Main {
    int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0){
            int n = sc.nextInt();
            int[] parent = new int[n+1];

            for(int i = 0 ; i < n-1; i++){
                int p = sc.nextInt();
                int c = sc.nextInt();

                parent[c] = p;
            }
            boolean[] visited = new boolean[n+1];

            int a = sc.nextInt();
            int b = sc.nextInt();
            int x = a;
            int y = b;

            while(!visited[x]){
                visited[x] = true;
                x = parent[x];
            }

            while(!visited[y]){
                y = parent[y];
            }

            System.out.println(y);
        }
    }
}
