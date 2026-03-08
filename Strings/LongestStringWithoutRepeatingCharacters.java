/*
Problem:
Given a string s, find the length of the longest substring without repeating characters.

Example:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc".

Approach:
Use Sliding Window technique with two pointers (left and right).
Maintain a HashSet to store characters currently in the window.
If a duplicate character appears, shrink the window from the left
until the duplicate is removed.

Time Complexity:
O(n)

Space Complexity:
O(n)
*/

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for(int right = 0; right < s.length(); right++) {

            char c = s.charAt(right);

            while(set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
