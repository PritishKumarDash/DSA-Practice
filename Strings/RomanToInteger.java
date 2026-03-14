/*
Problem:
Given a roman numeral string s, convert it to an integer.

Example:
Input: s = "MCMXCIV"
Output: 1994

Explanation:
M = 1000
CM = 900
XC = 90
IV = 4
Total = 1994

Approach:
Traverse the string from left to right.

For each character:
1. Get its integer value.
2. Compare it with the next character.
3. If current value < next value → subtract it.
4. Otherwise → add it to the result.
Time Complexity:
O(n)
Space Complexity:
O(1)
*/
class Solution{
  public int romanToInt(String s){
    int sum = 0;
    for(int i = 0; i < s.length(); i++){
      int curr = val(s.charAt(i));
      if(i+1 < s.length() && curr < val(s.charAt(i+1)){
        sum = sum - curr;
      }else{
        sum = sum + curr;
      }
    }
  }
  int val(char ch){
     if(c == 'I') return 1;
        if(c == 'V') return 5;
        if(c == 'X') return 10;
        if(c == 'L') return 50;
        if(c == 'C') return 100;
        if(c == 'D') return 500;
        return 1000;
  }
}
