// Approach: Sliding Window
// Time complexity: 0(n)
// Space complexity: 0(1)

class solution{
  public int numSubarrayProductLessThanK(int[] nums, int k){
    if(k <= 0) return 0;
    int count = 0;
    int left = 0;
    int prod = 1;
    for(int right = 0; right < nums.length; right++){
      prod *= nums[right]; // We will multiply the elements till its product is less than k
      while(prod >= k){ // if we get a product greater than k
        prod /= nums[low]; // it will remove the element as long as the product is greater than k
        low++; // increment the index
      }
      count += right - left + 1;
    }
    return count;
  }
}
