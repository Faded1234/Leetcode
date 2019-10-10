
public class Solution_61 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        Solution_61 solution_61 = new Solution_61();
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        solution_61.rotateRight(listNode1,2);
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0)
            return head;
        // 新建一个结点，利于操作
        ListNode tmpHead = new ListNode(0);
        tmpHead.next = head;
        // 使用快慢指针，计算倒数节点数目
        ListNode fast = tmpHead;
        ListNode slow = tmpHead;
        int len = 0;
        // 计算链表长度
        while (slow.next != null) {
            len++;
            slow = slow.next;

        }
        slow = tmpHead;
        // 关键，记录k 的有效长度，输入会有k大于链表长度值
        k = (len + (k % len)) % len;
        // 不需要翻转
        if (k == 0)
            return tmpHead.next;
        // 快指针先走k步
        while (--k >= 0)
            fast = fast.next;
        // 一起走
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 重新链接链表，注意置空
        tmpHead.next = slow.next;
        fast.next = head;
        System.out.println();
        slow.next = null;
        return tmpHead.next;

        /*if(k==0)
            return head;
        if(head==null)
            return head;
        int length=1;
        ListNode cur=head;
        while(cur.next!=null)
        {
            cur=cur.next;
            length++;
        }
        cur.next=head;//已经把链表首尾相接的连上了
        int m=length-k%length;//这个是算法的关键，找到应该在何处断开
        for(int i=0;i<m;i++)
        {
            cur=cur.next;
        }
        ListNode newhead=cur.next;//获得新的链表头节点
        cur.next=null;//断开链表环
        return newhead;*/
    }


}
