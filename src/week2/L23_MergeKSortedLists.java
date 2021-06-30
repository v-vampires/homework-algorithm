package week2;

import common.ListNode;


public class L23_MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new L23_MergeKSortedLists().new Solution();
        System.out.println(solution.mergeKLists(new ListNode[]{ListNode.of(1, 4, 5), ListNode.of(1, 3, 4), ListNode.of(2, 6)}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {


        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            return mergeKLists(lists, 0, lists.length - 1);
        }

        public ListNode mergeKLists(ListNode[] lists, int start, int end) {
            if (start == end) {
                return lists[start];
            }
            int mid = start + (end - start) / 2;
            ListNode a = mergeKLists(lists, start, mid);
            ListNode b = mergeKLists(lists, mid+1, end);
            return mergeTwoNode(a, b);
        }

        private ListNode mergeTwoNode(ListNode a, ListNode b) {
            ListNode res = new ListNode(-1);
            ListNode tail = res;
            while (a != null && b != null) {
                if (a.val < b.val) {
                    tail.next = a;
                    a = a.next;
                } else {
                    tail.next = b;
                    b = b.next;
                }
                tail = tail.next;
            }
            if (a != null) {
                tail.next = a;
            } else {
                tail.next = b;
            }
            return res.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}