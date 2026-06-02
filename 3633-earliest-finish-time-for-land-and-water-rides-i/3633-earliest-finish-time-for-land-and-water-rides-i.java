class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < landStartTime.length; i++){
            for(int j = 0; j < waterStartTime.length; j++){
                int landFirst = Math.max(landStartTime[i] + landDuration[i], waterStartTime[j]) + waterDuration[j];

                ans = Math.min(landFirst, ans);

                int waterFirst = Math.max(waterStartTime[j] + waterDuration[j], landStartTime[i])+landDuration[i];

                ans = Math.min(waterFirst, ans);
            }
        }
        return ans;
    }
}