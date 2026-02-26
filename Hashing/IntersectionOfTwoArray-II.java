/*
Problem: Intersection of two arrays ||
Approach: Hashmap
TIme complexity: O(n+m)
Space Complexity: O( min ( n , m ) )
*/
class Solution{
  public int[] intersect(int[] nums1, int[] nums2){
    if(num1.length > num2.length){
      return intersect(num2, num1);
    }
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();

    for(int num : nums1){
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for(int num : nums2){
      if(map.containsKey(num) && map.get(num)){
        map.put(num, map.get(num) - 1);
        result.add(num);
      }
    }
    int ans[] = new int[result.size()];
    for(int i=0; i<result.size();i++){
      ans[i] = map.get(i);
    }
    return ans;
  }
}
