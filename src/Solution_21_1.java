import suanfa.LinkedList.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-08 16:17
 */
public class Solution_21_1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        Stack s =new Stack();
        Object push = s.push(12);
        List<Integer> List = new ArrayList<Integer>();
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
}
