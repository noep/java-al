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
        Node head = this.node;

        if (head == null) {
            this.node = newNode;
        } else {
            Node tail = head;
            while (tail.getNode() != null ) {
                tail = tail.getNode();
            }
            tail.setNode(newNode);
        }
    }

    public void search() {

    }

    public void delete() {
    }

    public void insert() {
        assert node != null;

    }
}
