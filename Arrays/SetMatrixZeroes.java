// Approach: Brute Force
// Time Complexity: O(n*m)
// Space Complexity: O(n+m)
class Solution {
    public void setZeroes(int[][] matrix) {
        /* if mat = [[1,1,1], [1,0,1], [1,1,1]]
        then matrix length calculates then number of rows in a matrix, and matrix[0].length calculates the no. of cols. ex- here matrix[0] = [1,1,1] it's length is 3, so the column length is 3. That's how it's calculated.*/
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        /* This loop sets the row no. or col no. to true if that respective matrix[i][j] is equal to 0 */

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
/* if the row[i] is true then this loop sets entire row as 0 */
        for(int i = 0; i < n; i++){
            if(row[i]){
                for(int j = 0; j < m; j++){
                    matrix[i][j] = 0;
                }
            }
        }
/* if the col[i] is true then this loop sets entire col as 0 */

        for(int j = 0; j < m; j++){
            if(col[j]){
                for(int i = 0; i < n; i++){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
