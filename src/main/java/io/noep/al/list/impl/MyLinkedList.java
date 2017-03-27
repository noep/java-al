package io.noep.al.list.impl;

import io.noep.al.list.MyList;
import io.noep.al.node.Node;
import io.noep.al.node.SingleNode;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 3. 23.
 * Time  : 오전 1:15
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class MyLinkedList implements MyList {

    private SingleNode singleNode;

    public void init(int data) {
        this.singleNode = new SingleNode();
        this.singleNode.setData(data);
    }

    public void destroy() {
        this.singleNode = null;
    }

    public void append(Node newNode) {
        assert newNode != null;

        if (this.singleNode == null) {
            this.singleNode = (SingleNode) newNode;
        } else {
            SingleNode tail = this.singleNode;
            while (tail.getNext() != null) {
                tail = (SingleNode) tail.getNext();
            }
            tail.setNext((SingleNode) newNode);
        }
    }

    public Node search(int position) {
        assert position >= 0;

        SingleNode head = this.singleNode;

        while (head != null && --position >= 0) {
            head = (SingleNode) head.getNext();
        }

        return head;
    }

    public void delete(int position) {
        assert position >= 0;

        SingleNode beforeHead = null;
        SingleNode head = this.singleNode;

        while (head != null && --position >= 0) {
            beforeHead = head;
            head = (SingleNode) head.getNext();
        }

        if (beforeHead == null && head != null) { //-- 첫 번째 노드
            this.singleNode = (SingleNode) this.singleNode.getNext();
        } else if (beforeHead != null && head != null) { //-- 중간 노드
            beforeHead.setNext((SingleNode) head.getNext());
        }
    }

    public void insert(int position, Node newNode) {
        assert newNode != null;
        assert position >= 0;

        SingleNode head = this.singleNode;

        while (head != null && --position >= 0) {
            head = (SingleNode) head.getNext();
        }

        if (head.getNext() != null) {
            SingleNode pushed = (SingleNode) head.getNext();
            ((SingleNode) newNode).setNext(pushed);
            head.setNext((SingleNode) newNode);
        } else {
            head.setNext((SingleNode) newNode);
        }
    }

    public int size() {
        SingleNode head = this.singleNode;

        int count = 0;

        while (head != null) {
            count++;
            head = (SingleNode) head.getNext();
        }

        return count;
    }

    public Node getNode() {
        return this.singleNode;
    }
}
