//Approach : Sliding Window
// Time compelxity: 0(n)
// Space complexity: 0(1)


/*
        Idea:
        Instead of checking every substring again and again (which would be O(n*k)),
        we use the Sliding Window technique to achieve O(n) time.

        Steps:

        1. First, calculate the number of vowels in the first window of size k.
           Example:
           s = "abciiidef", k = 3
           first window = "abc"

        2. Store this count as maxCount.

        3. Now slide the window one character at a time:
           - Add the new character entering the window.
           - Remove the character leaving the window.

           Example sliding:
           abc → bci → cii → iii → iid → ide → def

        4. While sliding:
           - If the new character is a vowel → count++
           - If the removed character is a vowel → count--

        5. Update maxCount each time.

        Why this works:
        Instead of recalculating vowels for the whole window,
        we only update the count based on the two characters that change.
*/


class Solution{
  public int maxVowels(String s, int k){
    int count = 0;
    for(int i = 0; i < k; i++){
      if(isVowel(s.charAt(i)){
        count++;
      }
    }
    int maxCount = count;

    for(int i = k; i < s.length(); i++){
      if(isVowel(s.charAt(i))){
        count++;
      }
      if(isVowel(s.charAt(i-k))) count--;

      maxCount = Math.max(maxCount, count);
    }
    return maxCount;
  }
   boolean isVowel(char c){
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
    }
}
