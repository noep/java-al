package io.noep.al.list.impl;

import io.noep.al.list.MyList;
import io.noep.al.list.Node;
import lombok.Getter;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 3. 23.
 * Time  : 오전 1:15
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
@Getter
public class MyLinkedList implements MyList {

    private Node node;

    public void init(int data) {
        this.node = new Node();
        this.node.setData(data);
    }

    public void destroy() {
        this.node = null;
    }

    public void append(Node newNode) {
        assert newNode != null;

        if (this.node == null) {
            this.node = newNode;
        } else {
            Node tail = this.node;
            while (tail.getNode() != null) {
                tail = tail.getNode();
            }
            tail.setNode(newNode);
        }
    }

    public Node search(int position) {
        assert position >= 0;

        Node head = this.node;

        while (head != null && --position >= 0) {
            head = head.getNode();
        }

        return head;
    }

    public void delete(int position) {
        assert position >= 0;

        Node beforeHead = null;
        Node head = this.node;

        while (head != null && --position >= 0) {
            beforeHead = head;
            head = head.getNode();
        }

        if (beforeHead == null && head != null) { //-- 첫 번째 노드
            this.node = this.node.getNode();
        } else if (beforeHead != null && head != null) { //-- 중간 노드
            beforeHead.setNode(head.getNode());
        }
    }

    public void insert(int position, Node newNode) {
        assert node != null;
        assert position >= 0;

        Node head = this.node;

        while (head != null && --position >= 0) {
            head = head.getNode();
        }

        if (head.getNode() != null) {
            Node pushed = head.getNode();
            newNode.setNode(pushed);
            head.setNode(newNode);
        } else {
            head.setNode(newNode);
        }
    }

    public int size() {
        Node head = this.node;

        int count = 0;

        while (head != null) {
            count ++;
            head = head.getNode();
        }

        return count;
    }
}
