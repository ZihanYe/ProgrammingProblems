// LeetCode 582. Kill Process

class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Iterator<Integer> idIter = pid.iterator();
        Iterator<Integer> pIter = ppid.iterator();
        while (idIter.hasNext() && pIter.hasNext()) {
            int id = idIter.next();
            int p = pIter.next();
            if (!map.containsKey(id)) map.put(id, new ArrayList<>());
            if (!map.containsKey(p)) map.put(p, new ArrayList<>());
            map.get(p).add(id);
        }
        Set<Integer> set = new HashSet<>();
        addKill(set, kill, map);
        List<Integer> res = new ArrayList<>();
        res.addAll(set);
        return res;
    }
    
    private void addKill(Set<Integer> tokill, int kill, Map<Integer, List<Integer>> map){
        if (!tokill.contains(kill)) {
            tokill.add(kill);
            for (Integer c : map.getOrDefault(kill, new ArrayList<Integer>())) {
                addKill(tokill, c, map);
            }
        }
    }
}