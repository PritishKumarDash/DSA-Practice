/*
SLIDING WINDOW MAXIMUM (Deque Approach)

Idea:

1. Deque stores indices of elements.
2. Elements in deque are maintained in decreasing order of values.

Algorithm:

For every element nums[i]:

1️⃣ Remove indices from front if they are outside the window
   condition: dq.peekFirst() <= i-k

2️⃣ Remove smaller elements from back
   because they can never become maximum
   condition: nums[dq.peekLast()] < nums[i]

3️⃣ Insert current index at the back
   dq.offerLast(i)

4️⃣ When window size reaches k (i >= k-1)
   the maximum element is at the front of deque
   result[index++] = nums[dq.peekFirst()]

Time Complexity: O(n)
Each element is inserted and removed at most once.
*/
import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new LinkedList<>(); // Created an deque which stores the indices
        int n = nums.length;
        int[] result = new int[n-k+1]; // Example: if the size of n is 8 and k(Sliding window) is 3 then the result will be 8 - 3 + 1 = 6. Resultant array will have 6 elements
        int index = 0;

        for(int i = 0; i < n; i++){
          //Example:  nums = [1,3,-1,-3,5,3,6,7], k = 3
          // i = 0 , nums[i] = 1
          // This condition checks whether the deque is empty and whether it goes outside of the window
          // dq = [] empty, i - k = 0-3 = -3, continue in iteration 1
          /* in iteration 2 
          i = 1, nums[i] = 3, dq.peekFirst() = 0 <= -2 false, no removal
          */
          /*In iteration 3
          i = 2, nums[2] = -1
          dq = [1] not empty and dq.peekFirst() = 1 <= -1 false , so nothing removes
          */
          /* In iteration 4 
          i = 3, nums[3] = -3
          dq = [1, 2] not empty, dq.peekFirst() = 1 <= 0 false, nothing removes
          */
          /* In iteration 5
          i = 4, nums[4] = 5
          dq = [1, 2, 3] not empty and dq.peekFIrsst() = 1 < = 1 true, so using pollFirst() it removes the first element that convert the dq = [2, 3]
          */
          /* In iteration 6
          dq = [4] not empty and dq.peekFirst = 4 <= 2 false, nothing removes
          */
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            // dq is empty
          /*in iteration 2 
          dq is not empty and dq.peekLast() = 0, nums[0] < nums[1] = 1 < 3 true
          so before, dq = [0] after pollfirst it becomes dq = []
          */
          /* in iteration 3
          dq is not empty and dq.peekLast() = 1, nums[1] < nums[2] = 3 < -1 false, nothing removes
          */
          /* In iteration 4
          dq is not empty and nums[2] < nums[3] = -1 < -3 false, nothing removes
          */
          /* In iteration 5 
          dq = [2, 3] is not empty and nums[3] < nums[4] = -3 < 5 true, dq.pollLast() removes the last element, dq = [2]
          atill dq is not empty, nums[2] < nums[4] = -1 < 5 true so it removes the last element 2 also, dq = []
          */
          /* In iteration 6 
          dq = [4] not empty and nums[4] < nums[5] = 5 < 3 false, nothing removes
          */
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            // insert index . dq = [0], value = {1}
          /* dq = [], i = 1, dq.offerLast(i) = [1]
          */
          /* iteration 3 
          dq.offerlast(2)
          dq = [1, 2]
          */
          /* in iteration 4 
          dq.offerlast(3) dq = [1, 2, 3]*/
          /* in iteration 5 
          dq.offerLast(4), dq = [4] 
          */
          /* In iteration 6
          dq.offerLast(5), dq = [4, 5]
          */
            dq.offerLast(i);
            // 0 >= 2 false
          /*iteratiom 2
          1 >= 2 false
          no insertion in result
          */
          /* in iteration 3 
          2 >= 2 true
          result[0] = nums[peekFirst()] = nums[1] = 3
          index = 0 + 1 = 1
          */
          /* in iteration 4
          3 > = 2 true
          result[1] = nums[dq.peekFirst()] = nums[1] = 3
          result = [3, 3], index++
          index = 2
          */
          /*In iteration 5
          4 >= 2
          result[2] = nums[4] = 5
          result = [3, 3, 5]
          */
          /* 5 >= 2 true
          dq.peekFirst() = 4
          result[3] = nums[4] = 5
          result = [3, 3, ,5 ,5]
          */
            if(i >= k-1){
                result[index++] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
} 
