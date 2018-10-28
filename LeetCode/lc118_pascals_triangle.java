// Leetcode 118.Pascal's Triangle

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows ==0) {
            return res;
        }
        List<Integer> current = new LinkedList<>();
        current.add(1);
        List<Integer> newone = new LinkedList<>();
        newone.addAll(current);
        res.add(newone);
        for (int i=2; i<=numRows; i++) {
            for (int j=0; j<current.size()-1; j++){
                current.set(j, current.get(j) + current.get(j+1));
            }
            current.add(0,1);
            List<Integer> a = new LinkedList<>();
            a.addAll(current);
            res.add(a);
        }
        return res;
    }
}