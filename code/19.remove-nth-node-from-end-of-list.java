/*
 * @lc app=leetcode.cn id=19 lang=java
 * @lcpr version=30204
 *
 * [19] 删除链表的倒数第 N 个结点
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //还是快慢指针，先让快指针走n步，再让他们一起走，直到fast到终点，slow就到了要删除的节点的前一个
        //为社么要创建一个呀节点=》方便处理头节点的删除问题

        ListNode dummy=new ListNode(0);
        dummy.next=head;


        //
        ListNode fast=dummy;
        ListNode slow=dummy;
        
        for (int i = 0; i < n; i++) {
            fast=fast.next;
        }
        //如何判断faset到了最后有一个节点， 
        // 当 fast.next == null 时，fast 指向最后一个节点
        while (fast.next!=null) {
            fast=fast.next;
            slow=slow.next;
        }

        //删除第n个指针
        slow.next=slow.next.next;

        return dummy.next;

    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1]\n1\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n1\n
// @lcpr case=end

 */

