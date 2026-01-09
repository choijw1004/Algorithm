package Leet_433_MinimumGeneticMutation;

import java.util.*;

class Solution {

    public class Item {
        String gene;
        int dist;

        Item(String gene, int dist) {
            this.gene = gene;
            this.dist = dist;
        }
    }

    public boolean check(String a, String b) {
        int cnt = 0;

        for (int i = 0; i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
            if (cnt > 1){
                return false;
            }
        }
        return true;
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)){
            return 0;
        }

        Map<String, Integer> hashMap = new HashMap<>();
        Queue<Item> queue = new LinkedList<>();
        queue.add(new Item(startGene, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Item first = queue.poll();
                String gene = first.gene;
                int dist = first.dist;

                if (gene.equals(endGene)){
                    return dist;
                }

                for (String s : bank) {
                    if (!hashMap.containsKey(s) && check(gene, s)) {
                        queue.add(new Item(s, dist + 1));
                        hashMap.put(s, 1);
                    }
                }
            }
        }
        return -1;
    }
}
