/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int peak = findPeak(mountainArr);

        // ascending part
        int firstTry = binarySearch(
                mountainArr,
                target,
                0,
                peak,
                true
        );

        if(firstTry != -1){
            return firstTry;
        }

        // descending part
        return binarySearch(
                mountainArr,
                target,
                peak + 1,
                mountainArr.length() - 1,
                false
        );
    }

    int findPeak(MountainArray arr){

        int start = 0;
        int end = arr.length() - 1;

        while(start < end){

            int mid = start + (end - start) / 2;

            if(arr.get(mid) < arr.get(mid + 1)){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        return start;
    }

    int binarySearch(
            MountainArray arr,
            int target,
            int start,
            int end,
            boolean isAsc
    ){

        while(start <= end){

            int mid = start + (end - start) / 2;

            int value = arr.get(mid);

            if(value == target){
                return mid;
            }

            if(isAsc){

                if(target < value){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }

            }else{

                if(target < value){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}