package io.noep.al.list;

import io.noep.al.list.impl.MyCircularLinkedList;
import io.noep.al.node.DoubleNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 4. 3.
 * Time  : 오후 9:13
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public class MyCircularLinkedListTest {

    @Test
    public void initTest() {
        MyCircularLinkedList list = new MyCircularLinkedList();

        list.init(100);
        assertEquals(list.getNode().getData(), 100);
        assertEquals(list.getNode().getNext().getData(), 100); // 다음 노드도 자기자신
        assertEquals(list.getNode().getPrevious().getData(), 100); // 전 노드도 자기자신
    }

    @Test
    public void appendTest() {
        MyCircularLinkedList list = new MyCircularLinkedList();
        list.append(new DoubleNode(100));
        assertEquals(list.getNode().getData(), 100);
        assertEquals(list.getNode().getNext().getData(), 100); // 다음 노드도 자기자신
        assertEquals(list.getNode().getPrevious().getData(), 100); // 전 노드도 자기자신

        list.append(new DoubleNode(101));
        assertEquals(list.getNode().getNext().getData(), 101);
        assertEquals(list.getNode().getNext().getNext().getData(), 100);
        assertEquals(list.getNode().getPrevious().getData(), 101);
        assertEquals(list.getNode().getPrevious().getPrevious().getData(), 100);

        list.append(new DoubleNode(102));
        assertEquals(list.getNode().getNext().getData(), 101);
        assertEquals(list.getNode().getNext().getNext().getData(), 102);
        assertEquals(list.getNode().getNext().getNext().getNext().getData(), 100);

        assertEquals(list.getNode().getPrevious().getData(), 102);
        assertEquals(list.getNode().getPrevious().getPrevious().getData(), 101);
        assertEquals(list.getNode().getPrevious().getPrevious().getPrevious().getData(), 100);
    }

    @Test
    public void sizeTest() {
        MyCircularLinkedList list = new MyCircularLinkedList();
        list.append(new DoubleNode(100));
        list.append(new DoubleNode(101));
        list.append(new DoubleNode(102));
        assertEquals(list.size(), 3);
    }

    @Test
    public void searchTest() {
        MyCircularLinkedList list = new MyCircularLinkedList();
        list.append(new DoubleNode(100));
        list.append(new DoubleNode(101));
        list.append(new DoubleNode(102));

        assertEquals(list.search(0).getData(), 100);
        assertEquals(list.search(1).getData(), 101);
        assertEquals(list.search(2).getData(), 102);
    }

    @Test
    public void deleteTest() {
        MyCircularLinkedList list1 = init(4);
        list1.delete(0);
        assertEquals(list1.getNode().getData(), 101);
        assertEquals(list1.getNode().getNext().getPrevious().getData(), 101);
        assertEquals(list1.getNode().getNext().getData(), 102);
        assertEquals(list1.getNode().getNext().getNext().getData(), 103);

        MyCircularLinkedList list2 = init(4);
        list2.delete(1);
        assertEquals(list2.getNode().getData(), 100);
//        assertEquals(list2.getNode().getNext().getPrevious().getData(), 100);
        assertEquals(list2.getNode().getNext().getData(), 102);
        assertEquals(list2.getNode().getNext().getNext().getData(), 103);

        MyCircularLinkedList list3 = init(4);
        list3.delete(2);
        assertEquals(list3.getNode().getData(), 100);
        assertEquals(list3.getNode().getNext().getPrevious().getData(), 100);
        assertEquals(list3.getNode().getNext().getData(), 101);
        assertEquals(list3.getNode().getNext().getNext().getData(), 103);

        MyCircularLinkedList list4 = init(4);
        list4.delete(3);
        assertEquals(list4.getNode().getData(), 100);
        assertEquals(list4.getNode().getNext().getPrevious().getData(), 100);
        assertEquals(list4.getNode().getNext().getData(), 101);
        assertEquals(list4.getNode().getNext().getNext().getData(), 102);

    }

    @Test
    public void test() {
        int x = 1;
        int i = 1;
        while ( x <= 1000 ) {
            x = (int) Math.pow(2, x);
            i = i + 1;
        }
        System.out.println(i);
    }

    @Test
    public void test2() {

        System.out.println(test3());


    }
    public int test3() {
        int cnt = 0;
        for (int i = 0; i <= 1024; ++i) {
//        # & 는 bit 논리곱(and) 연산이다.
            if ((i & (i - 1)) == 0) {
                ++cnt;
            }
        }
        return cnt;
    }



    private MyCircularLinkedList init(int size) {
        MyCircularLinkedList list = new MyCircularLinkedList();
        for (int i = 100; i < 100 + size; i++) {
            list.append(new DoubleNode(i));
        }
        return list;
    }
}
