package solutionPage1;

import suanfa.LinkedList.ListNode;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-09 15:49
 */
/*
给定一个链表，对每两个相邻的结点作交换并返回头节点。

        例如：
        给定 1->2->3->4，你应该返回 2->1->4->3。

        你的算法应该只使用额外的常数空间。不要修改列表中的值，只有节点本身可以​​更改。
*/
public class Solution_24 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        /*listNode5.next = listNode6;*/
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        ListNode node = swapPairs1(listNode1);
        System.out.println(node);
    }
    public static ListNode swapPairs(ListNode head) {
        //欢迎关注github https://github.com/Faded1234/Leetcode
        //后来想想这种方法貌似不符合题意，奈何通过了测试，详情看下一个代码
        ListNode node = head;
        if (node==null){
            return null;
        }       //当head为空时直接返回null
        if (node.next==null){
            return node;        //当head的长度为1时返回head本身
        }
        if (node.next.next==null){  //当长度为二时反转后返回   之所以那么麻烦的列举前三种可能是因为在while循环中每次交换相邻两个后head要变为下下一个
            int a = node.val;       //所以要排除掉长度小于三的
            int b = node.next.val;
            node.val=b;
            node.next.val=a;
        }else {
            while (head.next!=null){
                int a = head.val;
                int b = head.next.val;
                head.val=b;
                head.next.val=a;

                if (head.next.next!=null){
                    head=head.next.next;
                }else {
                    break;
                }

            }
        }

        return node;
    }

    public static ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode pre = start;
        while(head!=null && head.next!=null){
            pre.next = head.next;
            head.next = pre.next.next;
            pre.next.next = head;
            /*
            *   head     1  2  3  4  5
            *   start 0  1  2  3  4  5
            *   pre   0  1  2  3  4  5
            *
            * 前三步
            * 第一步  pre.next = head.next;
            *   head     1  2  3  4  5
            *   start 0  2  3  4  5
            *   pre   0  2  3  4  5
            * 第二步  head.next = pre.next.next;
            *   head     1  3  4  5
            *   start 0  2  3  4  5
            *   pre   0  2  3  4  5
             * 第三步  pre.next.next = head;
             *   head     3  4  5
             *   start 0  2  1  3  4  5
             *   pre   0  2  1  3  4  5
            * */

            pre = pre.next.next;
            /*
             * 第四步  pre.next.next = head;
             *   head     3  4  5
             *   start 0  2  1  3  4  5
             *   pre   1  3  4  5
             *
            * */
            head = pre.next;
            /*
             * 第五步  head = pre.next;
             *   head  3  4  5
             *   start 0  2  1  3  4  5
             *   pre   1  3  4  5
             *
             * */
        }
        return start.next;
    }

}
