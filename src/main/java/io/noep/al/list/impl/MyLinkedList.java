package io.noep.al.list.impl;

import io.noep.al.list.MyList;
import io.noep.al.node.SingleNode;
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
public class MyLinkedList implements MyList {

    private SingleNode singleNode;

    public void init(int data) {
        this.singleNode = new SingleNode();
        this.singleNode.setData(data);
    }

    public void destroy() {
        this.singleNode = null;
    }

    public void append(SingleNode newSingleNode) {
        assert newSingleNode != null;

        if (this.singleNode == null) {
            this.singleNode = newSingleNode;
        } else {
            SingleNode tail = this.singleNode;
            while (tail.getSingleNode() != null) {
                tail = tail.getSingleNode();
            }
            tail.setSingleNode(newSingleNode);
        }
    }

    public SingleNode search(int position) {
        assert position >= 0;

        SingleNode head = this.singleNode;

        while (head != null && --position >= 0) {
            head = head.getSingleNode();
        }

        return head;
    }

    public void delete(int position) {
        assert position >= 0;

        SingleNode beforeHead = null;
        SingleNode head = this.singleNode;

        while (head != null && --position >= 0) {
            beforeHead = head;
            head = head.getSingleNode();
        }

        if (beforeHead == null && head != null) { //-- 첫 번째 노드
            this.singleNode = this.singleNode.getSingleNode();
        } else if (beforeHead != null && head != null) { //-- 중간 노드
            beforeHead.setSingleNode(head.getSingleNode());
        }
    }

    public void insert(int position, SingleNode newSingleNode) {
        assert singleNode != null;
        assert position >= 0;

        SingleNode head = this.singleNode;

        while (head != null && --position >= 0) {
            head = head.getSingleNode();
        }

        if (head.getSingleNode() != null) {
            SingleNode pushed = head.getSingleNode();
            newSingleNode.setSingleNode(pushed);
            head.setSingleNode(newSingleNode);
        } else {
            head.setSingleNode(newSingleNode);
        }
    }

    public int size() {
        SingleNode head = this.singleNode;

        int count = 0;

        while (head != null) {
            count ++;
            head = head.getSingleNode();
        }

        return count;
    }

    public SingleNode getNode() {
        return this.singleNode;
    }
}
