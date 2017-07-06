public class NumMatrix {
	int[][] matrix;
	int[] bit;

    public NumMatrix(int[][] matrix) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return;
    	bit = new int[matrix.length * matrix[0].length + 1];
    	for(int i = 0; i < matrix.length; i++) {
    		for(int j = 0; j < matrix[0].length; j++) {
    			int idx = i * matrix[0].length + j + 1;
    			while(idx < bit.length) {
    				bit[idx] += matrix[i][j];
    				idx += idx & (-idx);
    			}
    		}
    	}
        this.matrix = matrix;
    }
    
    public void update(int row, int col, int val) {
        if(matrix.length < 1) return;
        int idx = row * matrix[0].length + col + 1;
        while(idx < bit.length) {
        	bit[idx] += val - matrix[row][col];
        	idx += idx & (-idx);
        }
        matrix[row][col] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(matrix.length < 1) return 0;
    	int sum = 0;
        for ( int i = row1; i <= row2 ; i++ ) {
        	int idx1 = i * matrix[0].length + col1;
        	int idx2 = i * matrix[0].length + col2 + 1;
        	while(idx1 > 0) {
        		sum -= bit[idx1];
        		idx1 -= idx1 & (-idx1);
        	}
        	while(idx2 > 0) {
        		sum += bit[idx2];
        		idx2 -= idx2 & (-idx2);
        	}
        }
        return sum;
    }
}


/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */

public class NumMatrix {
	int[][] matrix;
	int[][] bit;

    public NumMatrix(int[][] matrix) {
    	bit = new int[matrix.length + 1][matrix[0].length + 1];
        for ( int i = 0; i < matrix.length; i++ ) {
        	for ( int j = 0; j < matrix[0].length ; j++) {
        		int idx1 = i + 1;
        		int idx2 = j + 1;
        		while( idx1 < bit.length && idx2 < bit[0].length ) {
        			bit[idx1][idx2] += matrix[i][j];
        			idx1 += idx1 & (-idx1);
        			idx2 += idx2 & (-idx2);
         		}
        	}
        }
        this.matrix = matrix;
    }
    
    public void update(int row, int col, int val) {
    	int idx1 = row + 1;
    	int idx2 = col + 1;
		while( idx1 < bit.length && idx2 < bit[0].length ) {
			bit[idx1][idx2] += val - matrix[row][col];
			idx1 += idx1 & (-idx1);
			idx2 += idx2 & (-idx2);
 		}
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        int idx1, idx2;

        idx1 = row2 + 1;
        idx2 = col2 + 1;

        while( idx1 > 0 || idx2 > 0) {
        	sum += bit[idx1][idx2];
        	idx1 -= idx1 & (-idx1);
        	idx2 -= idx2 & (-idx2);
        }

        idx1 = row1;
        idx2 = col1;

        while( idx1 > 0 || idx2 > 0) {
        	sum -= bit[idx1][idx2];
        	idx1 -= idx1 & (-idx1);
        	idx2 -= idx2 & (-idx2);
        }

        return sum;
    }
}
//have bug, need fix

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */