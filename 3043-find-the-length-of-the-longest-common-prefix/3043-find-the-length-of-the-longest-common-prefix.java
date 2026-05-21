class Solution {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        HashSet<String> set = new HashSet<>();

        
        for (int num : arr1) {

            String s = String.valueOf(num);

            String prefix = "";

            for (char ch : s.toCharArray()) {

                prefix += ch;

                set.add(prefix);
            }
        }

        int max = 0;

        for (int num : arr2) {

            String s = String.valueOf(num);

            String prefix = "";

            for (int i = 0; i < s.length(); i++) {

                prefix += s.charAt(i);

                if (set.contains(prefix)) {

                    max = Math.max(max, i + 1);
                }
            }
        }

        return max;
    }
}