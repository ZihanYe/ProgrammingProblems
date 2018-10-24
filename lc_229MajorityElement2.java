// Leetcode 229. Majority Element2
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length < 1) 
            return new LinkedList<Integer>();
        int A = nums[0];
        int B = nums[0];
        int countA = 0; int countB = 0;
        for (int j=0; j<nums.length; j++) {
            if (nums[j] == A) {
                countA ++;
                continue;
            }
            if (nums[j] == B) {
                countB ++;
                continue;
            }
            if (countA == 0) {
                A = nums[j];
                countA ++;
                continue;
            }
            if (countB == 0) {
                B = nums[j];
                countB ++;
                continue;
            }
            countA --;
            countB --;
        }
        countA = 0;
        countB = 0;
        for (int x: nums) {
            if (x == A) countA++;
            else if (x==B) countB++;
        }
        List<Integer> res = new LinkedList<>();
        int n = nums.length;
        if (countA > Math.floor(n/3)) res.add(A);
        if (countB > Math.floor(n/3)) res.add(B);
        return res;
    }
}