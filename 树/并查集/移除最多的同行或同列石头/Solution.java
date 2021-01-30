/**
 * 普通没有优化的并查集
 * 另外一个版本是使用哈希表的并查集
 */
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);

        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    uf.Union(i, j);
                }
            }
        }

        return n - uf.n;
    }
}

class UnionFind{
    public int n;
    private int[] parent;

    public UnionFind(int n){
        this.n = n;
        parent = new int[n];

        for(int i = 0; i < n; i ++){
            parent[i] = i;
        }
    }

    public int Find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = Find(parent[x]);
    }

    public void Union(int x, int y){
        int p_x = Find(x);
        int p_y = Find(y);

        if(p_x != p_y){
            parent[p_x] = p_y;
            n--;
        }
    }
}