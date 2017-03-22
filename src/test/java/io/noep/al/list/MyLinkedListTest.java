package io.noep.al.list;

import io.noep.al.list.impl.MyLinkedList;
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
        list.append(new Node(101));
        list.append(new Node(102));

        assertEquals(list.getNode().getData(), 100);
        assertEquals(list.getNode().getNode().getData(), 101);
        assertEquals(list.getNode().getNode().getNode().getData(), 102);
        assertNull(list.getNode().getNode().getNode().getNode());
    }

    @Test
    public void appendTest() {
        MyList list = new MyLinkedList();
        list.append(new Node(100));
        list.append(new Node(101));
        list.append(new Node(102));

        assertEquals(list.getNode().getData(), 100);
        assertEquals(list.getNode().getNode().getData(), 101);
        assertEquals(list.getNode().getNode().getNode().getData(), 102);
        assertNull(list.getNode().getNode().getNode().getNode());
    }


}
