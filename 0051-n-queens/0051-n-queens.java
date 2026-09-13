class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag = new HashSet<>();
        Set<Integer> antiDiag = new HashSet<>();
        
        backtrack(0, board, result, cols, diag, antiDiag, n);
        return result;
    }
    
    private void backtrack(int row, char[][] board, List<List<String>> result,
                           Set<Integer> cols, Set<Integer> diag, Set<Integer> antiDiag, int n) {
        
        if (row == n) {
            result.add(construct(board));
            return;
        }
        
        for (int col = 0; col < n; col++) {
            
            if (cols.contains(col) || diag.contains(row - col) || antiDiag.contains(row + col)) {
                continue;
            }
            
            // Place queen
            board[row][col] = 'Q';
            cols.add(col);
            diag.add(row - col);
            antiDiag.add(row + col);
            
            backtrack(row + 1, board, result, cols, diag, antiDiag, n);
            
            // Remove queen (backtrack)
            board[row][col] = '.';
            cols.remove(col);
            diag.remove(row - col);
            antiDiag.remove(row + col);
        }
    }
    
    private List<String> construct(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}