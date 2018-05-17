package suanfa.LinkedList;

import suanfa.LinkedList.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-07 15:21
 * 欢迎关注github https://github.com/Faded1234/Leetcode
 *
 给定一个链表，删除链表的倒数第 n 个节点并返回头结点。

 例如，

 给定一个链表: 1->2->3->4->5, 并且 n = 2.

 当删除了倒数第二个节点后链表变成了 1->2->3->5.


 说明:

 给的 n 始终是有效的。

 尝试一次遍历实现。
 */
public class Solution_19 {
    public static void main(String[] args) {
    ListNode l1=new ListNode(1);
    ListNode l2=new ListNode(2);
    ListNode l3=new ListNode(3);
    ListNode l4=new ListNode(4);
    ListNode l5=new ListNode(5);
    l4.next=l5;
    l3.next=l4;
    l2.next=l3;
    l1.next=l2;
    removeNthFromEnd(l1,2);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
/*        利用快慢指针
        如果我们获得最后一个节点，那么到最后一个节点的距离为n的就是我们所要删去的节点。
        我们可以使用快慢节点。快慢节点之间的距离始终是n。
        当快节点到达终点时，此时的慢节点就是所要删去的节点。*/
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start;
        ListNode fast = start;

        for(int i = 0 ; i<n+1 ; i++){
            fast = fast.next;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next; //因为是引用所以对slow的修改也是对head的修改
        return start.next;
    }
}
