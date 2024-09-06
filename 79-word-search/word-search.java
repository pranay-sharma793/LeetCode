/**
similar appoach to word island, here once we see the first char of the word we call the order function (apply DFS) to search.
Other function checks in all four directions to complete the word, else returns false.
Here the catch was to avoid the same char getting used twice. We can not change the char value completely since if it returns false, the same char can be present in the word via some other traversal. Hence we temporarily store the value and before returning we replace it back.

Time Complexity:
In the worst case, the time complexity is O(N * M * 4^L) where N and M are the dimensions of the board, and L is the length of the word. This is due to exploring all possible paths in the board.

Space Complexity:
The space complexity is O(L) due to the recursion stack during the depth-first search.
 */

class Solution {
    public boolean exist(char[][] board, String word) {

        for(int i =0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(performSearch(board, i ,j, word, 0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean performSearch(char[][] board, int row, int col, String word, int idx){
        
        if(idx == word.length()) {
            return true;
        }

        if(row < 0 || col < 0 || row >= board.length || col >= board[row].length){
            return false;
        }

        if(board[row][col] != word.charAt(idx)) return false;

        boolean found = false;

        char tmp = board[row][col];
        board[row][col] = '*';

        found = performSearch(board, row+1, col, word, idx+1) ||
                performSearch(board, row, col+1, word, idx+1) ||
                performSearch(board, row-1, col, word, idx+1) ||
                performSearch(board, row, col-1, word, idx+1);

        board[row][col] = tmp;


        return found;
    }
}  