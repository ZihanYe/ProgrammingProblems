// LeetCode 300. LIS

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] minTail = new int[nums.length+1];
        Arrays.fill(minTail, Integer.MAX_VALUE);
        minTail[0] = Integer.MIN_VALUE;
        int maxLen = 0;
        for (int i =0; i< nums.length; i++) {
            int len = bs(minTail, 0, maxLen, nums[i]);
            minTail[len+1] = Math.min(minTail[len+1], nums[i]);
            maxLen = Math.max(len+1, maxLen);
        }
        return maxLen;
    }
    
    int bs(int[] arr, int from, int to, int target) {
        // return biggest element strictly smaller than target
        int left = -1;
        while (from <= to) {
            int mid = (from + to) /2;
            if (arr[mid] < target){
                left = mid;
                from = mid+1;
            } else // nums[mid] >= target
                to = mid -1;
        }
        return left;
    }
}