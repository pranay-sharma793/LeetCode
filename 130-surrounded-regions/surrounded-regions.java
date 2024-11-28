class Solution {
    public void solve(char[][] b) {

        for(int i=0; i<b.length; i++){
            if(b[i][0] == 'O'){
                updateRegion(b, i, 0);
            }

            int tmp = b[0].length-1;

            if(b[i][tmp] == 'O'){
                updateRegion(b, i, tmp);
            }
        }

        for(int i=0; i < b[0].length; i++){
            if(b[0][i] == 'O'){
                updateRegion(b, 0, i);
            }

            int tmp = b.length-1;

            if(b[tmp][i] == 'O'){
                updateRegion(b, tmp, i);
            }
        }

        
        for(int i=0; i < b.length; i++){
            for(int j=0; j < b[0].length; j++){

                if(b[i][j] == 'O'){
                    b[i][j] = 'X';
                }

                if(b[i][j] == 'T'){
                    b[i][j] = 'O';
                }
            }
        }
    }

    private void updateRegion(char[][] b, int r, int c){

        if(r < 0 || c < 0 || r >= b.length || c >= b[0].length || b[r][c] != 'O') return;

        b[r][c] = 'T';

        updateRegion(b, r+1, c);
        updateRegion(b, r-1, c);
        updateRegion(b, r, c+1);
        updateRegion(b, r, c-1);
    }
}