/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-05-13 18:59
 */
public class Solution_37 {
    public static void main(String[] args) {
        char[][] input = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'9','8','.','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(input);
    }
    public static void solveSudoku(char[][] board) {
        solve(board);
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean solve(char[][] board){
        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j] == '.'){
                    for(char m = '1';m<='9';m++){                        //给'.'的位置按顺序赋1-9的值
                        board[i][j] = m;
                        if(isValid(board,i,j)&&solve(board)){           //检查赋值后的矩阵是否合法，并迭代检查到最后是否合法
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board, int row ,int col){    //看是否在同行同列同九个格中有相同的值
        for(int i = 0;i<9;i++){
            if(i != row && board[i][col] == board[row][col]){
                return false;
            }
        }
        for(int i = 0;i<9;i++){
            if(i!=col && board[row][i] == board[row][col]){
                return false;
            }
        }
        int beginRow = 3*(row/3);
        int beginCol = 3*(col/3);
        for(int i = beginRow;i<beginRow+3;i++){
            for(int j = beginCol;j<beginCol+3;j++){
                if(i!=row&&j!=col&&board[i][j] == board[row][col]){ //只需要保证新插入的和之前的九宫格没有冲突就能保证
                    return false;
                }
            }
        }
        return true;
    }
}
