package BOJ_1092_배;
import java.util.*;

public class Main {
    public static int solution(ArrayList<Integer> crains,List<Integer> boxes){
        int time = 0;
        int cl = crains.size();
        int bl = boxes.size();

        Collections.sort(crains, Collections.reverseOrder());
        Collections.sort(boxes,Collections.reverseOrder());

        int cidx = 0;
        int bidx = 0;

        while(bidx < bl){
            
        }


        return time;


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> crains = new ArrayList<>();
        for(int i = 0; i < n; i++){
            crains.add(sc.nextInt());
        }

        int m = sc.nextInt();
        List<Integer> boxes = new ArrayList<>();

        for(int i = 0 ; i < m; i++){
            boxes.add(sc.nextInt());
        }
    }
}
