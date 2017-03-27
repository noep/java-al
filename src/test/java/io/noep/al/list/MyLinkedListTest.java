package io.noep.al.list;

import io.noep.al.list.impl.MyLinkedList;
import io.noep.al.node.SingleNode;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 3. 23.
 * Time  : 오전 1:16
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class MyLinkedListTest {

    @Test
    public void initTest() {
        MyList list = new MyLinkedList();

        list.init(100);
        list.append(new SingleNode(101));
        list.append(new SingleNode(102));

        assertEquals(list.getNode().getData(), 100);
        assertEquals(list.getNode().getSingleNode().getData(), 101);
        assertEquals(list.getNode().getSingleNode().getSingleNode().getData(), 102);
        assertNull(list.getNode().getSingleNode().getSingleNode().getSingleNode());
    }

    @Test
    public void appendTest() {
        MyList list = new MyLinkedList();
        list.append(new SingleNode(100));
        list.append(new SingleNode(101));
        list.append(new SingleNode(102));

        assertEquals(list.getNode().getData(), 100);
        assertEquals(list.getNode().getSingleNode().getData(), 101);
        assertEquals(list.getNode().getSingleNode().getSingleNode().getData(), 102);
        assertNull(list.getNode().getSingleNode().getSingleNode().getSingleNode());
    }

    @Test
    public void searchTest() {
        MyList list = init(3);

        assertEquals(list.search(0).getData(), 100);
        assertEquals(list.search(1).getData(), 101);
        assertEquals(list.search(2).getData(), 102);
    }

    @Test
    public void deleteTest() {
        MyList list1 = init(4);
        list1.delete(0);
        assertEquals(list1.getNode().getData(), 101);
        assertEquals(list1.getNode().getSingleNode().getData(), 102);
        assertEquals(list1.getNode().getSingleNode().getSingleNode().getData(), 103);

        MyList list2 = init(4);
        list2.delete(1);
        assertEquals(list2.getNode().getData(), 100);
        assertEquals(list2.getNode().getSingleNode().getData(), 102);
        assertEquals(list2.getNode().getSingleNode().getSingleNode().getData(), 103);

        MyList list3 = init(4);
        list3.delete(2);
        assertEquals(list3.getNode().getData(), 100);
        assertEquals(list3.getNode().getSingleNode().getData(), 101);
        assertEquals(list3.getNode().getSingleNode().getSingleNode().getData(), 103);

        MyList list4 = init(4);
        list4.delete(3);
        assertEquals(list4.getNode().getData(), 100);
        assertEquals(list4.getNode().getSingleNode().getData(), 101);
        assertEquals(list4.getNode().getSingleNode().getSingleNode().getData(), 102);

    }

    @Test
    public void insertTest() {
        MyList list1 = init(3);
        list1.insert(0, new SingleNode(999));

        assertEquals(list1.getNode().getData(), 100);
        assertEquals(list1.getNode().getSingleNode().getData(), 999);
        assertEquals(list1.getNode().getSingleNode().getSingleNode().getData(), 101);
        assertEquals(list1.getNode().getSingleNode().getSingleNode().getSingleNode().getData(), 102);

        MyList list2 = init(3);
        list2.insert(1, new SingleNode(999));

        assertEquals(list2.getNode().getData(), 100);
        assertEquals(list2.getNode().getSingleNode().getData(), 101);
        assertEquals(list2.getNode().getSingleNode().getSingleNode().getData(), 999);
        assertEquals(list2.getNode().getSingleNode().getSingleNode().getSingleNode().getData(), 102);

        MyList list3 = init(3);
        list3.insert(2, new SingleNode(999));

        assertEquals(list3.getNode().getData(), 100);
        assertEquals(list3.getNode().getSingleNode().getData(), 101);
        assertEquals(list3.getNode().getSingleNode().getSingleNode().getData(), 102);
        assertEquals(list3.getNode().getSingleNode().getSingleNode().getSingleNode().getData(), 999);
    }

    @Test
    public void countTest() {
        assertEquals(init(0).size(), 0);
        assertEquals(init(1).size(), 1);
        assertEquals(init(2).size(), 2);
    }

    private MyList init(int size) {
        MyList list = new MyLinkedList();
        for (int i = 100; i < 100 + size; i++) {
            list.append(new SingleNode(i));
        }
        return list;
    }
}
