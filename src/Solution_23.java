import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018-04-08 18:12
 */
/*合并含有K个元素的有序链表，并且作为一个有序链表的形式返回。分析并描述它的复杂度。
* 解读题意，是我读题大意了，我以为只是单纯合并有序的单个节点，结果是链表，说明每个要合并的链表都可能有n个长度
* */
public class Solution_23 {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(0);
        ListNode l3=null;
        ListNode l5=new ListNode(5);
        ListNode[] lists = new ListNode[]{l1,l2,l3,l5};
        ListNode node = mergeKLists(lists);
        System.out.println(node);
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        //欢迎关注github https://github.com/Faded1234/Leetcode
        //这个和21题的合并两个有序链表相似
        if (lists==null||lists.length==0){
            return null;
        }
        return work(lists,0,lists.length-1);
    }
    //利用归并排序的思想
    private static ListNode work(ListNode[] lists, int left, int right) {
        int mid = (left+right)/2;
        if (left<right){
            ListNode l1 = work(lists, left, mid);
            ListNode l2 = work(lists, mid + 1, right);
            return mergeTwo(l1,l2);
        }
        return lists[left]; //如果left==right则直接返回左面的链表
    }

    private static ListNode mergeTwo(ListNode l1, ListNode l2) {
        if(l1==null){
            return  l2;
        }
        if (l2==null){
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwo(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwo(l2.next, l1);
            return l2;
        }
    }

}
