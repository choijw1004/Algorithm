package ver2.Leet_1456_MaximumNumberofVowelsinaSubstringofGivenLength;

class Solution {
    private boolean isVowel(Character c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private int makeHash(Character c){
        if(c == 'a') return 0;
        else if(c == 'e') return 1;
        else if(c == 'i') return 2;
        else if(c == 'o') return 3;
        else return 4;

    }

    public int maxVowels(String s, int k) {
        int i = 0, j = 0, ans = 0;
        int size = k;
        int n = s.length();
        int[] hash = new int[5];

        while(j < n){
            if(j - i + 1 < size){
                if(isVowel(s.charAt(j))){
                    hash[makeHash(s.charAt(j))]++;
                }
                j++;
            }
            else{
                if(isVowel(s.charAt(j))){
                    hash[makeHash(s.charAt(j))]++;
                }
                int tmp = 0;

                for(int num : hash){
                    tmp += num;
                }
                ans = Math.max(tmp, ans);

                if(isVowel(s.charAt(i))){
                    hash[makeHash(s.charAt(i))]--;
                }

                i++;
                j++;
            }

        }
        return ans;
    }
}


/*
# 카테고리
슬라이딩 윈도우
# 접근 방식
고정된 슬라이딩 윈도우 방식의 문제이다. 고정된 윈도우에서 모음의 빈도수가 가장 큰 빈도수를 찾아내는 문제인데

여기서 모음을 찾아내는 isVowel(), 모음을 hash값으로 변경해주는 makeHash()를 구현하여 hash 배열에서 모음의 빈도를 O(1)로 찾아내게끔 구현하였다.

# 문제 링크
https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */