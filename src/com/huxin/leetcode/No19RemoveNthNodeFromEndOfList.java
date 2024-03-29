package com.huxin.leetcode;

public class No19RemoveNthNodeFromEndOfList {
    /*
    整体思路是让前面的指针先移动n步，之后前后指针共同移动直到前面的指针到尾部为止
    首先设立预先指针 pre，预先指针是一个小技巧，
    设预先指针 pre 的下一个节点指向 head，设前指针为 start，后指针为 end，二者都等于 pre
    start 先向前移动n步
    之后 start 和 end 共同向前移动，此时二者的距离为 n，当 start 到尾部时，end 的位置恰好为倒数第 n 个节点
    因为要删除该节点，所以要移动到该节点的前一个才能删除，所以循环结束条件为 start.next != null
    删除后返回 pre.next，为什么不直接返回 head 呢，因为 head 有可能是被删掉的点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while(n > 0){
            fast = fast.next;
            n--;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
