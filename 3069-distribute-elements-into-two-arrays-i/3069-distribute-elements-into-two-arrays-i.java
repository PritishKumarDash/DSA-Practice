class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int k = 0;
        int j = 0;

        for(int i = 2; i < n; i++){
            if(arr1[k] > arr2[j]) {
                arr1[++k] = nums[i]; 
            }else{
                arr2[++j] = nums[i];
            }
        }
        j = 0;
        while(j < n && arr2[j] != 0){
            arr1[++k] = arr2[j++];
        }
        return arr1;
    }
}