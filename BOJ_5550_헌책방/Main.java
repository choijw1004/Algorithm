package BOJ_5550_헌책방;

import java.util.*;

public class Main {

    public static void printList(int[][] list){
        for(int i = 0; i < list.length; i++){
            for(int j = 0; j < list[i].length; j++){
                System.out.println(list[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bookCount = sc.nextInt();
        int sellCount = sc.nextInt();

        int[][] priceAndGenre = new int[10][bookCount];


        for(int i = 0 ; i < bookCount; i++){
            int price = sc.nextInt();
            int genre = sc.nextInt() + 1;

            

        }


    }
}
