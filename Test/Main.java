package Test;
import java.util.*;
class Plan{
    String name;
    int hour;
    int minute;
    int playtime;

    Plan(String name, int hour, int minute, int playtime){
        this.name = name;
        this.hour = hour;
        this.minute = minute;
        this.playtime = playtime;
    }

}
public class Main {
    public static void main(String[] args) {
        String[] ss = new String[3];
        HashSet<String> hs = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        String s = "123";
        HashMap<String, Integer> asdf = new HashMap<>();
        char c = '1';
        ss[2] = "1. 11 ";

        System.out.println(Arrays.toString(ss));
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("1",1);
        hm.put("1",1);
        hm.put("1",1);
        hm.put("1",1);
        System.out.println(hm);
        System.out.println(hm.size());

        TreeMap<String,Integer> tm = new TreeMap<>();
        tm.put("b",3);
        tm.put("a",3);
        hs.add("3");
        hs.add("4");

        List<Plan> list = new ArrayList<>();

        Collections.sort(list, (a,b) -> {
            if(a.hour == b.hour) return a.minute - b.minute;
            else return a.hour - b.hour;

        });

        System.out.println(hm.entrySet().size());

    }
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        Arrays.stream(diffs).max().getAsInt();
        return answer;
    }
}