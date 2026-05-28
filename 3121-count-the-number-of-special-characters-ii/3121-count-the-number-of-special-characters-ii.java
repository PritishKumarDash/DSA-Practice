class Solution {
    public int numberOfSpecialChars(String word) {
        Map<Character, Integer> lower = new HashMap<>();
        Map<Character, Integer> large = new HashMap<>();

        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);

            if(ch >= 'a' && ch <= 'z'){
                lower.put(ch, i);
            }

            else{
                char small = (char)(ch + 32);
                if(!large.containsKey(small)){
                    large.put(small, i);
                }
            }

            }
            int count = 0;
            for(char ch : lower.keySet()){
                if(large.containsKey(ch) && lower.get(ch) < large.get(ch)){
                    count++;
                }
            }
            return count;
        }
    }
