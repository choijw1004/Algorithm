package BOJ_2606_바이러스;
import java.util.*;

public class Main {
    static int[] parent;

    public static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        if(rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    public static int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 컴퓨터 수
        int M = sc.nextInt();  // 연결 수

        // 1-indexed로 사용하기 위해 크기를 N+1로
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }

        int cnt = 0;
        int virusRoot = find(1);
        for (int i = 2; i <= N; i++){
            if(find(i) == virusRoot) cnt++;

        }

        System.out.println(cnt);

    }
}
