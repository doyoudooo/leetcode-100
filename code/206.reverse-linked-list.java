/*
 * @lc app=leetcode.cn id=206 lang=java
 * @lcpr version=30204
 *
 * [206] 反转链表
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
    //使用迭代方法
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode curr=head;
        while (curr!=null) {
            //保存下一个节点，防止丢失
            ListNode next=curr.next;
            //反转当前节点的指针
            curr.next=pre;

            //移动到下一个节点
            pre=curr;
            curr=next;
        }
        return pre;
    }

    //使用递归方法

    // public ListNode reverseList(ListNode head) {
    //     // 基本情况：空链表或只有一个节点
    //     if (head == null || head.next == null) {
    //         return head;
    //     }

    //   // 递归反转剩余部分
    //   ListNode newHead = reverseList(head.next);
      
    //     // 反转当前节点与下一个节点的连接
    //     head.next.next = head;
    //     head.next = null;

    //     // 返回反转后的头节点（即原链表的最后一个节点）
    //     return newHead;
    // }
}


// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

