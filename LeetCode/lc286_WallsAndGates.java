// LeetCode 286. Walls and Gates

class Solution {
    int[][] dir = new int[][]{{-1,0}, {0,-1}, {0,1}, {1,0}};
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i<rooms.length; i++) {
            for (int j =0; j<rooms[0].length; j++) {
                if (rooms[i][j] == 0)
                    helper(i,j,rooms,0);
            }
        }
    }
    
    void helper(int i, int j, int[][] rooms, int dist) {
        // System.out.println(i + " , " + j + " , " + dist);
        if (rooms[i][j] < dist) return;
        rooms[i][j] = dist;
        for (int k=0; k< dir.length; k++){
            if (i+ dir[k][0]>= 0 && i+ dir[k][0] <rooms.length 
                && j+dir[k][1] >= 0 && j+dir[k][1] < rooms[0].length
               && rooms[i+dir[k][0]][j+dir[k][1]] != -1) {
                helper(i+dir[k][0], j+dir[k][1], rooms, dist +1);
            }
        }
    }
}