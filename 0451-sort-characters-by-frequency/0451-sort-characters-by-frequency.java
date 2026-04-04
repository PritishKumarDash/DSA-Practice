class Solution {
    class customComparator implements Comparator<Character>{
        HashMap<Character, Integer> map = new HashMap<>();

        customComparator(HashMap<Character, Integer> map){
            this.map = map;
        }

        public int compare(Character a, Character b){
            return map.get(b) - map.get(a);
        }
    }
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(new customComparator(map));

        pq.addAll(map.keySet());

       StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {
            char ch = pq.poll();
            int freq = map.get(ch);

            while (freq-- > 0) {
                res.append(ch);
            }
        }

        return res.toString();
    }
}