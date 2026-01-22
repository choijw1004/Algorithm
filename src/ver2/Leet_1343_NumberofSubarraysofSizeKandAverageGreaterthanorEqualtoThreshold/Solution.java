package ver2.Leet_1343_NumberofSubarraysofSizeKandAverageGreaterthanorEqualtoThreshold;

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i = 0;
        int j = 0;
        int n = arr.length;
        int ans = 0;
        int sum = 0;

        while(j < n){
            if(j - i + 1 < k){
                sum += arr[j];
                j++;
            }
            else{
                sum += arr[j];

                if(sum / k >= threshold) ans++;

                sum -= arr[i];

                i++;
                j++;
            }
        }
        return ans;
    }
}