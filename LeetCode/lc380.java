// LeetCode 380. Insert Delete GetRandom O(1)
class RandomizedSet {
    Random r = new Random();
    Map<Integer, Integer> valtoid;
    Map<Integer, Integer> idtoval;
    int size;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        valtoid = new HashMap<>();
        idtoval = new HashMap<>();
        size = 0;
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valtoid.containsKey(val)) return false;
        valtoid.put(val,size);
        idtoval.put(size, val);
        size ++;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valtoid.containsKey(val)) return false;
        int id = valtoid.get(val);
        if (id < size-1) {
            int item = idtoval.get(size-1);
            idtoval.put(id, item);
            valtoid.put(item, id);
        }
        idtoval.remove(size-1);
        valtoid.remove(val);
        size --;
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int id = r.nextInt(size);
        return idtoval.get(id);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */