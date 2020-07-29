package com.joeyang;

public class Problem92 {
    public  class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        // 先将 cur 指向第 m 个节点
        while (m - 1 != 0) {
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }
        next = cur.next;
        ListNode pointedWithHeader = pre; // 反转后需要指向头指针
        ListNode tail = cur; // 待反转的子链表的尾节点
        // 开始反转链表
        while (n - 1 != 0) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = cur.next;
            n--;
        }
        cur.next = pre;
        tail.next = next;
        if (pointedWithHeader != null) {
            pointedWithHeader.next = cur;
        } else {
            // 处理 m == 1 的情况
            return cur;
        }
        return head;
    }
}
