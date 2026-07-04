class Solution {
    public int numberOfSubstrings(String s) {
        // int n = s.length();
        // int i = 0;
        // int count = 0;
        // HashMap<Character, Integer> def = new HashSet<>();
        // HashMap<>
        // int j = 0;
        // while(i < n){
        //     if(j >= 3){
        //         if(set.contains())
        //     }
        // }

        int freq[] = new int[3];
        int count = 0;
        int curCount = 0;
        int left = 0;
        int n = s.length();
        for(int right = 0; right < n; right++){
            char c = s.charAt(right);
            freq[c-'a']++;
            if(freq[c - 'a'] == 1){
                curCount++;
            }
            while(curCount == 3){
                count += (n - right);
                char ch = s.charAt(left);
                freq[ch - 'a']--;
                if(freq[ch - 'a'] == 0){
                    curCount--;
                }
                left++;
            }
        }
        return count;
    }
}