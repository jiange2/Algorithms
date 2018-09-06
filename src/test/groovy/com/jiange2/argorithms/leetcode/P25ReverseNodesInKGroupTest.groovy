package com.jiange2.argorithms.leetcode

import com.jiange2.struct.ListNode
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll


class P25ReverseNodesInKGroupTest extends Specification {

    @Shared
    public P25ReverseNodesInKGroup p25 = new P25ReverseNodesInKGroup()

    public void "should return #expectList given #inputList and group #k"() {
        given:
        ListNode inputListHead = new ListNode(inputList)
        ListNode expectListHead = new ListNode(expectList)

        expect:
        p25.reverseKGroup(inputListHead, k) == expectListHead

        where:
        inputList       | k || expectList
        []              | 1 || []
        [1]             | 1 || [1]
        [1, 2]          | 1 || [1, 2]
        [1, 2, 3]       | 1 || [1, 2, 3]
        [1, 2, 3]       | 2 || [2, 1, 3]
        [1, 2, 3, 4, 5] | 2 || [2, 1, 4, 3, 5]
        [1, 2, 3, 4, 5] | 3 || [3, 2, 1, 4, 5]
    }
}
