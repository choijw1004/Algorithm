package BOJ_17604_회문;
import java.util.*;

public class Main {
    private static boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPseudoPalindrome(String s){
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else return isPalindrome(s, left+1, right) || isPalindrome(s,left,right-1);
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i < n; i++){
            String s = sc.next();
            if(isPalindrome(s,0,s.length()-1)) System.out.println(0);
            else if(isPseudoPalindrome(s)) System.out.println(1);
            else System.out.println(2);
        }
    }
}
