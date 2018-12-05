// LeetCode 78. subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        long n = (long) Math.pow(2, nums.length);
        for (long i=0; i<n; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j=0; j<nums.length; j++){
                if (((i >> j)&1)>0)
                    l.add(nums[j]);
            }
            res.add(l);
        }
        return res;
    }
}