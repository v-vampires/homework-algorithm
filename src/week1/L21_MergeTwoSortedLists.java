package week1;

import common.ListNode;

public class L21_MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new L21_MergeTwoSortedLists().new Solution();
        System.out.println(solution.mergeTwoLists(ListNode.of(1, 2, 4), ListNode.of(1, 3, 4)));
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode r = new ListNode(-1);
            ListNode cur = r;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            if (l1 != null) {
                cur.next = l1;
            }
            if (l2 != null) {
                cur.next = l2;
            }
            return r.next;
        }
    }

}