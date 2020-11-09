import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 根据数字二进制下 1 的数目排序
 * 
 * comparator 和 comparable  
 * https://blog.csdn.net/xx326664162/article/details/52227690
 * 
 */
class Solution{
    public int[] sortByBits(int[] arr) {
        int bit[] = new int[10001];
        List<Integer> list = new ArrayList<>();
        for(int x:arr){
            list.add(x);
            bit[x] = get(x);
        }
        Collections.sort(list, new Comparator<Integer>(){
            @override
            public int compare(Integer x, Integer  y) {
                if(bit[x]!= bit[y])
                    return bit[x] - bit[y];
                else
                    return x - y;
            }
        });
        for(int i=0; i<arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int get(int x){
        int res = 0;
        for(int i = 0;i < 32; i++){
            if(((x >>> i) & 1) != 0)
                res ++;   
        }
        return res;
    }
}