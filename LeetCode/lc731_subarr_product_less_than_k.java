// Leetcode 713. Subarray Product less than K

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int sum = 1;
        int i = 0;
        int j = 0;
        while (j < nums.length){
            if (sum * nums[j] < k){
                count = count + j - i + 1;
                sum = sum * nums[j];
                j = j +1;
            } else if (i < j) {
                sum = sum / nums[i];
                i = i +1;
            } else { // i == j
                sum = 1;
                j = j +1;
                i = i +1;
            }
        }
        return count;
    }
}