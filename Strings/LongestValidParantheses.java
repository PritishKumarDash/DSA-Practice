/*
Problem:
Given a string containing just '(' and ')',
find the length of the longest valid (well-formed) parentheses substring.

Example:
Input: s = ")()())"
Output: 4

Explanation:
The longest valid substring is "()()".

Approach:
Use a stack to store indices.

1. Push -1 into the stack (base index).
2. Traverse the string.

If '(' appears:
    Push its index into the stack.

If ')' appears:
    Pop the stack.

    If stack becomes empty:
        Push current index (new base).

    Otherwise:
        Calculate valid length:
        length = currentIndex - stack.peek()

        Update max length.

Time Complexity:
O(n)

Space Complexity:
O(n)
*/

class Solution {
    public int longestValidParentheses(String s) {
      int max = 0;
      /*Input: s = ")()())"
      st = [-1]
      ch = )
      st.push(0), max = 0-(-1) = 1
      ch = (
      st,push(1) st = [1]
      ch = ), st.pop(), st = [0], max = 2 - 0 = 0
      ch = (, st.push(3), st = [0, 3]
      ch = ), st.pop(), st = [0], max = 4-0 = 4
      ch = ), st.pop(), st = [], st.push(i), max = 4 (ans)
      */
      Stack<Character> st = new Stack<>();
      st.push(-1);
      for(int i = 0; i < s.length(); i++){
        char ch = s.charAt(i);
        if(ch == '('){
          st.push(i);
        }
        else{
          st.pop();
          if(st.empty()){
            st.push(i);
          }else{
            max = Math.max(max, i - st.peek());
          }
        }
      }
      return max;
    }
}
