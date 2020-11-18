import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution{
    /**
     * 暴力解法
     */
    public int[][] allCellDisOrder(int R, int C, int r0, int c0){
        int[][] ret = new int[R*C][];              //二维矩阵， 每行存储坐标值
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                ret[i*C+R] = new int[]{i,j};        // 存储坐标值
            }
        }
        Arrays.sort(ret, new Comparator<int []>(){
            public int compare(int[] a, int[] b) {
                return (Math.abs(a[0] - r0) + Math.abs(a[1] - c0) - (Math.abs(b[0] - r0) + Math.abs(b[1] - c0));
            }
        });             // 排序

        return ret;
    }
    /**
     * 桶排序
     */
    public int[][] allCellDisOrder2(int R, int C, int r0, int c0){
        int maxDist = Math.max(r0, R-1-r0) + Math.max(c0, C-1-c0);
        List<List<int[]>> bucket = new ArrayList<>();

        for(int i=0;i<maxDist;i++){
            bucket.add(new ArrayList<int[]>());
        }

        for(int i=0; i<R; i++){
            for(int j=0;j<C;j++){
                int d = Math.abs(i - r0) + Math.abs(j - c0);
                bucket.get(d).add(new int[]{i,j});        // 距离为d的列表添加坐标
            }
        }

        int[][] ret = new int[R*C][];
        int index = 0;
        for(int i=0;i<= maxDist;i++){            //   输出
            for(int[] it: bucket.get(i)){
                ret[index] = it;
                index ++;
            }
        }
        return ret;
    }
}