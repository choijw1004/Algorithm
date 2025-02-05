package BOJ_2457_공주님의정원;
import java.util.*;

public class Main {
    static class Flower{
        int start,end;
         Flower(int a, int b, int c, int d){
             start = a * 100 + b;
             end =  c * 100 + d;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Flower> flowers = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int a,b,c,d;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            d = sc.nextInt();
            Flower flower = new Flower(a,b,c,d);
            flowers.add(flower);
        }

        Collections.sort(flowers, (f1, f2) -> {
            if(f1.start != f2.start){
                return f1.start - f2.start;
            }
            return f2.end - f1.end;
        });

        int count = 0;
        int current = 301;
        int index = 0;
        int maxEnd = 0;
        while (current <= 1130) {
            boolean found = false;

            while (index < flowers.size() && flowers.get(index).start <= current) {
                maxEnd = Math.max(maxEnd, flowers.get(index).end);
                found = true;
                index++;
            }
            if (!found) break;
            count++;
            current = maxEnd;
        }
        System.out.println(current > 1130 ? count : 0);
    }
}
