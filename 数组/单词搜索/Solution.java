class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length, column = board[0].length;
        boolean[][] visited = new boolean[row][column];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                boolean flag = search(board, word, i, j, visited, 0);
                
                if(flag) return true;
            }
        }

        return false;
    }

    public boolean search(char[][] board, String word, int i, int j, boolean[][] visited, int k) {
        if(board[i][j] != word.charAt(k)){
            return false;
        }

        if(k == word.length() - 1){
            return true;
        }

        visited[i][j] = true;
        boolean res = false;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        for(int[] dir : dirs){
            int newi = i + dir[0];
            int newj = j + dir[1];

            if(newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length){
                if(!visited[newi][newj]){
                    boolean flag = search(board, word, newi, newj, visited, k+1);
                    if(flag){
                        res = true;
                        break;
                    }    
                }
            }
        }

        visited[i][j] = false;
        return res;
    }
}
