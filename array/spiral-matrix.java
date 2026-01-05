class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        int iter = 0;

        while (result.size() < m * n) {

            // top row
            for (int i = iter; i < n - iter && result.size() < m * n; i++) {
                result.add(matrix[iter][i]);
            }

            // right column
            for (int j = iter + 1; j < m - iter && result.size() < m * n; j++) {
                result.add(matrix[j][n - 1 - iter]);
            }

            // bottom row
            for (int k = n - 2 - iter; k >= iter && result.size() < m * n; k--) {
                result.add(matrix[m - 1 - iter][k]);
            }

            // left column
            for (int l = m - 2 - iter; l > iter && result.size() < m * n; l--) {
                result.add(matrix[l][iter]);
            }

            iter++;
        }

        return result;
    }
}
