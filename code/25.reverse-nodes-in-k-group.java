/*
 * @lc app=leetcode.cn id=25 lang=java
 * @lcpr version=30204
 *
 * [25] K 个一组翻转链表
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
        /**
     * K 个一组翻转链表
     * @param head 链表头节点
     * @param k    每组的节点数
     * @return 翻转后的链表头节点
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 哑节点
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        // prev 指向待翻转子链表的前一个节点
        ListNode prev =dummy;
        //// end 指向待翻转子链表的最后一个节点
        ListNode end = dummy;
        while (true) {
            // 1. 找到 k 个节点，确定 end 的位置
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 如果 end 为 null，说明剩余节点不足 k 个，结束循环
            if (end == null) {
                break;
            }

            // 2. 准备工作
            ListNode start = prev.next;       // 待翻转子链表的头节点
            ListNode nextGroupStart = end.next; // 下一组的头节点

            // 3. 断开连接，独立出待翻转的子链表
            end.next = null;

            // 4. 翻转子链表，并重新连接
            prev.next = reverse(start); // prev 连接到翻转后的新头 (原来的 end)
                                        // 注意：reverse 函数返回的是翻转后的头节点

            // 5. 将翻转后的子链表尾部连接到下一组的头节点
            // 翻转后，原来的 start 节点变成了尾节点
            start.next = nextGroupStart;

            // 6. 更新 prev 和 end，为下一轮做准备
            prev = start; // prev 移动到当前已处理部分的末尾
            end = prev;   // end 重置，准备寻找下一组的末尾
        }
return dummy.next;
    }
    //反转链表 迭代法，一步一步反转链表
    private ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev; // prev is the new head
}
        
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4,5]\n2\n
// @lcpr case=end

// @lcpr case=start
// [1,2,3,4,5]\n3\n
// @lcpr case=end

 */

