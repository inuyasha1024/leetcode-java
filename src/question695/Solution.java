package question695;

public class Solution {
    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j< n; j++){
                if (grid[i][j] == 1){
                    res = Math.max(dfs(i,j,grid,0),res);
                }
            }
        }
        return res;
    }

    public static int dfs(int i, int j, int[][] visited, int res){
        if (i >= visited.length || j >= visited[0].length || i <0 || j<0 || visited[i][j] == 0){
            return res;
        }
        visited[i][j] = 0;
        res ++;


        res = Math.max(res,dfs(i + 1,j, visited, res));
        res = Math.max(res,dfs(i -1,j, visited, res));
        res = Math.max(res,dfs(i,j+1, visited, res));
        res = Math.max(res,dfs(i ,j-1, visited, res));

        return res;
    }

    public static void main(String[] args) {
        int[][] islands = new int[][]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        System.out.println(maxAreaOfIsland(islands));
    }
}
