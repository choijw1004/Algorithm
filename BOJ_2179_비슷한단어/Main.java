package BOJ_2179_비슷한단어;

import java.util.*;

class StringClass {
    int originalIndex;
    String word;
}

public class Main {

    public static int calcuLength(String word1, String word2) {
        int length = 0;
        int compareLength = Math.min(word1.length(), word2.length());

        for (int i = 0; i < compareLength; i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                length++;
            } else {
                break;
            }
        }

        return length;
    }

    public static void printWords(StringClass word1, StringClass word2) {
        String printWord1 = word1.word;
        String printWord2 = word2.word;

        if (word1.originalIndex > word2.originalIndex) {
            System.out.println(printWord2);
            System.out.println(printWord1);
        } else {
            System.out.println(printWord1);
            System.out.println(printWord2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<StringClass> wordsList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringClass s = new StringClass();
            s.originalIndex = i;
            s.word = sc.next();

            wordsList.add(s);
        }

        int maxLength = -1;
        StringClass solWord1 = null;
        StringClass solWord2 = null;

        for (int i = 0; i < wordsList.size() - 1; i++) {
            for (int j = i + 1; j < wordsList.size(); j++) {
                String word1 = wordsList.get(i).word;
                String word2 = wordsList.get(j).word;

                if (word1.equals(word2)) {
                    continue;
                }

                int currentLength = calcuLength(word1, word2);

                if (currentLength > maxLength) {
                    maxLength = currentLength;

                    solWord1 = new StringClass();
                    solWord1.word = word1;
                    solWord1.originalIndex = wordsList.get(i).originalIndex;

                    solWord2 = new StringClass();
                    solWord2.word = word2;
                    solWord2.originalIndex = wordsList.get(j).originalIndex;
                }
            }
        }
        printWords(solWord1, solWord2);
    }
}
