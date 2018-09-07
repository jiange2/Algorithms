package com.jiange2.argorithms.leetcode

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class P27RemoveElementTest extends Specification {

    @Shared
    public P27RemoveElement p27 = new P27RemoveElement()

    void "should return #expectNums.size() given #nums"() {
        given:
        int[] input = toIntArray(nums)
        int[] expect = toIntArray(expectNums)

        when:
        int len = p27.removeElement(input, val)

        then:
        expect.length == len
        startWith(expect, input)

        where:
        nums                     | val || expectNums
        [1]                      | 2   || [1]
        [1]                      | 1   || []
        [0, 1, 2, 2, 3, 0, 4, 2] | 2   || [0, 1, 3, 0, 4]
    }

    int[] toIntArray(List<Integer> integers) {
        int[] res = new int[integers.size()]
        integers.eachWithIndex { item, index ->
            res[index] = item
        }
    }

    boolean startWith(int[] src, int[] target) {
        for (int i = 0; i < src.length; i++) {
            if (i >= target.length || src[i] != target[i]) {
                return false
            }
        }
        return true
    }
}
