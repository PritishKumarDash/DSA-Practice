class Solution {
    class customComparator implements Comparator<Integer>{
        int x;
        customComparator(int x){
            this.x = x;
        }

        public int compare(Integer a, Integer b){
            int diffA = Math.abs(a-x);
            int diffB = Math.abs(b-x);

            if(diffA == diffB) {
                return b - a;
            }
            return diffB - diffA;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new customComparator(x));
         for(int num : arr){
            pq.offer(num);

            if(pq.size() > k){
                pq.poll();
            }
         }

         List<Integer> result = new ArrayList<>();

        while(!pq.isEmpty()){
            result.add(pq.poll());
        }

        Collections.sort(result); 

        return result;
    }
}