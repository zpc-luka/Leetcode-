/**
 *  回溯
 *  超时 ！！！！！！！！！！！！
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        path = grid[0][0];
        dfs(grid, 0, 0);
        return res;
    }

    private int path = 0;
    private int res = Integer.MAX_VALUE;

    private void dfs(int[][] grid, int row, int column){
        if(row == grid.length - 1 && column == grid[0].length - 1){
            res = Math.min(res, path);
            return;
        }

        int[][] dirs = {{0, 1}, {1, 0}};

        for(int[] dir: dirs) {
            int new_row = row + dir[0];
            int new_column = column + dir[1];
            
            if(new_row < grid.length && new_column < grid[0].length) {
                path += grid[new_row][new_column];
                
                if(path > res){
                    path -= grid[new_row][new_column];
                    continue;
                }

                dfs(grid, new_row, new_column);

                path -= grid[new_row][new_column];
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{1,2}, {5,6}, {1,1}};

        System.out.println(s.minPathSum(grid));
    }
}