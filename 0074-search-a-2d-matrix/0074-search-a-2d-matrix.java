class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int st = 0;
        int end = row * col - 1;

        while(st <= end){
            int mid = st + (end - st) /2 ;
            int rows = mid / col;
            int cols = mid % col;
            int val = matrix[rows][cols];
            if(val < target){
                st = mid + 1;
            } else if(val == target){
                return true;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}