class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>();
        if(digits.length() == 0) return ans;
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper("", digits, map, ans);
        return ans;
    }
    void helper(String p, String up, String[] map, List<String> ans){
        if(up.length() == 0){
            ans.add(p);
            return;
        }
        int digit = up.charAt(0) - '0';
        String letters = map[digit];

        for(int i = 0; i < letters.length(); i++){
            char ch = letters.charAt(i);
            helper(p + ch, up.substring(1), map, ans);
        }
    }
}