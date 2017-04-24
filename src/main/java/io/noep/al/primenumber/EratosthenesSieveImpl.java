package io.noep.al.primenumber;

/**
 * Created by Taehoon Yoo
 * User  : noep
 * Date  : 2017. 4. 25.
 * Time  : AM 1:46
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  : 에라토스테네스의 체를 만들어보자
 * http://ledgku.tistory.com/61
 */
public class EratosthenesSieveImpl implements Sieve {

    public int getPrimeNumber(int index) {
        assert index > 0;

        int count = 0;
        int primeNumber = 1;

        while (count < index) {

            if (primeNumber % 2 == 0) {
                primeNumber++;
            }


            count++;
        }

        return primeNumber;
    }

    public int[] getPrimeNumbers(int max) {
        assert max > 1;
        return new int[0];
    }
}
