class Solution {
    public ArrayList<ArrayList<Integer>> multiply(int[][] mat1, int[][] mat2) {
        int n = mat1.length;
                int m = mat2.length;
                int p = mat2[0].length;

                ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    ArrayList<Integer> row = new ArrayList<>();

                    for (int j = 0; j < p; j++) {
                        int sum = 0;

                        for (int k = 0; k < m; k++) {
                            sum += mat1[i][k] * mat2[k][j];
                        }

                        row.add(sum);
                    }

                    ans.add(row);
                }

                return ans;
    }
}