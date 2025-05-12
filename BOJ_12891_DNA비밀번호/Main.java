package BOJ_12891_DNA비밀번호;
import java.util.*;

public class Main {
    private static int convertInt(Character c){
        if(c == 'A') return 0;
        else if(c == 'C') return 1;
        else if(c == 'G') return 2;
        return 3;
    }
    private static boolean canMake(int[] arr, int[] need){
        boolean flag = true;
        for(int i = 0 ; i < 4;i++){
            if(arr[i] < need[i]) return false;
        }
        return flag;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[4];
        int[] need = new int[4];
        int cnt = 0;
        int left = 0;
        String s = sc.next();

        for(int i = 0; i < 4; i++) need[i] = sc.nextInt();

        for(int i = 0 ; i < k; i++){
            arr[convertInt(s.charAt(i))]++;
        }

        if(canMake(arr, need)) cnt++;

        for(int i = k; i < n; i++){
            arr[convertInt(s.charAt(i))]++;
            arr[convertInt(s.charAt(left))]--;

            if(canMake(arr, need)) cnt++;

            left++;
        }
        System.out.println(cnt);
    }
}
