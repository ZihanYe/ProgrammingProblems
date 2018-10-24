// Leetcode 916. Word Subsets

class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> superwords = new ArrayList<>();
        if (A.length == 0) return superwords;
        if (B.length == 0) {
            superwords.addAll(Arrays.asList(A));
            return superwords;
        }
        Map<Character, Integer> need = new HashMap<>();
        for (String s : B) {
            Map<Character, Integer> charnum = new HashMap<>();
            for (int i=0; i<s.length(); i++){ 
                char ch = s.charAt(i);
                charnum.put(ch, charnum.getOrDefault(ch, 0)+1);
            }
            for (Map.Entry<Character, Integer> entry : charnum.entrySet()){
                if (entry.getValue() > need.getOrDefault(entry.getKey(), 0)) {
                    need.put(entry.getKey(), entry.getValue());
                }
            }
        }
        for (String a : A){
            Map<Character, Integer> charnum = new HashMap<>();
            for (int i=0; i<a.length(); i++){
                char ch = a.charAt(i);
                charnum.put(ch, charnum.getOrDefault(ch, 0)+1);
            }
            boolean isSuper = true;
            for (Map.Entry<Character, Integer> entry : need.entrySet()){
                isSuper = isSuper && (entry.getValue() <= charnum.getOrDefault(entry.getKey(), 0));
            }
            if (isSuper) superwords.add(a);
        }
        return superwords;
    }
}