package BOJ_1946_신입사원;
import java.util.*;

class Stu {
    int idx;
    int sc1;
    int sc2;

    public Stu(int idx, int sc1, int sc2){
        this.idx = idx;
        this.sc1 = sc1;
        this.sc2 = sc2;
    }
}
public class Main {

    private static int solution(int[][] scores, int n){
        int ans = 0;

        List<Stu> stus = new ArrayList<Stu>();

        int idx = 1;

        for(int[] score : scores){
            Stu stu = new Stu(idx, score[0], score[1]);
            stus.add(stu);

            idx++;
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int n = sc.nextInt();
        int[][] scores = new int[n][2];

        for(int tc = 0; tc <= T; tc++){
            System.out.println(solution(scores, n));
        }
    }

}
