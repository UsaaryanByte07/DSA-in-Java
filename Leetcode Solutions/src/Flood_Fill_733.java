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
Summary:
Time Complexity = O(N) (Where N is the total number of pixels in the 2D array. In the worst-case scenario, you might have to fill every single pixel in the image exactly once.)
Space Complexity: O(N) (In the worst-case scenario (e.g., a massive snake-like single-pixel line covering the whole grid), the recursive call stack will grow to the size of all pixels before unwinding.)
*/