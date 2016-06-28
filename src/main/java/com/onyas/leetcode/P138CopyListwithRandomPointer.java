package com.onyas.leetcode;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/23
 * Time: 上午9:22
 * <p/>
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 * Subscribe to see which companies asked this question
 * Hide Tags Hash Table Linked List
 * Hide Similar Problems (M) Clone Graph
 * <p/>
 * 思路是先按照复制一个正常链表的方式复制，复制的时候把复制的结点做一个HashMap，以旧结点为key，新节点为value。
 * 这么做的目的是为了第二遍扫描的时候我们按照这个哈希表把结点的随机指针接上。这个算法是比较容易想到的，总共要进行两次扫描，
 * 所以时间复杂度是O(2*n)=O(n)。空间上需要一个哈希表来做结点的映射，所以空间复杂度也是O(n)。代码如下：
 */
public class P138CopyListwithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode node = head.next;
        RandomListNode pre = newHead;

        while (node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            map.put(node, newNode);
            pre.next = newNode;
            pre = newNode;

            node = node.next;
        }

        node = head;
        RandomListNode copyNode = newHead;
        while (node != null) {
            copyNode.random = map.get(node.random);
            copyNode = copyNode.next;
            node = node.next;
        }
        return newHead;
    }

    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public static void main(String[] args) {
        new P138CopyListwithRandomPointer();
    }
}
