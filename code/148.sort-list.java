/*
 * @lc app=leetcode.cn id=148 lang=java
 * @lcpr version=30204
 *
 * [148] 排序链表
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
     * 排序链表 - 暴力解法 (类似选择排序, O(n^2) 时间, O(1) 空间)
     * 通过交换节点值实现
     * @param head 链表头节点
     * @return 排序后的链表头节点
     */
    public ListNode sortList(ListNode head) {
        // 处理空链表或只有一个节点的情况
        if (head == null || head.next == null) {
            return head;
        }

        // 外层循环：current 指向当前需要确定最小值的目标位置
        ListNode current = head;
        while (current != null) {
            // 内层循环：runner 用于查找从 current 开始的剩余链表中的最小值节点
            ListNode minNode = current; // 假设当前节点就是最小值节点
            ListNode runner = current.next; // 从 current 的下一个节点开始查找

            while (runner != null) {
                // 如果找到更小的值，更新 minNode
                if (runner.val < minNode.val) {
                    minNode = runner;
                }
                runner = runner.next; // 继续向后查找
            }

            // 找到从 current 开始的最小节点 minNode 后，
            // 如果 minNode 不是 current 本身，则交换它们的值
            if (minNode != current) {
                int temp = current.val;
                current.val = minNode.val;
                minNode.val = temp;
            }

            // 将 current 移动到下一个位置，继续下一轮的最小值查找和交换
            current = current.next;
        }

        // 排序完成后，返回原始头节点（因为我们只交换了值，节点结构没变）
        return head;
    }


//         /**
//      * 排序链表 - 自底向上归并排序 (O(n log n) 时间, O(1) 空间)
//      * @param head 链表头节点
//      * @return 排序后的链表头节点
//      */
//     public ListNode sortList(ListNode head) {
//         // 如果不要求时间复杂度和空间复杂度的情况下，也使用暴力解法，一步一步哦比较当前节点和剩下的节点的大小，进行调整，这样的时间复杂度是o(n^2)
//     //使用自底向上的合并方法 归并排序（时间上是O(n log n) 时间复杂度和常数级空间复杂度）
//     /*
//      * 1，计算链表长度
//      * 2.创建哑节点
//      * 3.外层循环 变长链表
//      * 4.
//      */
//     if (head == null || head.next == null) {
//         return head;
//     }
//    // 1. 计算链表长度
//    int length = 0;
//    ListNode node = head;
//    while (node != null) {
//        length++;
//        node = node.next;
//    }

//     // 2. 创建哑节点
//     ListNode dummy = new ListNode(0, head);

//  // 3. 外层循环：子链表长度从 1, 2, 4, ... 递增
//  for (int subLength = 1; subLength < length; subLength <<= 1) { // subLength *= 2
//     ListNode prev = dummy;      // 指向每次合并完成后的尾部
//     ListNode curr = dummy.next; // 指向当前处理段的头部


//       // 4. 内层循环：遍历链表，合并相邻的 subLength 长度的子链表
//       while (curr != null) {
//         // 找到第一个子链表 head1 (长度 subLength)
//         ListNode head1 = curr;
//         ListNode tail1 = curr; // 用于找到 head1 的尾部
//         // 尝试向后移动 subLength - 1 步
//         for (int i = 1; i < subLength && tail1 != null && tail1.next != null; i++) {
//             tail1 = tail1.next;
//         }

//         // 如果 tail1 为 null，说明剩余部分不足一个完整的 head1，无需合并，结束内层循环
//         if (tail1 == null) {
//             break;
//         }

//         // 找到第二个子链表 head2 (长度 subLength)
//         ListNode head2 = tail1.next; // head2 的起始节点
//         // 如果 head2 为 null，说明只剩下 head1，无需合并，结束内层循环
//         if (head2 == null) {
//             break;
//         }
//         tail1.next = null; // 断开 head1 和 head2

//         ListNode tail2 = head2; // 用于找到 head2 的尾部
//         // 尝试向后移动 subLength - 1 步
//         for (int i = 1; i < subLength && tail2 != null && tail2.next != null; i++) {
//             tail2 = tail2.next;
//         }

//         ListNode nextPairStart = null; // 记录下一对合并的起始点
//         if (tail2 != null) {
//             nextPairStart = tail2.next;
//             tail2.next = null; // 断开 head2 和后续链表
//         }
//         // 如果 tail2 为 null，说明 head2 的实际长度可能小于 subLength

//         // 合并 head1 和 head2
//         ListNode merged = merge(head1, head2);

//         // 将合并后的链表连接到 prev 后面
//         prev.next = merged;

//         // 将 prev 移动到合并后链表的末尾
//         while (prev.next != null) {
//             prev = prev.next;
//         }

//         // 将 curr 移动到下一对的起始点
//         curr = nextPairStart;
//     }
// }

//     // 5. 返回排序后链表的头节点
//     return dummy.next;
//     }

        /**
     * 合并两个有序链表 (同 LeetCode 21)
     */
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    }
// @lc code=end



/*
// @lcpr case=start
// [4,2,1,3]\n
// @lcpr case=end

// @lcpr case=start
// [-1,5,3,4,0]\n
// @lcpr case=end

// @lcpr case=start
// []\n
// @lcpr case=end

 */

