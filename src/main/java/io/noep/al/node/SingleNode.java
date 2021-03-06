package io.noep.al.node;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 3. 23.
 * Time  : 오전 1:13
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
@Getter
@Setter
@NoArgsConstructor
public class SingleNode extends Node {

    private SingleNode next;

    public SingleNode(int data) {
        this.data = data;
    }

    @Override
    public Node getNext() {
        return next;
    }
}
