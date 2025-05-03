/*
 * @lc app=leetcode.cn id=24 lang=java
 * @lcpr version=30204
 *
 * [24] 两两交换链表中的节点
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
    // public ListNode swapPairs(ListNode head) {
    //     //用递归的方法解决一下
    //     /*
    //      *  定义一个递归函数，
    //      * 该函数负责交换当前头两个节点，并将其余部分交给递归调用处理。
    //      */
    //     // 基本情况：链表为空或只有一个节点，无需交换
    //     if (head == null || head.next == null) {
    //         return head;
    //     }

    //     // 获取前两个节点
    //     ListNode node1 = head;
    //     ListNode node2 = head.next;

    //     // 递归交换 node2 后面的节点
    //     ListNode swappedRest = swapPairs(node2.next);

    //     // 执行当前这对节点的交换
    //     node2.next = node1;       // 第二个节点指向第一个节点
    //     node1.next = swappedRest; // 第一个节点指向后面已交换好的部分

    //     // node2 现在是交换后这对节点的新头节点
    //     return node2;
    // }
    /**
     * 两两交换链表中的节点 - 迭代法
     * @param head 链表头节点
     * @return 交换后的链表头节点
     */
    public ListNode swapPairs(ListNode head) {
        // 创建哑节点，简化头两个节点的交换处理
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // prev 指向待交换两个节点的前一个节点
        ListNode prev = dummy;

        // 循环条件：确保 prev 后面至少还有两个节点可以交换
        while (prev.next != null && prev.next.next != null) {
            // 获取待交换的两个节点
            ListNode node1 = prev.next;
            ListNode node2 = prev.next.next;

            // 执行交换
            // 1. prev 指向 node2
            prev.next = node2;
            // 2. node1 指向 node2 的下一个节点
            node1.next = node2.next;
            // 3. node2 指向 node1
            node2.next = node1;

            // 更新 prev 指针，移动到下一对要交换的节点之前
            // 交换后，node1 变成了这对节点的第二个节点
            prev = node1;
        }

        // 返回哑节点的下一个节点，即交换后的新头节点
        return dummy.next;
    }

}
// @lc code=end



/*
// @lcpr case=start
// [1,2,3,4]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

// @lcpr case=start
// [1]\n
// @lcpr case=end

 */

