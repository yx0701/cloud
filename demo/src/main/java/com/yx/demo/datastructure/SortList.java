package com.yx.demo.datastructure;

public class SortList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //在O(n log n)的时间内使用常数级空间复杂度对链表进行排序。
    //归并
    public ListNode sortList(ListNode head) {
        //采用归并排序
        if (head == null || head.next == null) {
            return head;
        }
        //获取中间结点
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        //合并
        return mergeSort(sortList(head), sortList(right));
    }

    /**
     * 获取链表的中间结点,偶数时取中间第一个
     *
     * @param head
     * @return
     */
    private ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针
        ListNode slow = head, quick = head;
        //快2步，慢一步
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    /**
     * 归并两个有序的链表
     *
     * @param left
     * @param right
     * @return
     */
    public ListNode mergeSort(ListNode left, ListNode right) {
        ListNode head;
        if (left.val < right.val) {
            head = left;
            left = left.next;
        } else {
            head = right;
            right = right.next;
        }
        ListNode p = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
                p = p.next;
            } else {
                p.next = right;
                right = right.next;
                p = p.next;
            }
        }
        if (left == null) {
            p.next = right;
        }
        if (right == null) {
            p.next = left;
        }
        return head;
    }

    //快排
    public ListNode sortList2(ListNode head) {
        //采用快速排序
        quickSort(head, null);
        return head;
    }

    public void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode node = partition(head, end);
            quickSort(head, node);
            quickSort(head.next, end);
        }
    }

    public ListNode partition(ListNode head, ListNode end) {
        ListNode p1 = head;
        ListNode p2 = head.next;
        //走到末尾才停
        while (p2 != end) {
            //大于key值时，p1向前走一步，交换p1与p2的值
            if (p1.val > p2.val) {
                p1 = p1.next;
                int tmp = p1.val;
                p1.val = p2.val;
                p2.val = tmp;
            }
            p2 = p2.next;
        }
        //当有序时，不交换p1和key值
        if (p1 != head) {
            int tmp = p1.val;
            p1.val = head.val;
            head.val = tmp;
        }
        return p1;

    }

    /*
    将给定的单链表L： L 0→L 1→…→L n-1→L n,
    重新排序为： L 0→L n →L 1→L n-1→L 2→L n-2→…
    要求使用原地算法，并且不改变节点的值
    例如：
    对于给定的单链表{1,2,3,4}，将其重新排序为{1,4,2,3}.
    */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode mid = getMid(head);
        ListNode head2 = mid.next;
        mid.next = null;

        ListNode pre = null;
        ListNode next = null;
        while (head2 != null) {
            next = head2.next;
            head2.next = pre;
            pre = head2;
            head2 = next;
        }

        boolean flag = true;
        ListNode newHead = head;
        ListNode cur = head;
        head = head.next;
        while (pre != null || head != null) {

            if (flag) {
                cur.next = pre;
                cur = cur.next;
                pre = pre.next;
                flag = false;
            } else {
                cur.next = head;
                cur = cur.next;
                head = head.next;
                flag = true;
            }
        }
        head = newHead;
    }

    public static void main(String[] args) {
        ListNode li1 = new ListNode(1);
        ListNode li2 = new ListNode(2);
        ListNode li3 = new ListNode(3);
        ListNode li4 = new ListNode(4);
        ListNode li5 = new ListNode(5);
        ListNode li6 = new ListNode(6);
        li1.next = li2;
        li2.next = li3;
        li3.next = li4;
        li4.next = li5;
        li5.next = li6;

        new SortList().reorderList(li1);

    }
}
