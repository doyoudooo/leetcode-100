/*
 * @lc app=leetcode.cn id=160 lang=java
 * @lcpr version=30204
 *
 * [160] 相交链表
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
        /**
     * 找出两个单链表的相交节点
     * 方法：双指针技巧
     * @param headA 第一个链表的头节点
     * @param headB 第二个链表的头节点
     * @return 相交节点，如果不存在则返回 null
     */
    //
    // **核心思想：** 使用两个指针 `pA` 和 `pB`，让它们分别从链表 A 和链表 B 的头部开始遍历。当一个指针到达链表末尾时，将它重定向到另一个链表的头部，继续遍历。

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //使用双指针方法
        // 如果任一链表为空，不可能相交
        if (headA == null || headB == null) {
            return null;
        }
        // 初始化两个指针
        ListNode pA = headA;
        ListNode pB = headB;
        // 当 pA 和 pB 不相等时，继续移动
        while (pA != pB) {
            // 如果 pA 到达链表 A 的末尾，将其重定向到链表 B 的头部
            // 否则，pA 向后移动
            pA = (pA == null) ? headB : pA.next;//解释一
/**
1条件判断：(pA == null) - 检查指针 pA 是否已经到达链表 A 的末
2 如果条件为真：pA = headB - 如果 pA 已经遍历完整个链表 A（到达末尾为 null），则将 pA 重定向到链表 B 的头部开始遍历          
3如果条件为假：pA = pA.next - 如果 pA 还未到达链表 A 的末尾，则正常向后移动一步 */


            // 如果 pB 到达链表 B 的末尾，将其重定向到链表 A 的头部
            // 否则，pB 向后移动
            pB = (pB == null) ? headA : pB.next;
        }

        // 此时 pA 和 pB 要么都指向相交节点，要么都是 null（如果不相交）
        return pA;
    }
}
// @lc code=end



/*
// @lcpr case=start
// 8\n[4,1,8,4,5]\n[5,6,1,8,4,5]\n2\n3\n
// @lcpr case=end

// @lcpr case=start
// 2\n[1,9,1,2,4]\n[3,2,4]\n3\n1\n
// @lcpr case=end

// @lcpr case=start
// 0\n[2,6,4]\n[1,5]\n3\n2\n
// @lcpr case=end

 */

