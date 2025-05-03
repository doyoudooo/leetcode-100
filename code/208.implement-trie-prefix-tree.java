/*
 * @lc app=leetcode.cn id=208 lang=java
 * @lcpr version=30204
 *
 * [208] 实现 Trie (前缀树)
 */


// @lcpr-template-start

// @lcpr-template-end
// @lc code=start
class Trie {
    private class TrieNode {
        // 子节点数组，假设只包含小写字母 'a'-'z'
        TrieNode[] children;
        // 标记该节点是否是一个单词的结尾
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26]; // 26个小写字母
            isEndOfWord = false;
        }
    }
    private final TrieNode root; // Trie的根节点

    /** Initialize your data structure here. *///翻译成中文就是初始化数据结构
    // 这个方法是Trie的构造函数，初始化根节点
    public Trie() {
        root = new TrieNode(); // 初始化根节点

    }
    
    public void insert(String word) {//插入单词
        // 从根节点开始插入单词
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {//将单词转换为字符数组
            // 遍历每个字符
            int index = c - 'a'; // 计算字符对应的索引
            if (currentNode.children[index] == null) {//如果当前节点的子节点不存在，则创建一个新的TrieNode
                // 如果子节点不存在，则创建新节点
                currentNode.children[index] = new TrieNode();//创建一个新的TrieNode
            }
            // 移动到子节点
            currentNode = currentNode.children[index];//更新当前节点为子节点
        }
        // 标记单词的结尾
        currentNode.isEndOfWord = true;
    }
     /** Returns if the word is in the trie. *///翻译成中文就是返回单词是否在前缀树中
    // 这个方法用于查找单词是否存在于Trie中
     public boolean search(String word) {
        TrieNode node = searchPrefix(word);//调用辅助方法searchPrefix来查找单词的最后一个节点
        // 节点存在且标记为单词结尾，则单词存在
        return node != null && node.isEndOfWord;//如果节点不为空并且标记为单词结尾，则返回true
    }

    /** Returns if there is any word in the trie that starts with the given prefix. *///翻译成中文就是返回前缀树中是否有任何单词以给定的前缀开头
    // 这个方法用于查找是否有任何单词以给定前缀开头
    public boolean startsWith(String prefix) {
        // 只要能找到前缀对应的节点路径，就返回true
        return searchPrefix(prefix) != null;
    }

    // 辅助方法：搜索前缀或单词对应的最后一个节点
    private TrieNode searchPrefix(String word) {
        TrieNode currentNode = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (currentNode.children[index] == null) {
                // 如果路径中断，则前缀或单词不存在
                return null;
            }
            // 继续沿着路径向下
            currentNode = currentNode.children[index];
        }
        // 返回找到的最后一个节点
        return currentNode;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end



