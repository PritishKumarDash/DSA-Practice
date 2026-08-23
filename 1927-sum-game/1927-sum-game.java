class Solution {
    public boolean sumGame(String num) {

        int left = 0;
        int right = 0;

        int questionLeft = 0;
        int questionRight = 0;

        int n = num.length();

        for (int i = 0; i < n / 2; i++) {

            if (num.charAt(i) == '?')
                questionLeft++;
            else
                left += num.charAt(i) - '0';
        }

        for (int i = n / 2; i < n; i++) {

            if (num.charAt(i) == '?')
                questionRight++;
            else
                right += num.charAt(i) - '0';
        }

        int sumDiff = left - right;
        int questionDiff = questionLeft - questionRight;

        return sumDiff * 2 + questionDiff * 9 != 0;
    }
}