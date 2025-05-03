/*
 * @lc app=leetcode.cn id=234 lang=java
 * @lcpr version=30204
 *
 * [234] 回文链表
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
    public boolean isPalindrome(ListNode head) {
        //1.转化为数组，从头和尾分别判断
        //2.将链表对半，使用反转链表，比较前半部分和后半部分是否相同

        //赵中点+反转后半段+比较
        //处理边界
        if (head == null || head.next == null) {
            return true;  // 空链表或只有一个节点的链表都是回文
        }

        //1.用快慢指针找到链表中点
        ListNode slow=head;
        ListNode fast=head;

        while (fast!=null&& fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }

        //2.反转后半段
        ListNode secondHalfHead =reverseList(slow);
        ListNode firstHalfHead = head;

        //3.比较前半段和后半段
        ListNode p1=firstHalfHead;
        ListNode p2=secondHalfHead;
        boolean result=true;

        while (result&& p2!=null) {
            if (p1.val!=p2.val){
                result=false;
            }
            p1=p1.next;
            p2=p2.next;
        }
 return       result ;
    }

    public ListNode reverseList(ListNode head){
        ListNode pre=null;
        ListNode curr=head;
        while (curr!=null) {
            ListNode next=curr.next;
            curr.next=pre;
            
            pre=curr;
            curr=next;
        }
        return pre;
    }
}
// @lc code=end



/*
// @lcpr case=start
// [1,2,2,1]\n
// @lcpr case=end

// @lcpr case=start
// [1,2]\n
// @lcpr case=end

 */

