package io.noep.al.list;

import io.noep.al.node.SingleNode;

/**
 * Created by Taehoon Yoo
 * User  : taehoon
 * Date  : 2017. 3. 23.
 * Time  : 오전 1:13
 * Page  : http:noep.github.io
 * Email : noep@naver.com
 * Desc  :
 */
public interface MyList {

    /**
     * 초기화
     */
    void init(int data);

    /**
     * 삭제
     */
    void destroy();

    /**
     * 꼬리에 노드 추가
     * @param newSingleNode
     */
    void append(SingleNode newSingleNode);

    /**
     * 노드 탐색
     */
    SingleNode search(int position);

    /**
     * 특정 위치의 노드 삭제
     */
    void delete(int position);

    /**
     * 특정 위치에 노드 삽입
     */
    void insert(int position, SingleNode newSingleNode);

    /**
     * 노드 개수
     */
    int size();

    SingleNode getNode();
}
