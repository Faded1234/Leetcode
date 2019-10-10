package suanfa.Array;

public class Solution_59 {
    public static void main(String[] args) {
        Solution_59 solution_59 = new Solution_59();
        int[][] ints = solution_59.generateMatrix(4);
        System.out.println(ints);
    }
    public int[][] generateMatrix(int n) {
        int nums = 0;
        int[][] matrix = new int[n][n];
        if(n%2==0){
            nums = n/2;
        }else {
            nums = n/2+1;
        }
        int count = 1;
        for (int i = 0; i < nums; i++) {
            for (int j = 0; j < n-2*i; j++) {
                matrix[i][j+i] = count;
                count++;
            }
            if(count>n*n) break;
            for (int j = 0; j < n-2*i -2; j++) {
                matrix[i+j+1][n-i-1] = count;
                count++;
            }
            for (int j = n-2*i; j > 0 ; j--) {
                matrix[n-i-1][j-1+i] = count;
                count++;
            }
            for (int j = n-2*i -2; j > 0 ; j--) {
                matrix[j+i][i] = count;
                count++;
            }
        }
        return matrix;
    }
}
