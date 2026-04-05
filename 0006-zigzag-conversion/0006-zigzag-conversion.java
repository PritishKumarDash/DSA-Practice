class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder[] str = new StringBuilder[numRows];

        for(int i = 0; i < numRows; i++){
            str[i] = new StringBuilder();
        }

        int currRows = 0;
        boolean goingDown = false;

        for(char c : s.toCharArray()){
            str[currRows].append(c);

            if(currRows == 0 || currRows == numRows - 1){
                goingDown = !goingDown;
            }

            if(goingDown){
                currRows++;
            }else{
                currRows--;
            }
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder row : str) {
            result.append(row);
        }

        return result.toString();

    }
}