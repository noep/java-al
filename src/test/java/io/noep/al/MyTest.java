package io.noep.al;


import org.junit.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 3. 23.
 * Time  : 오전 1:03
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */

public class MyTest {

    @Test
    public void test() {

        MyClassTest myClassTest = new MyClassTest();
        assertEquals(myClassTest.getTest(), "print");
        assertThat("print", is("print"));
    }

    @Test
    public void test2() {
        MyClassTest myClassTest = new MyClassTest();
        assertNotEquals(myClassTest.getTest(), "actual");

    }
}
