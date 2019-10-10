package suanfa.Array;

import java.util.ArrayList;
import java.util.List;

public class Solution_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> iLists = new ArrayList<>();
        int n = intervals.length;
        if (n == 0) {
            iLists.add(newInterval);
            return iLists.toArray(new int[0][]);
        }
        int i;
        for (i = 0; i < n; i++) {
            if (intervals[i][1] >= newInterval[0])// 验证是否可能重合
                break;
            iLists.add(intervals[i]);
        }
        if (i == n) {// 循环到末尾了，并不是因可能重合而break的
            iLists.add(newInterval);
            return iLists.toArray(new int[0][]);
        }
        // break出来的
        if (intervals[i][0] > newInterval[1]) {// 并没有重合，简单插入即可
            iLists.add(newInterval);
        } else {// 重合了,处理所有重合
            int head = Math.min(newInterval[0], intervals[i][0]), tail = Math.max(newInterval[1], intervals[i][1]);
            i++;
            while (i < n && intervals[i][0] <= tail) {
                tail = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
            iLists.add(new int[] { head, tail });
        }
        while (i < n) {// 处理重合之后的
            iLists.add(intervals[i++]);
        }
        return iLists.toArray(new int[0][]);
    }
}
