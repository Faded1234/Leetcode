package suanfa.LinkedList;

import suanfa.LinkedList.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-09 16:41
 */
/*
给出一个链表，一次翻转 k 个指针节点，并返回修改后的链表。
        k 是一个正整数，并且小于等于链表的长度。如果指针节点的数量不是 k 的整数倍，那么最后剩余的节点应当保持原来的样子。
        你不应该改变节点的值，只有节点位置本身可能会改变。
        题目应当保证，仅使用恒定的内存。
        例如，
        给定这个链表：1->2->3->4->5
        当 k = 2时，应当返回: 2->1->4->3->5
        当 k = 3时，应当返回: 3->2->1->4->5
        学无止境，任重而道远。
*/
public class Solution_25 {
    public static void main(String[] args) {

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ////欢迎关注github https://github.com/Faded1234/Leetcode
        /*
        * 借鉴的别人的答案，思路是把连续k个数反转后插入到要输出的链表中
        * */
        ListNode pre =head;
        ListNode q = head;

        ListNode result = new ListNode(0); //存放结果
        result.next = head;
        ListNode reshead= result; //指向结果的头部

        int temp = 0; //存放节点总数
        while(q!=null){ //计算节点总数
            ++temp;
            q=q.next;
        }

        q = head;  //q存放要翻转的节点，pre指示q前面的节点
        int t; //每组翻转的次数
        while(k<=temp){
            t = k;
            ListNode remark = q;
            while(t>0){
                pre = q ;
                q = q.next;
                pre.next = result.next; //带头结点的头插法
                result.next = pre;
                t--;
            }
            remark.next = q;    //将每一部分连接起来
            result = remark;    //改变result，指向部分逆置的最后一个节点（就是下一次头插法的头节点）
            temp -=k;
        }
        return reshead.next;
    }
/*    public suanfa.LinkedList.ListNode reverseKGroup(suanfa.LinkedList.ListNode head, int k) {
        int n = 0;
        for (suanfa.LinkedList.ListNode i = head; i != null; n++, i = i.next);

        suanfa.LinkedList.ListNode dmy = new suanfa.LinkedList.ListNode(0);
        dmy.next = head;
        for(suanfa.LinkedList.ListNode prev = dmy, tail = head; n >= k; n -= k) {
            for (int i = 1; i < k; i++) {
                suanfa.LinkedList.ListNode next = tail.next.next;
                tail.next.next = prev.next;
                prev.next = tail.next;
                tail.next = next;
            }

            prev = tail;
            tail = tail.next;
        }
        return dmy.next;
    }*/
}
