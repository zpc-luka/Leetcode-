import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int n = A.length;

        for(int i=n-1; i>=0; i--){
            int sum = A[i] + K % 10;    // K%10 获取最后一位
            K /= 10;

            if(sum >= 10){            // 处理进位
                sum = sum % 10;
                K++;                  // 进位 放在下一次处理中
            }

            res.add(sum);
        }

        while(K>0){          // 如果 K 的位数 比 A 的 多
            res.add(K%10);
            K = K / 10;
        }

        Collections.reverse(res);
        return res;
    }
}