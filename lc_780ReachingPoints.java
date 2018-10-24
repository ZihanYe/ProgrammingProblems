// leetcode 780. Reaching Points

class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // System.out.println(sx + " " + sy);
        // System.out.println(tx + " " + ty);
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) return true;
            if (tx == ty) {
                return ((sx == 0 && sy ==ty) || (sy==0 && sx == tx));
            } else if ((tx > ty && tx-sx < ty) ||(tx < ty && ty-sy < tx)) {
                return false;
            } else if (tx > ty) {
                tx = sx + (tx -sx)%ty;
            } else if (tx < ty) {
                ty = sy + (ty - sy)%tx;
            }
            // System.out.print(tx);
            // System.out.println(ty);
        }
        return false;
    }
}