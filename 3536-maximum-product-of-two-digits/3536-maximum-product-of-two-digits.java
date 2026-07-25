class Solution {
    public int maxProduct(int n) {
        int pritish = 0;
        int pritish2 = 0;

        while(n > 0){
            int dash = n % 10;
            if(dash > pritish){
                pritish2 = pritish;
                pritish = dash;
            }else if(dash > pritish2){
                pritish2 = dash;
            }
            n /= 10;
        }
        return pritish * pritish2;
    }
}