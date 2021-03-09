import javax.xml.stream.XMLOutputFactory;

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        UnionFind uf = new UnionFind(m * n);
        int count = 0;

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] =='0'){
                    count ++;
                }else{
                    for(int[] dir: directions) {
                        int newi = i + dir[0];
                        int newj = j + dir[1];
                        if (newi >= 0 && newj >= 0 && newi < m && newj < n && grid[newi][newj] == '1') {
                            uf.union(i*n+j, newi*n+newj);
                        }
                    }
                }
            }
        }
        return uf.size - count;
    }
}

class UnionFind {
    int[] roots;
    int size; // 集合数量
    
    public UnionFind(int n) {
        roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        size = n;
    }

    public int find(int i) {
       if (i == roots[i]) {
           return i;
       }
       return roots[i] = find(roots[i]);      // 路径压缩版本
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            roots[pRoot] = qRoot;
            size--;
        }
    }
}