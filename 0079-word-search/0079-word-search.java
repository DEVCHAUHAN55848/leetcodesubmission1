class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Loop through every cell in the grid to find the starting letter
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        // Base case: If all characters are matched successfully
        if (index == word.length()) {
            return true;
        }
        
        // Boundary checks and character mismatch check
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }
        
        // Mask the current cell to mark it as visited
        char temp = board[r][c];
        board[r][c] = '#'; 
        
        // Explore all 4 adjacent directions (Up, Down, Left, Right)
        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);
        
        // Backtrack: Restore the original character for other paths
        board[r][c] = temp;
        
        return found;
    }
}

