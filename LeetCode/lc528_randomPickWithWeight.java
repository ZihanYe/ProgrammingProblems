// LeetCode 528.Random pick with Weight

class Solution {
    TreeMap<Integer,Integer> numberToindex;
    int sum;
    Random r;
    public Solution(int[] w) {
        numberToindex = new TreeMap<>();
        sum = 0;
        for (int i=0; i< w.length; i++) {
            sum += w[i];
            numberToindex.put(sum-1, i);
        }
        r = new Random();
    }
    
    public int pickIndex() {
        int pos = r.nextInt(sum);
        int index = numberToindex.ceilingKey(pos);
        return numberToindex.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */