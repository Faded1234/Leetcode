package solutionPage1;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-05-13 21:51
 */
class Solution_37_1 {
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
        if (board == null || board.length == 0)
            return;
        dfs(board);
    }
    // 也是按照行进行放置，只不过n后问题每行只放一个Q，不重复放置，是一层循环
    // 而此题需要放置多个数字，还不能重复,所以是一个三层循环
    private static boolean dfs(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        // 尝试
                        if (validate(board, i, j, num)) {
                            board[i][j] = num;
                            if (dfs(board))
                                return true;
                            else// 回溯
                                board[i][j] = '.';
                        }
                    }
                    // 如果对一个格子尝试从0~9都不行，
                    // 那么说明整个sudoku无解，返回false
                    return false;
                }
            }
        }

        // 对整个棋盘所有'.'都填完了，那么就可以返回true了。
        return true;
    }

    // 通常验证函数需要单独解耦合
    private static boolean validate(char[][] board, int i, int j, char c) {
        // check column（列）
        for (int row = 0; row < 9; row++)
            if (board[row][j] == c)
                return false;

        // check row（行）
        for (int col = 0; col < 9; col++)
            if (board[i][col] == c)
                return false;

        // check cube(小九宫格)
        int rIdx = i / 3 * 3;
        int cIdx = j / 3 * 3;
        for (int row = rIdx; row < rIdx + 3; row++)
            for (int col = cIdx; col < cIdx + 3; col++)
                if (board[row][col] == c)
                    return false;

        return true;
    }
}
