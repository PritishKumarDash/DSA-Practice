class Solution {
   
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int arr[] = new int[n*m];
        int index = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[index++] = matrix[i][j];
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num : arr){
            pq.offer(num);

            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}