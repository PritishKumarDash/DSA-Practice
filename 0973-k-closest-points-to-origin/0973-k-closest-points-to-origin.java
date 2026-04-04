class Solution {
    class customComparator implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            int distA = a[0]*a[0] + a[1]*a[1];
            int distB = b[0]*b[0] + b[1]*b[1];

            return distB - distA;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new customComparator());

        for(int[] point : points){
            pq.offer(point);

            if(pq.size() > k){
                pq.poll();
            }
        }

        int res[][] = new int[k][2];
        int i = 0;

        while(!pq.isEmpty()){
            res[i++] = pq.poll();
        }

        return res;
    }
}