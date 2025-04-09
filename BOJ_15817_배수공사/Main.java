package BOJ_15817_배수공사;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int money = sc.nextInt();

        int[][] stocks = new int[n][2];

        for(int i = 0 ; i < n; i++){
            stocks[i][0] = sc.nextInt();
            stocks[i][1] = sc.nextInt();
        }

        int[][] d = new int[n+1][money+1];


        for(int i = 1; i <= stocks.length; i++){
        }


    }
}
