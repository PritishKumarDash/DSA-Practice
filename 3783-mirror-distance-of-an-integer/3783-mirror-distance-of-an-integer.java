class Solution {
    public int mirrorDistance(int n) {
        int rev = reverse(n);
        return Math.abs(n - rev);
    }
    public int reverse(int n){
        int sum = 0;
        int temp = n;
        while(temp > 0){
            sum = sum *10 + temp % 10;
            temp/=10;
        }
        return sum;
    }
}