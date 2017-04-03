package io.noep.al.list.impl;

import io.noep.al.list.MyList;
import io.noep.al.node.DoubleNode;
import io.noep.al.node.Node;
import io.noep.al.node.SingleNode;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 3. 25.
 * Time  : 오후 10:49
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class MyDoubleLinkedList implements MyList {

    private DoubleNode doubleNode;

    public void init(int data) {
        this.doubleNode = new DoubleNode();
        this.doubleNode.setData(data);
    }

    public void destroy() {
        this.doubleNode = null;
    }

    public void append(Node newNode) {
        assert newNode != null;

        if (this.doubleNode == null) {
            this.doubleNode = (DoubleNode) newNode;
        } else {
            DoubleNode tail = this.doubleNode;
            while (tail.getNext() != null) {
                tail = (DoubleNode) tail.getNext();
            }
            tail.setNext((DoubleNode) newNode);
            ((DoubleNode) newNode).setPrevious(tail);
        }

    }

    public Node search(int position) {
        assert position >= 0;

        DoubleNode head = this.doubleNode;

        while (head != null && --position >= 0) {
            head = (DoubleNode) head.getNext();
        }

        return head;
    }

    public void delete(int position) {
        assert position >= 0;

        DoubleNode head = this.doubleNode;

        while (head != null && --position >= 0) {
            head = (DoubleNode) head.getNext();
        }

        if (head != null && head.getPrevious() == null) { //-- 첫번째 노드
            this.doubleNode = (DoubleNode) head.getNext();
            ((DoubleNode) head.getNext()).setPrevious(this.doubleNode);
        } else if (head != null && head.getPrevious() != null) { //-- 중간 노드
            ((DoubleNode) head.getPrevious()).setNext((DoubleNode) head.getNext());

            if (head.getNext() != null) {
                ((DoubleNode) head.getNext()).setPrevious((DoubleNode) head.getPrevious());
            }
        }
    }

    public void insert(int position, Node newNode) {
        assert newNode != null;
        assert position >= 0;

        DoubleNode head = this.doubleNode;

        while (head != null && --position >= 0) {
            head = (DoubleNode) head.getNext();
        }

        if (head.getNext() != null) {
            DoubleNode pushed = (DoubleNode) head.getNext();
            head.setNext((DoubleNode) newNode);
            ((DoubleNode) newNode).setNext(pushed);

            pushed.setPrevious((DoubleNode) newNode);
            ((DoubleNode) newNode).setPrevious(head);
        } else {
            head.setNext((DoubleNode) newNode);
            ((DoubleNode) newNode).setPrevious(head);
        }
    }

    public int size() {
        DoubleNode head = this.doubleNode;

        int count = 0;

        while (head != null) {
            count++;
            head = (DoubleNode) head.getNext();
        }

        return count;
    }

    public DoubleNode getNode() {
        return this.doubleNode;
    }
}
