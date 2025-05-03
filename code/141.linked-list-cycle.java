/*
 * @lc app=leetcode.cn id=141 lang=java
 * @lcpr version=30204
 *
 * [141] 环形链表
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //使用快慢指针，如果有环那么一定会相遇
        //
        if (head==null||head.next==null) {
            return false;
        }
        //
        ListNode slow=head;
        ListNode fast=head;

        while (fast!=null&& fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;

            if (fast==slow) {
                return true;
            }
  
        }
        return false;
        
    }
}
// @lc code=end



/*
// @lcpr case=start
// [3,2,0,-4]\n1\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n0\n
// @lcpr case=end

// @lcpr case=start
// [1]\n-1\n
// @lcpr case=end

 */

