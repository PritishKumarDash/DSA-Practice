class Solution {
    class customComparator implements Comparator<String>{
        HashMap<String, Integer> map = new HashMap<>();

        customComparator(HashMap<String, Integer> map){
            this.map = map;
        }

        public int compare(String a, String b){
           if(map.get(a).equals(map.get(b))){
                return b.compareTo(a); 
            }
            return map.get(a) - map.get(b); 
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(new customComparator(map));

        for(String s : map.keySet()){
            pq.offer(s);

            if(pq.size() > k){
                pq.poll();
            }
        }

        List<String> res = new ArrayList<>();

        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
}