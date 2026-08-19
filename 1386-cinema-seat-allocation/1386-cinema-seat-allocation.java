class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int groups = 0;

        Set<String> set = new HashSet<>();
        Set<Integer> rows = new HashSet<>();

        int len = reservedSeats.length;

        for (int i = 0; i < len; i++) {
            int r = reservedSeats[i][0];
            int c = reservedSeats[i][1];

            set.add(r + "," + c);
            rows.add(r);
        }

        // Jitni rows mein koi reservation nahi hai,
        // unmein automatically 2 groups
        groups = (n - rows.size()) * 2;

        // Sirf reserved rows check karo
        for (int row : rows) {

            boolean left = !set.contains(row + ",2") &&
                           !set.contains(row + ",3") &&
                           !set.contains(row + ",4") &&
                           !set.contains(row + ",5");

            boolean right = !set.contains(row + ",6") &&
                            !set.contains(row + ",7") &&
                            !set.contains(row + ",8") &&
                            !set.contains(row + ",9");

            boolean middle = !set.contains(row + ",4") &&
                             !set.contains(row + ",5") &&
                             !set.contains(row + ",6") &&
                             !set.contains(row + ",7");

            if (left && right) {
                groups += 2;
            }
            else if (left || middle || right) {
                groups++;
            }
        }

        return groups;
    }
}