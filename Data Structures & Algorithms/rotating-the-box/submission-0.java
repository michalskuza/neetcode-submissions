class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        
        // Step 1: Apply gravity to the right in each row
        for (int i = 0; i < m; i++) {
            int empty = n - 1; // rightmost available position
            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '*') {
                    empty = j - 1;       // obstacle resets the drop point
                } else if (boxGrid[i][j] == '#') {
                    boxGrid[i][j] = '.';  // pick up stone
                    boxGrid[i][empty] = '#'; // drop it at lowest available spot
                    empty--;
                }
            }
        }
        
        // Step 2: Rotate 90° clockwise → new[j][m-1-i] = old[i][j]
        char[][] result = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][m - 1 - i] = boxGrid[i][j];
            }
        }
        
        return result;
    }
}