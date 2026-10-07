class Solution {
    public int longestMountain(int[] arr) {
        int i = 0;
        int n = arr.length;
        int maxLength = 0;

        while (i < n) {

            if (i == 0 || arr[i] <= arr[i - 1]) {
                i++;
                continue;
            }

            int start = i - 1;

            // Go upward
            while (i < n && arr[i] > arr[i - 1]) {
                i++;
            }

            int peak = i - 1;

            if (peak == start || i == n) {
                continue;
            }

            // Go downward
            while (i < n && arr[i] < arr[i - 1]) {
                i++;
            }

           if(i > peak + 1){
             int length = i - start;
             maxLength = Math.max(length, maxLength);
             }
        }

        return maxLength;
    }
}