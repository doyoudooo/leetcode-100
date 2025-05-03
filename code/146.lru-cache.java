/*
 * @lc app=leetcode.cn id=146 lang=java
 * @lcpr version=30204
 *
 * [146] LRU 缓存
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class LRUCache {

     // 定义双向链表节点
     private static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {} // 用于伪节点
        public DLinkedNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private final Map<Integer, DLinkedNode> cache; // 哈希表，用于 O(1) 查找节点
    private final DLinkedNode head;               // 伪头节点
    private final DLinkedNode tail;               // 伪尾节点
    private final int capacity;                   // 缓存容量
    private int size;                             // 当前缓存大小

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<>();
        // 初始化伪头尾节点，并将它们连接起来
        this.head = new DLinkedNode();
        this.tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
        /**
     * 获取 key 对应的 value。
     * 如果 key 存在，将其移动到链表头部（表示最近使用），并返回值。
     * 如果 key 不存在，返回 -1。
     */
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // key 不存在
            return -1;
        }
        // key 存在，将其移动到头部 (标记为最近使用)
        moveToHead(node);
        return node.value;
    }
        /**
     * 插入或更新 key-value 对。
     * 如果 key 已存在，更新 value，并将其移动到链表头部。
     * 如果 key 不存在：
     *   - 创建新节点，插入到链表头部和哈希表中。
     *   - 如果缓存大小超过容量，则移除链表尾部节点（最久未使用）。
     */
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            // key 不存在，创建新节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加到哈希表
            cache.put(key, newNode);
            // 添加到链表头部
            addToHead(newNode);
            // 增加大小
            size++;
            // 检查是否超出容量
            if (size > capacity) {
                // 移除链表尾部节点（最久未使用）
                DLinkedNode tailNode = removeTail();
                // 从哈希表中移除对应的 key
                cache.remove(tailNode.key);
                // 减少大小
                size--;
            }
        } else {
            // key 已存在，更新 value
            node.value = value;
            // 将节点移动到头部 (标记为最近使用)
            moveToHead(node);
        }
        
    }
    /**
     * 将节点添加到链表头部（伪头节点之后）
     */
    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    /**
     * 从链表中移除指定节点
     */
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 将指定节点移动到链表头部
     */
    private void moveToHead(DLinkedNode node) {
        // 先从当前位置移除
        removeNode(node);
        // 再添加到头部
        addToHead(node);
    }

    /**
     * 移除链表尾部节点（伪尾节点之前，即最久未使用的节点）
     * @return 被移除的节点
     */
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end



