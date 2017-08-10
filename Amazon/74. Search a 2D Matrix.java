public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length < 1 || matrix[0].length < 1) return false;
        int row = searchRow(matrix, target);
        if(row == -1) return false;
        return searchCol(matrix, target, row);
    }
    
    private int searchRow(int[][] matrix, int target) {
        if(matrix.length == 1) {
            if(matrix[0][0] <= target && matrix[0][matrix[0].length-1] >= target)
                return 0;
            else
                return -1;
        }
        int p = 0;
        int q = matrix.length - 1;
        int mid = (p + q) / 2;
        while(p <= q) {
            mid = (p + q) / 2;
            if(matrix[mid][0] <= target && ((mid + 1 == matrix.length) || matrix[mid+1][0] > target))
                return mid;
            else if(matrix[mid][0] > target)
                q = mid - 1;
            else
                p = mid + 1;
        }
        return -1;
    }
    
    private boolean searchCol(int[][] matrix, int target, int row) {
        int p = 0;
        int q = matrix[row].length - 1;
        int mid = (p + q) / 2;
        while(p <= q) {
            mid = (p + q) / 2;
            if(matrix[row][mid] == target)
                return true;
            else if(matrix[row][mid] > target)
                q = mid - 1;
            else
                p = mid + 1;
        }
        return false;
    }
}