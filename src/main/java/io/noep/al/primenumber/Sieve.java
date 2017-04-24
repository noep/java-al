package io.noep.al.primenumber;

/**
 * Created by Taehoon Yoo
 * User  : noep
 * Date  : 2017. 4. 25.
 * Time  : AM 1:43
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  : Sieve는 체라는 뜻이다
 */
public interface Sieve {

    /**
     * index번째의 소수를 구한다.
     * @param index
     * @return
     */
    int getPrimeNumber(int index);


    /**
     * 0 이상 max 이하의 수 중 소수인 수들을 출력한다.
     * @param max
     * @return
     */
    int[] getPrimeNumbers(int max);
}
