import java.util.HashMap;
import java.util.Map;
/**
 * 使用哈希表的并查集
 * 
 */
class Solution {
    public int removeStones(int[][] stones){
        int n = stones.length;
        UnionFind uf = new UnionFind();

        for(int[] stone: stones){
            uf.union(stone[0] + 10000, stone[1]);
        }

        return n - uf.size;
    }
}

class UnionFind{
    public int size;
    private Map<Integer, Integer> map;

    public UnionFind(){
        this. size = 0;
        map = new HashMap<>();
    }

    public int Find(int x){
        if(!map.containsKey(x)){
            map.put(x, x);
            this.size ++;
        }
        
        if(x != map.get(x)){
            map.put(x, Find(map.get(x)));
        }

        return map.get(x);
    }

    public void union(int x, int y){
        int p_x = Find(x);
        int p_y = Find(y);

        if(p_x == p_y){
            return;
        }
        map.put(p_x, p_y);
        this.size --;
    }
}
