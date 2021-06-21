package week1;

public class L641_DesignCircularDeque {
    public static void main(String[] args) {
        MyCircularDeque circularDeque = new L641_DesignCircularDeque().new MyCircularDeque(3);
        System.out.println(circularDeque.insertLast(1));                    // 返回 true
        System.out.println(circularDeque.insertLast(2));                    // 返回 true
        System.out.println(circularDeque.insertFront(3));                    // 返回 true
        System.out.println(circularDeque.insertFront(4));                    // 已经满了，返回 false
        System.out.println(circularDeque.getRear());                // 返回 2
        System.out.println(circularDeque.isFull());                        // 返回 true
        System.out.println(circularDeque.deleteLast());                    // 返回 true
        System.out.println(circularDeque.insertFront(4));                    // 返回 true
        System.out.println(circularDeque.getFront());                // 返回 4
    }

    class MyCircularDeque {

        private int length = 0;

        private int size = 0;

        private DoubleListNode head;

        private DoubleListNode tail;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            this.length = k;
            this.head = new DoubleListNode(-1);
            this.tail = new DoubleListNode(-1);
            this.head.next = this.tail;
            this.tail.pre = this.head;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (this.size == this.length) {
                return false;
            }
            final DoubleListNode listNode = new DoubleListNode(value);
            final DoubleListNode next = head.next;
            next.pre = listNode;
            listNode.pre = head;
            listNode.next = next;
            head.next = listNode;
            size++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (this.size == this.length) {
                return false;
            }
            final DoubleListNode listNode = new DoubleListNode(value);
            final DoubleListNode pre = tail.pre;
            pre.next = listNode;
            listNode.pre = pre;
            listNode.next = tail;
            tail.pre = listNode;
            size++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (size == 0) {
                return false;
            }
            head.next = head.next.next;
            head.next.pre = head;
            size--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (size == 0) {
                return false;
            }
            tail.pre = tail.pre.pre;
            tail.pre.next = tail;
            size--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (size == 0) {
                return -1;
            }
            return head.next.val;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (size == 0) {
                return -1;
            }
            return tail.pre.val;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return this.size == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return this.size == this.length;
        }


        class DoubleListNode {
            public int val;
            public DoubleListNode pre;
            public DoubleListNode next;

            public DoubleListNode(int val) {
                this.val = val;
            }
        }
    }
}