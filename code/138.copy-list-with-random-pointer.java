/*
 * @lc app=leetcode.cn id=138 lang=java
 * @lcpr version=30204
 *
 * [138] 随机链表的复制
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
//         使用哈希表建立原始节点到新节点的映射关系
// 再次遍历链表，设置新节点的 next 和 random 指针
if (head == null) {
    return null;  // 如果是空链表，直接返回 null
}

// 创建哈希表用于存储映射关系
// 键(Key)：原始链表中的节点
// 值(Value)：对应的新节点
Map<Node, Node> nodeMap = new HashMap<>();

// 第一次遍历的起点：从原始链表的头节点开始
Node current = head;

// 第一次遍历：创建所有新节点
while (current != null) {
    // 为当前节点创建一个新的副本，并建立映射关系
    // current：原始节点
    // new Node(current.val)：创建值相同的新节点
    nodeMap.put(current, new Node(current.val));
    // 移动到下一个节点
    current = current.next;
}

// 第二次遍历的起点：重新从原始链表的头节点开始
current = head;

// 第二次遍历：设置所有新节点的指针关系
while (current != null) {
    // 设置新节点的 next 指针
    // nodeMap.get(current)：获取当前原始节点对应的新节点
    // nodeMap.get(current.next)：获取原始节点的下一个节点对应的新节点
    nodeMap.get(current).next = nodeMap.get(current.next);

    // 设置新节点的 random 指针
    // nodeMap.get(current)：获取当前原始节点对应的新节点
    // nodeMap.get(current.random)：获取原始节点的随机指针指向的节点对应的新节点
    nodeMap.get(current).random = nodeMap.get(current.random);

    // 移动到下一个节点
    current = current.next;
}

// 返回新链表的头节点
// nodeMap.get(head)：获取原始头节点对应的新节点，即新链表的头节点
return nodeMap.get(head);
    }

// 首先检查输入是否为空，如果是则直接返回 null
// 创建一个哈希表 nodeMap，用于存储原始节点到新节点的映射
// 第一次遍历：
// 遍历原始链表
// 为每个节点创建一个新的拷贝节点
// 将原始节点和对应的新节点存入哈希表
// 第二次遍历：
// 再次遍历原始链表
// 通过哈希表找到对应的新节点
// 设置新节点的 next 和 random 指针
// 最后返回新链表的头节点（从哈希表中获取）
// return head;
        // }

        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
    
            // 1. 复制节点并插入到原节点后面 A -> A' -> B -> B' -> ...
            Node current = head;
            while (current != null) {
                Node copyNode = new Node(current.val);
                copyNode.next = current.next;
                current.next = copyNode;
                current = copyNode.next; // 移动到原始链表的下一个节点
            }
    
            // 2. 设置副本节点的 random 指针
            current = head;
            while (current != null) {
                Node copyNode = current.next;
                if (current.random != null) {
                    // current.random 是原始 random 指针指向的节点
                    // current.random.next 是该原始节点对应的副本节点
                    copyNode.random = current.random.next;
                }
                current = copyNode.next; // 移动到原始链表的下一个节点
            }
    
            // 3. 拆分原始链表和副本链表
            Node dummyCopyHead = new Node(0); // 副本链表的哑头节点
            Node copyTail = dummyCopyHead;   // 副本链表的尾指针
            current = head;                 // 原始链表的遍历指针
    
            while (current != null) {
                Node copyNode = current.next;    // 获取副本节点
                Node originalNext = copyNode.next; // 获取原始链表的下一个节点
    
                // 连接副本节点
                copyTail.next = copyNode;
                copyTail = copyNode; // 移动副本链表尾指针, copyNode.next 会在下一步被修改，所以先移动
    
                // 恢复原始链表
                current.next = originalNext;
    
                // 移动原始链表指针
                current = originalNext;
            }
    
            return dummyCopyHead.next;
        }

    }
// @lc code=end



/*
// @lcpr case=start
// [[7,null],[13,0],[11,4],[10,2],[1,0]]\n
// @lcpr case=end

// @lcpr case=start
// [[1,1],[2,1]]\n
// @lcpr case=end

// @lcpr case=start
// [[3,null],[3,0],[3,null]]\n
// @lcpr case=end

 */

