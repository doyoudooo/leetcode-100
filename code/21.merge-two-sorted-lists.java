/*
 * @lc app=leetcode.cn id=21 lang=java
 * @lcpr version=30204
 *
 * [21] 合并两个有序链表
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
     * 合并两个有序链表 - 迭代法
     * @param list1 第一个有序链表
     * @param list2 第二个有序链表
     * @return 合并后的有序链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 创建哑节点，简化边界处理
        ListNode dummy = new ListNode(-1);
        // current 指针用于构建新链表
        ListNode current = dummy;
        // 使用 p1 和 p2 遍历 list1 和 list2
        ListNode p1 = list1;
        ListNode p2 = list2;
        //
        while (p1!=null&&p2!=null) {
            //比较p1和p2指向的节点
            if (p1.val<p2.val) {
                current.next=p1;
                p1=p1.next;
            }else{
                current.next=p2;
                p2=p2.next;

            }
            current = current.next;
        }
        //处理剩余节点
        if (p1 != null) {
            current.next = p1;
        }
        // 如果 list2 还有剩余节点，直接连接
        else if (p2 != null) {
            current.next = p2;
        }

        // 返回哑节点的下一个节点，即合并后链表的头节点
        return dummy.next;





    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,4]\n[1,3,4]\n
// @lcpr case=end

// @lcpr case=start
// []\n[]\n
// @lcpr case=end

// @lcpr case=start
// []\n[0]\n
// @lcpr case=end

 */

