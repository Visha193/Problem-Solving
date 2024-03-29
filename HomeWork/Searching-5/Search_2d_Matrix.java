public class Search_2d_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
        return false;
        int h = matrix.length;
        int w = matrix[0].length;
        int row = 0, col = w - 1;
        while(row < h && col >= 0){
            int temp = matrix[row][col];
            if(temp == target) return true;
            else if(temp < target)
                row++;
            else
                col--;
        }
        return false;
    }
}
