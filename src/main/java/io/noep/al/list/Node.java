package io.noep.al.list;

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
public class Node {

    private int data;
    private Node node;

    public Node(int data) {
        this.data = data;
    }
}
