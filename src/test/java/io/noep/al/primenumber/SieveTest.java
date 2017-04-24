package io.noep.al.primenumber;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Taehoon Yoo
 * User  : noep
 * Date  : 2017. 4. 25.
 * Time  : AM 1:51
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  : 소수를 구하자
 */
public class SieveTest {

    private Sieve sieve;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {
        sieve = new EratosthenesSieveImpl();
    }

    @Test
    public void exceptionTest() {

        expectedException.expect(AssertionError.class);
        sieve.getPrimeNumber(0);
    }

    @Test
    public void singleTest() {

        assertEquals(sieve.getPrimeNumber(1), 2);
//        assertEquals(sieve.getPrimeNumber(2), 3);
//        assertEquals(sieve.getPrimeNumber(3), 5);
//        assertEquals(sieve.getPrimeNumber(4), 7);
//        assertEquals(sieve.getPrimeNumber(5), 11);
    }

    @Test
    public void arrayTest() {
        assertEquals(sieve.getPrimeNumbers(20), new int[]{2, 3, 5, 7, 11, 13, 17, 19});
    }

    @Test
    public void sqrtTest() {

        assertEquals(Math.sqrt(1), 1, 0.1);
        assertEquals(Math.sqrt(2), 1.4, 0.1);
    }
}
