import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-05-13 15:45
 [['5','3','.','.','7','.','.','.','.']
 ,['6','.','.','1','9','5','.','.','.']
 ,['.','9','8','.','.','.','.','6','.']
 ,['8','.','.','.','6','.','.','.','3']
 ,['4','.','.','8','.','3','.','.','1']
 ,['7','.','.','.','2','.','.','.','6']
 ,['.','6','.','.','.','.','2','8','.']
 ,['.','.','.','4','1','9','.','.','5']
 ,['.','.','.','.','8','.','.','7','9']]

 */
public class Solution_36 {
    public static void main(String[] args) {
        char[][] chars = {{'5','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'}, {'.','9','8','.','.','.','.','6','.'}, {'8','.','.','.','6','.','.','.','3'}, {'4','.','.','8','.','3','.','.','1'}, {'7','.','.','.','2','.','.','.','6'}, {'.','6','.','.','.','.','2','8','.'}, {'.','.','.','4','1','9','.','.','5'}, {'.','.','.','.','8','.','.','7','9'}};
        boolean validSudoku = isValidSudoku(chars);
        System.out.println(validSudoku);

    }
    public static boolean isValidSudoku(char[][] board) {
        Map map ;
        for (int i = 0; i < board.length; i++) {
            map= new HashMap();
            for (int j = 0; j < 9; j++) {
                Object o = map.get(board[i][j]);
                if (o!=null){
                    return false;
                }else {
                    if (board[i][j]=='.'){
                        continue;
                    }
                    map.put(board[i][j],i+j);
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            map= new HashMap();
            for (int j = 0; j < 9; j++) {
                Object o = map.get(board[j][i]);
                if (o!=null){
                    return false;
                }else {
                    if (board[j][i]=='.'){
                        continue;
                    }
                    map.put(board[j][i],j+i);
                }
            }
        }
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        Map map3 = new HashMap();
        for (int i = 0; i < 9; i++) {
            if(i%3==0||i==0){
                map1= new HashMap();
                map2= new HashMap();
                map3= new HashMap();
            }
            for (int j = 0; j < 9; j++) {
                if(j<3){
                    Object o1 = map1.get(board[i][j]);
                    if (o1!=null){
                        return false;
                    }else {
                        if (board[i][j]=='.'){
                            continue;
                        }
                        map1.put(board[i][j],i+j);
                        continue;
                    }
                }
                if(j<6){
                    Object o1 = map2.get(board[i][j]);
                    if (o1!=null){
                        return false;
                    }else {
                        if (board[i][j]=='.'){
                            continue;
                        }
                        map2.put(board[i][j],i+j);
                        continue;
                    }
                }
                if(j<9){
                    Object o1 = map3.get(board[i][j]);
                    if (o1!=null){
                        return false;
                    }else {
                        if (board[i][j]=='.'){
                            continue;
                        }
                        map3.put(board[i][j],i+j);
                    }
                }
            }
        }
        return true;
    }
}
