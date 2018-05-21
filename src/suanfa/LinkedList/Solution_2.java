package suanfa.LinkedList;


/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-08 12:21
 */
public class Solution_2 {
    public static void main(String[] args) {
        Solution_2 main = new Solution_2();     //测试数据
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        listNode1.next = listNode2;

        ListNode listNode11 = new ListNode(5);
        ListNode listNode22 = new ListNode(6);
        ListNode listNode33 = new ListNode(4);
        listNode22.next = listNode33;
        listNode11.next = listNode22;
        ListNode listNode = addTwoNumbers(listNode1, listNode11);
        System.out.println(listNode);
        System.out.println();
    }
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }
            int carry = 0;
            ListNode node = new ListNode(-1);
            ListNode head = node;
            while (l1 != null || l2 != null) {
                int sum = carry;
                if (l1 != null) {
                    sum+=l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum+= l2.val;
                    l2 = l2.next;
                }
                carry = sum / 10;
                sum = sum % 10;
                node.next = new ListNode(sum);
                node = node.next;
            }
            if (carry !=0) {
                node.next = new ListNode(1);
            }
            return head.next;
    }
}
