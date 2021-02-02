class Solution{
    public int[] findRedundantConnection(int[][] edges){
        int n = edges.length;
        UnionFind uf = new UnionFind(n);

        for(int[] edge: edges){
            if(uf.same(edge[0], edge[1])){
                return edge;
            }else{
                uf.Union(edge[0], edge[1]);
            }
        }

        return edges[edges.length - 1];
    }
}

class UnionFind{
    public int n;
    public int[] parent;

    public UnionFind(int n){
        this.n = n;
        parent = new int[n+1];
        for(int i=0; i < n; i++){
            parent[i] = i;
        }
    }

    public int Find(int x){
        while(x != parent[x]){
            x = Find(parent[x]);
        }

        return x;
    }

    public void Union(int x, int y){
        int root_x = Find(x);
        int root_y = Find(y);

        if(root_x != root_y){
            parent[root_x] = root_y;
        }
    }

    public boolean same(int x, int y){
        return Find(x) == Find(y);
    }
}
