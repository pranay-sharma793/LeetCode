/*
Taking three hashsets for row, columns and sqaures to validate each
Adding each value to the hashset into their respective row, column or sqaure with a number prefix.

Updateed the code to use only one HashSet as r,c,s labels make each value unique.

Alternative approach will be to take three 2d boolean arrays and mark each value true for every row col and square.

Leanrning: Hashset

 */


// class Solution {
//     public boolean isValidSudoku(char[][] board) {

//         HashSet<String> rows = new HashSet<>();
//         // HashSet<String> cols = new HashSet<>();
//         // HashSet<String> sqs = new HashSet<>();

//         for(int r =0; r<9; r++){
//             for(int c=0; c<9; c++){

//                 if(board[r][c] == '.')
//                     continue;

//                 //check if already seen in row, col or square
//                 if(rows.contains("r"+r+board[r][c]) || 
//                 rows.contains("c"+c+board[r][c]) || 
//                 rows.contains("s"+r/3+c/3+board[r][c])){
//                     // System.out.println("diff at :: "+r + c+ (r/3+c/3));
//                     return false;
//                 }

//                 //adding visited elements in the hashsets created
//                 //adding to row with row number and value
//                 // rows.add("r"+r+board[r][c]);
//                 // cols.add("c"+c+board[r][c]);
//                 // sqs.add("s"+r/3+c/3+board[r][c]);

//                 rows.add("r"+r+board[r][c]);
//                 rows.add("c"+c+board[r][c]);
//                 rows.add("s"+r/3+c/3+board[r][c]);
                
//             }
//         }

//         // System.out.println(rows);
//         // System.out.println(cols);
//         // System.out.println(sqs);
        
//         return true;
//     }
// }

class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] row= new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] sq = new boolean[9][9];

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){

                if(board[r][c] == '.')
                    continue;

                int tmp = board[r][c] - '1';
                int sqValue = (r/3)*3+(c/3);

                if(row[r][tmp] || col[c][tmp] || sq[sqValue][tmp])
                    return false;

                row[r][tmp] = true;
                col[c][tmp] = true;
                sq[sqValue][tmp] = true;

                
            }
        }

        return true;
    }
}