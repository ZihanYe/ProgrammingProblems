// LeetCode 325. Max Size subarray sum equals k

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int maxlen = 0;
        for (int i =0; i< nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k))
                maxlen = Math.max(i-map.get(sum-k), maxlen);
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return maxlen;
    }
}