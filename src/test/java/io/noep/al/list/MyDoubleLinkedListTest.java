package io.noep.al.list;

import io.noep.al.list.impl.MyDoubleLinkedList;
import io.noep.al.node.DoubleNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 3. 23.
 * Time  : 오전 1:16
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class MyDoubleLinkedListTest {

    @Test
    public void initTest() {
        MyDoubleLinkedList list = new MyDoubleLinkedList();

        list.init(100);
        list.append(new DoubleNode(101));
        list.append(new DoubleNode(102));

        assertEquals(list.getNode().getData(), 100);
        assertEquals(list.getNode().getNext().getData(), 101);
        assertEquals(list.getNode().getNext().getNext().getData(), 102);
        assertNull(list.getNode().getNext().getNext().getNext());
    }

    @Test
    public void appendTest() {
        MyDoubleLinkedList list = new MyDoubleLinkedList();
        list.append(new DoubleNode(100));
        list.append(new DoubleNode(101));
        list.append(new DoubleNode(102));

        assertEquals(list.getNode().getData(), 100);
        assertEquals(list.getNode().getNext().getData(), 101);
        assertEquals(list.getNode().getNext().getNext().getData(), 102);
        assertNull(list.getNode().getNext().getNext().getNext());
    }

    @Test
    public void searchTest() {
        MyDoubleLinkedList list = init(3);

        assertEquals(list.search(0).getData(), 100);
        assertEquals(list.search(1).getData(), 101);
        assertEquals(list.search(2).getData(), 102);
    }

    @Test
    public void deleteTest() {
        MyDoubleLinkedList list1 = init(4);
        list1.delete(0);
        assertEquals(list1.getNode().getData(), 101);
        assertEquals(list1.getNode().getNext().getData(), 102);
        assertEquals(list1.getNode().getNext().getNext().getData(), 103);

        MyDoubleLinkedList list2 = init(4);
        list2.delete(1);
        assertEquals(list2.getNode().getData(), 100);
        assertEquals(list2.getNode().getNext().getData(), 102);
        assertEquals(list2.getNode().getNext().getNext().getData(), 103);

        MyDoubleLinkedList list3 = init(4);
        list3.delete(2);
        assertEquals(list3.getNode().getData(), 100);
        assertEquals(list3.getNode().getNext().getData(), 101);
        assertEquals(list3.getNode().getNext().getNext().getData(), 103);

        MyDoubleLinkedList list4 = init(4);
        list4.delete(3);
        assertEquals(list4.getNode().getData(), 100);
        assertEquals(list4.getNode().getNext().getData(), 101);
        assertEquals(list4.getNode().getNext().getNext().getData(), 102);

    }

    @Test
    public void insertTest() {
        MyDoubleLinkedList list1 = init(3);
        list1.insert(0, new DoubleNode(999));

        assertEquals(list1.getNode().getData(), 100);
        assertEquals(list1.getNode().getNext().getData(), 999);
        assertEquals(list1.getNode().getNext().getNext().getData(), 101);
        assertEquals(list1.getNode().getNext().getNext().getNext().getData(), 102);

        MyDoubleLinkedList list2 = init(3);
        list2.insert(1, new DoubleNode(999));

        assertEquals(list2.getNode().getData(), 100);
        assertEquals(list2.getNode().getNext().getData(), 101);
        assertEquals(list2.getNode().getNext().getNext().getData(), 999);
        assertEquals(list2.getNode().getNext().getNext().getNext().getData(), 102);

        MyDoubleLinkedList list3 = init(3);
        list3.insert(2, new DoubleNode(999));

        assertEquals(list3.getNode().getData(), 100);
        assertEquals(list3.getNode().getNext().getData(), 101);
        assertEquals(list3.getNode().getNext().getNext().getData(), 102);
        assertEquals(list3.getNode().getNext().getNext().getNext().getData(), 999);
    }

    @Test
    public void countTest() {
        assertEquals(init(0).size(), 0);
        assertEquals(init(1).size(), 1);
        assertEquals(init(2).size(), 2);
    }

    private MyDoubleLinkedList init(int size) {
        MyDoubleLinkedList list = new MyDoubleLinkedList();
        for (int i = 100; i < 100 + size; i++) {
            list.append(new DoubleNode(i));
        }
        return list;
    }
}
