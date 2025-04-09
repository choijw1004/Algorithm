package BOJ_22115_창영이와커피;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coffees = new int[n];
        for (int i = 0; i < n; i++) {
            coffees[i] = sc.nextInt();
        }

        int INF = k + 1;
        int[] d = new int[k+1];
        Arrays.fill(d, INF);
        d[0] = 0;

        for (int coffee : coffees) {
            for (int i = k; i >= coffee; i--) {
                d[i] = Math.min(d[i], d[i - coffee] + 1);
            }
        }

        System.out.println(d[k] == INF ? -1 : d[k]);
    }
}
