// Approach: Brute Force
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution{
  public int findClosestNumber(int nums[]){
    int closest = nums[0];
    for(int i = 0; i < nums.length; i++){
      if(Math.abs(nums[i]) < Math.abs(closest)){
        closest = nums[i];
      }else if(Math.abs(nums[i]) == Math.closest(closest) && Math.abs(nums[i]) > closest){
        closest = nums[i];
      }
    }
    return closest;
  }
}
