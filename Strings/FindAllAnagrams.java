// Approach: Fixed Sliding window + hashmap
// Time Complexity: 0(n)
// Space complexity: 0(1)

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length()) return result;

        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();

        for(char c : p.toCharArray()){
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int k = p.length();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            if(i >= k){
                char left = s.charAt(i - k);
                if(sMap.get(left) == 1){
                    sMap.remove(left);
                }else{
                    sMap.put(left, sMap.get(left) - 1);
                }
            }
            if(sMap.equals(pMap)){
                result.add(i - k + 1);
            }
        }
        return result;
    }
}

//Alternate optimized approach using array
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if(s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for(int i = 0; i < p.length(); i++){
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        if(Arrays.equals(pCount, sCount)){
            result.add(0);
        }

        for(int i = p.length(); i < s.length(); i++){

            sCount[s.charAt(i) - 'a']++;                
            sCount[s.charAt(i - p.length()) - 'a']--;    

            if(Arrays.equals(pCount, sCount)){
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
