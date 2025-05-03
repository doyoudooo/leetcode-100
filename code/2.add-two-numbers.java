/*
 * @lc app=leetcode.cn id=2 lang=java
 * @lcpr version=30204
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建哑节点，简化头节点处理
        ListNode dummy = new ListNode(0);
        // current 指针用于构建新链表
        ListNode current = dummy;
        // 初始化进位为 0
        int carry = 0;
        //循环条件:l1或者l2为遍历完成，或者还有进位
        while (l1!=null||l2!=null||carry!=0) {
// 获取 l1 和 l2 当前节点的值，如果节点为空则值为 0
int val1 = (l1 != null) ? l1.val : 0;
int val2 = (l2 != null) ? l2.val : 0;

   //计算当前位置的和
   int sum= (val1+val2+carry);
   //计算新的进位
   carry=sum/10;//取模
   //计算当前位的值
   int digit=sum%10;


//    创建新节点，并链接到结果链表
current.next=new ListNode(digit);
//移动current节点
current=current.next;
//移动l1和l2执政
if (l1 != null) {
    l1 = l1.next;
}
if (l2 != null) {
    l2 = l2.next;
}}
//最后返回链表的头节点！
return dummy.next;


    }
}
// @lc code=end



/*
// @lcpr case=start
// [2,4,3]\n[5,6,4]\n
// @lcpr case=end

// @lcpr case=start
// [0]\n[0]\n
// @lcpr case=end

// @lcpr case=start
// [9,9,9,9,9,9,9]\n[9,9,9,9]\n
// @lcpr case=end

 */

