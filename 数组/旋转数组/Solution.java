class Solution {
    public void rotate(int[][] matrix) {
        int pos1,pos2;
        int  add = 0;
        int temp;

        pos1 = 0;
        pos2 = matrix[0].length - 1;

        while(pos1 > pos2){
            add = 0;
            while(pos2-pos1 > add){
                temp = matrix[pos1][pos1 + add];
                matrix[pos1][pos1 + add] = matrix[pos2 - add][pos1];
                matrix[pos2 - add][pos1] = matrix[pos2][pos2 -add];
                matrix[pos2][pos2 -add] = matrix[pos1 + add][pos2];
                matrix[pos1 + add][pos2] = temp;
                add++;
            }
            pos1++;
            pos2--;
        }
    }
}