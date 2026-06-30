public class Number_Of_Islands_200 {
    public static void main(String[] args) {
        
    }
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1') {
                    islandCount++;
                    floodFill(grid, i, j);
                };
            }
        }
        return islandCount;
    }

    public static void floodFill(char[][] grid, int sr, int sc) {
        if (grid[sr][sc] == 'v')
            return;
        if (grid[sr][sc] == '1') {
            grid[sr][sc] = 'v';
            if (sr - 1 >= 0)
                floodFill(grid, sr - 1, sc);
            if (sc - 1 >= 0)
                floodFill(grid, sr, sc - 1);
            if (sr + 1 < grid.length)
                floodFill(grid, sr + 1, sc);
            if (sc + 1 < grid[0].length)
                floodFill(grid, sr, sc + 1);
        }
    }
}

/*
# The Flood Fill Method:

Learning:
1) First visit the #200 Leetcode Problem to get the Logic of FloodFill
2) traverse all the cells of grid Matrix One By One
3) As soon as you encounter a New '1' cell just use FloodFill on it and increment the island Counter as you have found a new island.

Summary:
Time Complexity = O(m*n)
Space Complexity = O(m*n)
*/