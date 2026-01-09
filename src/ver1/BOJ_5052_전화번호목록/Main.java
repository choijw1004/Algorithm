package BOJ_5052_전화번호목록;

import java.util.*;

public class Main {

    /*
        num2.legnth() > num1.length()
     */

    public static boolean isConsistency(String num1, String num2){

        if(num2.startsWith(num1)){
            return true;
        }
        else{
            return false;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- >0) {
            int numCount = sc.nextInt();
            List<String> nums = new ArrayList<>();

            for(int i = 0 ; i < numCount; i++){
                String num = sc.next();
                nums.add(num);
            }

            Collections.sort(nums);

            boolean consistence = false;

            for(int i = 0 ; i < numCount -1; i++){
                String num1 = nums.get(i);
                String num2 = nums.get(i+1);

                if(isConsistency(num1, num2)){
                    consistence = true;
                    break;
                }
            }

            if(consistence == true){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
        }
    }
}
