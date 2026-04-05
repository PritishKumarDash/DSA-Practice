class Solution {
    public String convert(String s, int numRows) {
        //input - PAYPALISHIRING 
        if(numRows == 1) return s;

        StringBuilder[] str = new StringBuilder[numRows];
        //str = ["", "", ""]

        for(int i = 0; i < numRows; i++){
            str[i] = new StringBuilder();
        }

        int currRows = 0;
        boolean goingDown = false;

        for(char c : s.toCharArray()){
            str[currRows].append(c); //str[0].append(c) = str = ["P", "", ""]
            //str[1].append(c) str = ["P", "A", ""]
            //str[2].append(c) str = [["P"], ["A"], ["Y"]]
            //str[1].append(c) str = [["P"], ["AP"]["Y"]]
            // str[0].append(c) str = [["PA"],["AP"],["Y"]]

            if(currRows == 0 || currRows == numRows - 1){
                goingDown = !goingDown; // goingDown = true
                // goingDown = false because currRows = numRows - 1
                //goingDown = true because currRows = 0
            }

            if(goingDown){
                currRows++; // 0 -> 1 -> 2. 0 -> 1
            }else{
                currRows--; // 2 -> 1 -> 0
            }
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder row : str) {
            result.append(row);
        }

        return result.toString();

    }
}