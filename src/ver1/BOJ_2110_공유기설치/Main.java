package BOJ_2110_공유기설치;
import java.util.*;

public class Main {
    static int[] housePoint;
    static public boolean canInstall(int length, int c){
        int cnt = 1;
        int lastPoint = housePoint[0];

        for(int i = 1; i < housePoint.length; i++){
            if(housePoint[i] - lastPoint >= length){
                lastPoint = housePoint[i];
                cnt++;
            }
        }
        return cnt >= c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N 집의 개수, C, 공유기의 개수
        // return 가장 긴 공유기의 거리


        int N = sc.nextInt();
        int C = sc.nextInt();

        housePoint = new int[N];

        for(int i = 0 ; i <N; i++){
            housePoint[i] = sc.nextInt();
        }

        Arrays.sort(housePoint);

        int left = 1;
        int right = housePoint[housePoint.length -1] - housePoint[0];

        int len = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            if(canInstall(mid, C)){
                len = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }

        }

        System.out.println(len);
    }
}
