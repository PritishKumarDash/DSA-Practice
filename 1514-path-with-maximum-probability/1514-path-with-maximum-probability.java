class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<double[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];

            adj.get(u).add(new double[]{v, prob}); 
            adj.get(v).add(new double[]{u, prob});
        }
        double[] res = new double[n];

        PriorityQueue<double[]> pq = new PriorityQueue<>(
        (a, b) -> Double.compare(b[0], a[0])
);

        res[start_node] = 1.0;
        pq.offer(new double[]{1.0, start_node});

        while(!pq.isEmpty()){
            double cur[] = pq.poll();

            double curProb = cur[0];
            int node = (int) cur[1];

            if(node == end_node) return curProb;

            if(curProb < res[node]) continue;

            for(double[] nei : adj.get(node)){
                int adjNode = (int) nei[0];
                double edgeProb = nei[1];

                double newProb = curProb * edgeProb;

                if (newProb > res[adjNode]) {

                    res[adjNode] = newProb;

                    pq.offer(new double[]{newProb, adjNode});
                }
            }
        }

        return 0.0;
    }
}