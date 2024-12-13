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

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[][] books = new int[N][K];

         for(int i = 0; i < N; i++){
             for(int j = 0; j < K; j++){
                 books[i][j] = sc.nextInt();
             }
         }

         printList(books);


    }
}
