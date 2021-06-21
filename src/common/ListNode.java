package common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
    public static ListNode of(int... args) {
        ListNode dummy = new ListNode(-1);
        ListNode l = dummy;
        for (int arg : args) {
            l.next = new ListNode(arg);
            l = l.next;
        }
        return dummy.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        sb.append(this.val);
        ListNode n = this.next;
        while(n!=null){
            sb.append(",").append(n.val);
            n = n.next;
        }
        sb.append("}");
        return sb.toString();
    }
}