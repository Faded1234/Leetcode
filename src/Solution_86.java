import suanfa.LinkedList.ListNode;

/**
 * @description:
 * @author: gyw
 * @create: 2020-06-26 15:53
 **/
public class Solution_86 {
    public ListNode partition(ListNode head, int x) {
        //链表less记录小于x的元素
        ListNode less = new ListNode(0);
        ListNode ptr1 = less;
        //链表greatOrEqual记录大于等于x的元素
        ListNode greatOrEqual = new ListNode(0);
        ListNode ptr2 = greatOrEqual;
        while (head != null) {
            if (head.val < x) {
                ptr1.next = new ListNode(head.val);
                ptr1 = ptr1.next;
            } else {
                ptr2.next = new ListNode(head.val);
                ptr2 = ptr2.next;
            }
            head = head.next;
        }
        //拼接两段链表
        ptr1.next = greatOrEqual.next;
        return less.next;
    }
}
