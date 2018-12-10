// LeetCode 251. Flatten 2d vector

public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> itr;
    Iterator<Integer> lstItr;
    public Vector2D(List<List<Integer>> vec2d) {
        itr = vec2d.iterator();
        if (itr.hasNext()) lstItr = itr.next().iterator();
    }

    @Override
    public Integer next() {
        if (hasNext())
            return lstItr.next();
        return null;
    }

    @Override
    public boolean hasNext() {
        while (lstItr == null || !lstItr.hasNext()) {
            if (!itr.hasNext()) return false;
            lstItr = itr.next().iterator();
        }
        return true;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */