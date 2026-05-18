class Solution {
    public boolean isBalanced(String num) {
        int evSum = 0;
        int odSum = 0;

        for(int i = 0; i < num.length(); i++){
            int n = num.charAt(i) - '0';

            if(i % 2 == 0){
                evSum += n;
            }
            else{
                odSum += n;
            }
        }
        return evSum == odSum;
    }
}