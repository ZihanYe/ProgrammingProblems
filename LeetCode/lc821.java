// LeetCode 821. Shortest Distance to a Character

class Solution {
    public int[] shortestToChar(String S, char C) {
        char[] chars = S.toCharArray();
        int[] res = new int[chars.length];
        
        Queue<Integer> pos = new LinkedList<>();
        for (int i=0; i<chars.length; i++) {
            if (chars[i] == C) pos.add(i);
        }
        
        int index = pos.poll();
        for (int i=0; i<chars.length; i++) {
            int dist = Math.abs(index - i);
            if (!pos.isEmpty() && Math.abs(pos.peek()-i) < dist) {
                index = pos.poll();
                dist = Math.abs(index -i);
            }
            res[i] = dist;
        }
        return res;
    }
}