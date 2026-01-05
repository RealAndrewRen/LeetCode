class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<Integer>();
        int iter = 0;
        while (result.size() < m * n){
            for (int i = iter; i < n - iter && result.size() < m * n; i++){
                result.add(matrix[iter][i]);
            }
            for (int j = iter; j < m - iter && result.size() < m * n; j++){
                result.add(matrix[j][n - iter - 1]);
            }
            for (int k = n - 1 - iter; k >= iter && result.size() < m * n; k--){
                result.add(matrix[n - 1 - iter][k]);
            }
            for (int l = m - 1 - iter; l > iter && result.size() < m * n; l--){
                result.add(matrix[l][m - 1 - iter]);
            }
            iter++;
        }
        return result; 
    }
}
