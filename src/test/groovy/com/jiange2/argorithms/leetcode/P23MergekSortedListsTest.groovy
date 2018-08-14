package com.jiange2.argorithms.leetcode

import com.jiange2.struct.ListNode
import spock.lang.Shared
import spock.lang.Specification

class P23MergekSortedListsTest extends Specification {

    @Shared
    public P23MergekSortedLists p = new P23MergekSortedLists()

    def "GenerateParenthesis"() {
        when:
        ListNode[] listNodes = new ListNode[lists.size()]
        int index = 0
        (lists as List).each { item ->
            listNodes[index++] = new ListNode(item as List)
        }

        then:
        p.mergeKLists(listNodes) == new ListNode(expect)

        where:
        lists                          || expect
   //     [[1], [2], [3]]                || [1, 2, 3]
        [[1, 4, 5], [1, 3, 4], [2, 6]] || [1, 1, 2, 3, 4, 4, 5, 6]
    }
}
