public class Flood_Fill_733 {
    public static void main(String[] args) {
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        helper(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    public static void helper(int[][] image, int sr, int sc, int color, int orgColor) {
        if(image[sr][sc] == color) return; //The Key Edge Case
        if (image[sr][sc] == orgColor) {
            image[sr][sc] = color;
            if (sr - 1 >= 0)
                helper(image, sr - 1, sc, color, orgColor);
            if (sc - 1 >= 0)
                helper(image, sr, sc - 1, color, orgColor);
            if (sr + 1 < image.length)
                helper(image, sr + 1, sc, color, orgColor);
            if (sc + 1 < image[0].length)
                helper(image, sr, sc + 1, color, orgColor);
        }
    }
}

/*
Learning:
A) How it Utilizes DFS ?
1. Depth-First Search is a traversal strategy that goes as deep as possible in one direction until it hits a boundary.
2. Instead of checking all immediate neighboring pixels at once, it follows a single path to its absolute end.
3. In your code, this happens because the first recursive call for the UP direction must finish completely before the DOWN direction can start.
4. The algorithm keeps moving UP, painting pixels, until it reaches the edge of the image or a tile with the wrong color.
5. When it hits that wall, the function stops and returns, which is a process known as backtracking.
6. After backtracking one step, the program then tries the next available direction from its previous location.
7. It repeats this process, acting like a person solving a maze by keeping their hand on the wall and following every path to a dead end.
8. You do not need to write a manual stack data structure because the recursive function uses the computer memory call stack automatically in the background.
9. Every time a new pixel is explored, its coordinates are pushed to this stack, and when a path is finished, they are popped off.

Summary:
Time Complexity = O(N) (Where N is the total number of pixels in the 2D array. In the worst-case scenario, you might have to fill every single pixel in the image exactly once.)
Space Complexity: O(N) (In the worst-case scenario (e.g., a massive snake-like single-pixel line covering the whole grid), the recursive call stack will grow to the size of all pixels before unwinding.)
*/