package algorithm.nhn202106.inflearn.linkedList;

public class AddTwoNumbers {

    private class ListNode{
        int val;
        ListNode next;

        ListNode(int x){
            this.val = x;
        }
    }

    public static void main(String[] args) {
        new AddTwoNumbers().solve();
    }

    private void solve() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(2);

        ListNode node = getAnswer(l1, l2);
    }

    private ListNode getAnswer(ListNode l1, ListNode l2){
        return null;
    }
}
