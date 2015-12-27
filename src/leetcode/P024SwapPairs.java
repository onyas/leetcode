package leetcode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * <p/>
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 15/11/9
 * Time: 下午8:14
 */
public class P024SwapPairs {


    /**
     * change the value
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode result = head;

        ListNode odd = head.next;
        while (head != null && odd != null) {
            int current = head.val;
            head.val = odd.val;
            odd.val = current;
            head = odd.next;
            if (head != null) {
                odd = head.next;
            }
        }
        return result;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
