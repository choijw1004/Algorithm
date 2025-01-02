package SWEA_1494_사랑의카운슬러;
import java.util.*;

class worm{
    int x;
    int y;

    worm(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    static int T;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++) {

            N = sc.nextInt();

            worm[] worms = new worm[N];

            for (int i = 0; i < N; i++) {
                worms[i] = new worm(sc.nextInt(), sc.nextInt());
            }

            int minLen = -1;

            for (int i = 0; i < N - 1; i++) {
                for(int j = i+1 ; j < N; j++){
                }
            }


        }
    }
}
