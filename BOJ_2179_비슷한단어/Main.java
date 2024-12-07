package BOJ_2179_비슷한단어;
import java.util.*;

class StringClass {
    int originalIndex;
    String word;
}

public class Main {

    public static void sortList(List<StringClass> words) {
        words.sort(Comparator.comparing(s -> s.word));
    }

    public static int calcuLength(StringClass word1, StringClass word2) {
        int length = 0;
        int compareLength = Math.min(word1.word.length(), word2.word.length());

        for (int i = 0; i < compareLength; i++) {
            if (word1.word.charAt(i) == word2.word.charAt(i)) {
                length++;
            } else {
                break;
            }
        }

        return length;
    }

    public static void printWords(StringClass word1, StringClass word2) {
        if (word1.originalIndex > word2.originalIndex) {
            System.out.println(word2.word);
            System.out.println(word1.word);
        } else {
            System.out.println(word1.word);
            System.out.println(word2.word);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N < 2) {
            System.out.println("Not enough words to compare.");
            return;
        }

        List<StringClass> wordsList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringClass s = new StringClass();
            s.originalIndex = i;
            s.word = sc.next();

            wordsList.add(s);
        }

        // 사전순 정렬
        sortList(wordsList);

        int maxLength = -1;
        StringClass firstWord = null;
        StringClass secondWord = null;

        for (int i = 0; i < wordsList.size() - 1; i++) {
            StringClass s1 = wordsList.get(i);
            StringClass s2 = wordsList.get(i + 1);

            int currentLength = calcuLength(s1, s2);

            if (currentLength > maxLength ||
                    (currentLength == maxLength && (s1.originalIndex < firstWord.originalIndex ||
                            (s1.originalIndex == firstWord.originalIndex && s2.originalIndex < secondWord.originalIndex)))) {
                maxLength = currentLength;
                firstWord = s1;
                secondWord = s2;
            }
        }

        // 출력
        if (firstWord != null && secondWord != null) {
            printWords(firstWord, secondWord);
        }
    }
}
