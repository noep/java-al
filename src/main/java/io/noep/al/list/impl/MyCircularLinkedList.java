package io.noep.al.list.impl;

import io.noep.al.node.DoubleNode;
import io.noep.al.node.Node;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 4. 3.
 * Time  : 오후 8:54
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class MyCircularLinkedList extends MyDoubleLinkedList {


    public void init(int data) {
        this.doubleNode = new DoubleNode(data);
        this.doubleNode.setNext(this.doubleNode);
        this.doubleNode.setPrevious(this.doubleNode);
    }

    public void destroy() {
        super.destroy();
    }

    public void append(Node newNode) {
        assert newNode != null;

        if (this.doubleNode == null) {
            this.doubleNode = (DoubleNode) newNode;

            this.doubleNode.setNext(this.doubleNode);
            this.doubleNode.setPrevious(this.doubleNode);

        } else {
            // DLL처럼 일일이 끝까지 안 찾아가줘도 되네
            DoubleNode head = this.doubleNode;
            DoubleNode tail = this.doubleNode.getPrevious(); // 끝 노드는 헤드의 이전 노드
            tail.setNext((DoubleNode) newNode); // 새 노드를 테일 뒤에 붙인다
            ((DoubleNode) newNode).setPrevious(tail); // 새 노드의 prev 는 테일

            ((DoubleNode) newNode).setNext(head); //새 노드가 새로운 tail이니 헤드와 이어준다
            head.setPrevious((DoubleNode) newNode); //헤드에도 테일을 붙인다

        }
    }

    // position 기반 접근이면 똑같지 않을까 싶은데
    public DoubleNode search(int position) {
        return super.search(position);
    }

    public void delete(int position) {
        assert position >= 0;

        DoubleNode head = this.doubleNode;
        DoubleNode first = this.doubleNode;
        DoubleNode tail = this.doubleNode.getPrevious();

        while (head != null && --position >= 0) {
            head = head.getNext();
        }

        DoubleNode deleteTarget = head;

        if (deleteTarget.equals(head)) {
            this.doubleNode = deleteTarget.getNext();
            deleteTarget.getPrevious().setNext(deleteTarget.getNext());
            deleteTarget.getNext().setPrevious(deleteTarget.getPrevious());

        } else {
            DoubleNode temp = deleteTarget;

            deleteTarget.getPrevious().setNext(temp.getNext());
            deleteTarget.setPrevious(null);
            deleteTarget.getNext().setPrevious(temp.getPrevious());
            deleteTarget.setNext(null);
        }
    }

    public void insert(int position, Node newNode) {

    }

    public int size() {
        DoubleNode head = this.doubleNode;
        DoubleNode first = this.doubleNode;
        int count = 0;

        if (head != null) count++;

        while (head != null && !first.equals(head.getNext())) {
            count++;
            head = head.getNext();
        }
        return count;
    }

    public DoubleNode getNode() {
        return this.doubleNode;
    }
}
