/*
Problem:
Given a string s consisting of words and spaces,
return the length of the last word in the string.

A word is defined as a sequence of non-space characters.

Example:
Input: s = "Hello World"
Output: 5

Approach:
Traverse the string from the end.
First skip all trailing spaces.
Then count characters until a space or start of string is reached.

Time Complexity:
O(n)

Space Complexity:
O(1)
*/

class Solution {
    public int lengthOfLastWord(String s) {

        int i = s.length() - 1;

        while(i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        int count = 0;

        while(i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }

        return count;
    }
}
