class Solution {
    public class customComparator implements Comparator<Integer>{
         HashMap<Integer, Integer> map;

        customComparator(HashMap<Integer, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(Integer a, Integer b) {
            return map.get(a) - map.get(b); 
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
       

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

         PriorityQueue<Integer> pq = new PriorityQueue<>(new customComparator(map));

        for(int num : map.keySet()){
            pq.offer(num);

            if(pq.size() > k){
                pq.poll();
            }
        }

        int arr[] = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            arr[i++] = pq.poll();
        }
        
        return arr;
    }
}