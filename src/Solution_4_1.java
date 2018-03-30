import java.math.BigInteger;

/**
 * Created with IntelliJ IDEA.
 * User：by gyw
 * Date：2018/3/23
 * Time：22:51
 */
public class Solution_4_1 {
    public static void main(String[] args) {
        Solution_4_1 main = new Solution_4_1();
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
        BigInteger a=null;
        BigInteger b=null;

        StringBuffer t1=new StringBuffer();
        StringBuffer t2=new StringBuffer();
        ListNode node1=l1;
        while (node1!=null){
            t1.append(node1.val);
            node1=node1.next;
        }
        ListNode node2=l2;
        while (node2!=null){
            t2.append(node2.val);
            node2=node2.next;
        }

        StringBuffer x1 = t1.reverse();
        StringBuffer x2 = t2.reverse();

        a = new BigInteger(x1.toString());
        b = new BigInteger(x2.toString());

        BigInteger c = null;
        c=a.add(b);

        StringBuffer result = new StringBuffer(c.toString());
        StringBuffer reverse = result.reverse();

        char[] chars = result.toString().toCharArray();

        for (int i = 0; i <chars.length ; i++) {

            System.out.println(chars[i]);
        }

        ListNode no1=new ListNode(Integer.parseInt(String.valueOf(chars[0])));
        if(chars.length==1){
            return  no1;
        }
        ListNode no2=new ListNode(2);
        no1.next=no2;
        for (int i=1;i<chars.length;i++){
            no2.val=Integer.parseInt(String.valueOf(chars[i]));
            if(i<chars.length-1){
                no2.next=new ListNode(1);
            }
            no2=no2.next;
        }

        return no1;
    }
}
