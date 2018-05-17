import suanfa.LinkedList.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-08 10:56
 */
/*合并两个已排序的链表，并将其作为一个新列表返回。新列表应该通过拼接前两个列表的节点来完成。

        示例：

        输入：1->2->4, 1->3->4
        输出：1->1->2->3->4->4*/
public class Solution_21 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(1);
        ListNode l5=new ListNode(2);
        l2.next=l3;
        l1.next=l2;
        l4.next=l5;
        ListNode node = mergeTwoLists(l1, l4);
        System.out.println(node);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //欢迎关注github https://github.com/Faded1234/Leetcode
        /*这是我自己写的如果觉得逻辑不是很清楚可以看下一个方法*/
        ListNode head=new ListNode(0);
        ListNode node=head;
        int val1=0;
        int val2=0;
        while (l1!=null||l2!=null){
            if(l1!=null){
                val1=l1.val;
            } else{
                node.next=l2;
                break;
            }
            if(l2!=null){
                val2=l2.val;
            } else{
                node.next=l1;
                break;
            }
            if(val1<val2){
                node.next=l1;
                l1=l1.next;
            } else{
                node.next=l2;
                l2=l2.next;
            }
            node=node.next;
        }
        return head.next;
    }
}
