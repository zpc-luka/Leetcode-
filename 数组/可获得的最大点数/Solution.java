import java.util.Arrays;

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int sum = Arrays.stream(cardPoints).sum();
        if(k == len){
            return sum;
        }

        int windowsSize = len - k;
        int temp = 0;
        int res = 0;
        for(int i=0; i<windowsSize; i++){
            temp += cardPoints[i]; 
        }
        
        res = temp;

        for(int i=windowsSize; i<len; i++){
            temp = temp + cardPoints[i] - cardPoints[i - windowsSize];
            res = Math.min(res, temp);
        }

        return sum - res;
    }
}


