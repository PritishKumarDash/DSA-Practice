// APproach: SLiding Window
// Time complexity: 0(n)
// Space complexity: 0(1)
class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold){
      int count = 0;
      int target = threshold * k;
      int sum = 0;
      for(int i = 0; i < k; i++){
        sum += arr[i];
      }
      if(sum >= target){
        count++;
      }
      for(int i = k; i < arr.length; i++){
        sum += arr[i];
        sum -= arr[i - k];

        if(sum >= target){
        count++;
        }
      }
      return count;
    }
}
