package BOJ_1450_냅색문제;
import java.util.*;

public class Main {
    private static int solution(int[] bags, int max){
        int b = bags.length;
        int[] d = new int[max+1];
        d[0] = 0;
        for(int i = 1; i<= max; i++){
            for(int bag : bags){
                if(i >= bag) d[i] = Math.max(d[i-1], d[i] +1);
            }
        }
        return d[max];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = sc.nextInt();

        int[] bags = new int[n];
        for(int i = 0 ; i < n; i++) bags[i] = sc.nextInt();
        System.out.println(solution(bags, max));
    }
}
