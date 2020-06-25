package solutionPage2;

public class Solution_52 {

    private int count = 0;
    private int len = 0;
    public int totalNQueens(int n) {
        if(n < 0){
            return count;
        }
        len = n;
        toQueen(0,0,0,0);
        return  count;
    }
    public void toQueen(int row, int col, int pie, int na){
        if(row >= len){
            count++;
            return;
        }
        int bits = (~(col|pie|na))&((1<<len)-1);
        while(bits > 0){
            int p = bits & -bits;
            toQueen(row+1, col|p,(pie|p)<<1,(na|p)>>1);
            bits = bits&(bits-1);
        }
    }
}
