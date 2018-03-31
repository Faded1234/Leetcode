import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/23
 * Time：22:51
 * 给定两个非空链表来代表两个非负数，位数按照逆序方式存储，它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。

 *你可以假设除了数字 0 之外，这两个数字都不会以零开头。

 *示例：

 *输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *输出：7 -> 0 -> 8
 *原因：342 + 465 = 807
 */
public class Solution_2_1 {
    public static void main(String[] args) {
        Solution_2_1 main = new Solution_2_1();     //测试数据
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
        ListNode listNode = main.addTwoNumbers(listNode1, listNode11);
        System.out.println(listNode);

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger a=null;             //考虑到测试的链表可能会超过int类型所以此处采用大整数
        BigInteger b=null;

        StringBuffer t1=new StringBuffer();     //采用StringBuffer 也是对String的优化同时Stringbuffer内有反转的API
        StringBuffer t2=new StringBuffer();
        ListNode node1=l1;
        while (node1!=null){
            t1.append(node1.val);       //将l1的数字保存到t1中
            node1=node1.next;
        }
        ListNode node2=l2;
        while (node2!=null){
            t2.append(node2.val);       //将l2的数字保存到t2中
            node2=node2.next;
        }

        StringBuffer x1 = t1.reverse();     //反转
        StringBuffer x2 = t2.reverse();

        a = new BigInteger(x1.toString());      //将字符串转为大整数
        b = new BigInteger(x2.toString());

        BigInteger c = null;
        c=a.add(b);                         //相加

        StringBuffer result = new StringBuffer(c.toString());   //将结果再次转为字符串
        StringBuffer reverse = result.reverse();                //反转

        char[] chars = result.toString().toCharArray();         //反转后的结果保存的char中

        for (int i = 0; i <chars.length ; i++) {

            System.out.println(chars[i]);
        }

        ListNode no1=new ListNode(Integer.parseInt(String.valueOf(chars[0])));  //头结点
        if(chars.length==1){        //特殊情况，如果只有一个数字则直接返回结果
            return  no1;
        }
        ListNode no2=new ListNode(2);       //第二个节点，随便一个数字初始化
        no1.next=no2;                           //指向第二个节点
        for (int i=1;i<chars.length;i++){       //循环初始化其它节点 值得注意的是如果没有第二个节点的话我们最后只能返回
            no2.val=Integer.parseInt(String.valueOf(chars[i]));     //头节点但是我们的头结点在循环赋值的时候是一直在变的
            if(i<chars.length-1){                                       //所以可以再用一个中间节点
                no2.next=new ListNode(1);
            }
            no2=no2.next;
        }

        return no1;
    }
}
