package ver2;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String st = sc.next();

            if(st.length() < m ) continue;

            map.put(st,map.getOrDefault(st,0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (a,b) -> {
            if(a.getValue() != b.getValue()){
                return b.getValue() - a.getValue();
            }
            else if(a.getKey().length()!= b.getKey().length()){
                return b.getKey().length() - a.getKey().length();
            }
            return a.getKey().compareTo(b.getKey());
        });

        for(int i = 0 ; i < list.size(); i++){
            System.out.println(list.get(i).getKey());
        }
    }
}
