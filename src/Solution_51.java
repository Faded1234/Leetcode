import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_51 {

    private static ArrayList<List<String>> list;

    /**
     * 这题的整体思想是建一个x[n]的数组，意为第i放第x[i]列放置皇后
     * 皇后的合法判断规则是列不相等，斜线上也不相等
     * i + x[i] == j + x[j] 表示正斜线一致
     * x[i] - i = x[j] - j 表示负斜线上一致  都不合法
     */
    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists.size());
    }
    public static List<List<String>> solveNQueens(int n) {
        list = new ArrayList<List<String>>();
        int[] x = new int[n];//保存结果
        queens(x, n, 0);
        return list;
    }

    static void queens(int[] x,int n,int row){
        for(int i = 0; i < n; i++){
            if(check(x,n,row,i)){//判断合法
                x[row] = i;//将皇后放在第row行，第i列
                if(row == n-1){//如果是最后一行，则输出结果
                    addList(x,n);
                    x[row] = 0;//回溯，寻找下一个结果
                    return;
                }
                queens(x, n, row+1);//寻找下一行
                x[row] = 0;//回溯
            }
        }
    }

    /**
     * 将每一组的结果添加list
     * @param x 数组解
     * @param n 棋盘长宽
     */
    private static void addList(int[] x,int n) {
        //添加结果
        String[][] sArr = new String[n][n];
        List<String> al = new ArrayList<String>();
        for(int i = 0; i < n ; i++){
            Arrays.fill(sArr[i], ".");//先填充.
            sArr[i][x[i]] = "Q";//特定位置放置Q
            String s = "";
            for(String str:sArr[i]){
                s += str;//加在一起
            }
            al.add(s);//添加一行
        }
        list.add(al);//添加一组解
    }

    /**
     * @param x 数组解
     * @param n 棋盘长宽
     * @param row 当前放置行
     * @param col 当前放置列
     * @return
     */
    static boolean check(int[] x,int n,int row, int col){
        for(int i = 0; i < row; i++){
            //因为行不相等，判断列是否相等，斜线上是否相等
            if(x[i] == col || x[i] + i == col + row || x[i] - i == col - row)
                return false;
        }
        return true;
    }
}
