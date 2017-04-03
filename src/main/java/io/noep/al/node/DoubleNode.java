package io.noep.al.node;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 3. 25.
 * Time  : 오후 10:50
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
@Getter
@Setter
@NoArgsConstructor
public class DoubleNode extends Node {

    private DoubleNode previous;
    private DoubleNode next;

    public DoubleNode(int data) {
        this.data = data;
    }

    @Override
    public DoubleNode getNext() {
        return next;
    }

    public DoubleNode getPrevious() {
        return this.previous;
    }
}
