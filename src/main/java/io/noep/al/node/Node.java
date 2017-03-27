package io.noep.al.node;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 3. 27.
 * Time  : 오후 10:06
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
@Getter
@Setter
public abstract class Node {
    protected int data;

    public abstract Node getNext();
}
