import java.awt.*;

public class Main {


    public static void main(String[] args) {

        ListNode list1 = makeList(243L);
        ListNode list2 = makeList(564L);
        ListNode ans = addTwoNumbers(list1, list2);
        //display the answer
        while(ans != null){
            System.out.print(ans.val);
            ans = ans.next;
        }
    }

    /**
     * solution
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return sumList(l1, l2, 0);
    }

    /**
     * The recursive solution solver
     * @param l1
     * @param l2
     * @param offSet
     * @return
     */
    public static ListNode sumList(ListNode l1, ListNode l2, int offSet){
        int value = 0;
        if(l1 != null && l2 != null){
            value = l1.val + l2.val + offSet;
            if(value < 10){
                return new ListNode(value, sumList(l1.next, l2.next, 0));
            }
            else return new ListNode(value%10, sumList(l1.next, l2.next, 1));
        }
        else if(l1 != null && l2 == null){
            value = l1.val + offSet;
            if(value < 10){
                return new ListNode(value, sumList(l1.next, null, 0));
            }
            else return new ListNode(value%10, sumList(l1.next, null, 1));
        }
        else if(l1 == null && l2 != null){
            value = l2.val + offSet;
            if(value < 10){
                return new ListNode(value, sumList(null, l2.next, 0));
            }
            else return new ListNode(value%10, sumList(null, l2.next, 1));
        }
        else{
            if(offSet == 0) return null;
            else return new ListNode(1);
        }
    }

    /**
     * Helper method to help me build the input lists
     * @param sum
     * @return
     */
    public static ListNode makeList(Long sum){
        if(sum < 10) return new ListNode(sum.intValue());
        return new ListNode((int)(sum%10), makeList(sum/10));
    }

    /**
     * ListNode data structure provided in the problem
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }

}