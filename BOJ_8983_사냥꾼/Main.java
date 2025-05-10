package BOJ_8983_사냥꾼;

import java.util.*;

class Animal{
    int left, right;
    public Animal(int left, int right){
        this.left = left;
        this.right = right;
    }
}

public class Main {
    private static int solution(int[] shoots, List<Animal> animals, int l){
        int ans = 0;
        int n = shoots.length;
        int idx = 0;

        Arrays.sort(shoots);
        Collections.sort(animals, (a,b) -> Integer.compare(a.left, b.left));

        for(Animal a : animals){
            while(idx < n && shoots[idx] < a.left) idx++;

            if(idx == n) break;

            if(shoots[idx] <= a.right) ans++;
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        int[] shoots = new int[n];
        List<Animal> animals = new ArrayList<>();
        for(int i = 0 ; i < n; i++) shoots[i] = sc.nextInt();

        for(int i = 0 ; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if(y > l) continue;

            animals.add(new Animal(x - (l-y), x + (l-y)));
        }

        System.out.println(solution(shoots, animals,l));
    }
}
