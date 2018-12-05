// LeetCode 560. Subarray sum Equals to k

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0,1);
        int sum = 0;
        int i = 1;
        int count = 0;
        while (i<= nums.length) {
            sum += nums[i-1];
            int freq = sums.getOrDefault(sum-k,0);
            count += freq;
            sums.put(sum, sums.getOrDefault(sum,0)+1);
            i++;
        }
        return count;
    }
}