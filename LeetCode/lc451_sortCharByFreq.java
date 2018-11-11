// leetcode 451. Sort character by frequency

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>() {
            public int compare(Character a, Character b) {
                int diff = map.get(b) - map.get(a);
                if (diff == 0) 
                    return ((int) b.charValue() - (int) a.charValue());
                return diff;
            }
        });
        for (char ch : s.toCharArray()) {
            pq.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty())
            sb.append(pq.poll());
        return sb.toString();
    }
}