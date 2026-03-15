/*
Approach: 
Compare the lengths of both strings.
If lengths are not equal → return false.
Create a frequency array of size 26.
Increase count for characters of s.
Decrease count for characters of t.
Traverse the frequency array.
If any value is not 0 → return false.
If all values are 0 → strings are anagrams.

Time Complexity:
O(n)

Space Complexity:
O(1)
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(m != n) return false;

        int count[] = new int[26];
        for(int i = 0; i < m; i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for(int c : count){
            if(c!=0) return false;
        }
        return true;
    }
}
