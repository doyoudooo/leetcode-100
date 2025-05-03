/*
 * @lc app=leetcode.cn id=142 lang=java
 * @lcpr version=30204
 *
 * [142] 环形链表 II
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
    public ListNode detectCycle(ListNode head) {
        //Floyd判圈法 先用快慢指针，并找到相遇点
        if (head == null || head.next == null) {
            return null; // 链表为空或只有一个节点，不可能有环
        }
        //先用快慢指针，并找到相遇点
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // 慢指针走一步
            fast = fast.next.next;  // 快指针走两步
            if (slow == fast) {     // 指针相遇
                hasCycle = true;
                break;
            }
        }
        // 如果快指针走到头，说明没有环
        if (!hasCycle) {
            return null;
        }
  // 第二阶段：寻找环的入口
        // 将慢指针重置到头节点
        slow = head;
        // 快指针保持在相遇点
        // 两个指针同时以相同速度（一步）前进，再次相遇点即为环入口
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // 返回环的入口节点
        return slow;
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

