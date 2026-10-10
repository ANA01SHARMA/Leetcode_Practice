public class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        
        // The maximum possible difference is 10^5 based on constraints
        int maxDiff = 100000;
        long[] diffCount = new long[maxDiff + 1];
        
        // Step 1: Populate the frequency array of absolute differences
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            diffCount[diff]++;
        }
        
        // Step 2: Greedily reduce the largest differences downwards
        for (int i = maxDiff; i > 0; i--) {
            if (diffCount[i] == 0) {
                continue;
            }
            
            // If total operations 'k' can reduce all current differences of size 'i'
            if (k >= diffCount[i]) {
                k -= diffCount[i];
                diffCount[i - 1] += diffCount[i];
                diffCount[i] = 0;
            } else {
                // 'k' can only reduce some of the current differences of size 'i'
                diffCount[i - 1] += k;
                diffCount[i] -= k;
                k = 0;
                break; // No operations left
            }
        }
        
        // Step 3: Calculate the final sum of squared differences
        long minSumSquare = 0;
        for (int i = 1; i <= maxDiff; i++) {
            if (diffCount[i] > 0) {
                minSumSquare += diffCount[i] * ((long) i * i);
            }
        }
        
        return minSumSquare;
    }
}
