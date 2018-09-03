package com.jiange2.argorithms.leetcode

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class P26RemoveDuplicatesfromSortedArrayTest extends Specification {

    @Shared
    public P26RemoveDuplicatesfromSortedArray p = new P26RemoveDuplicatesfromSortedArray()

    public void setupSpec() {
        ArrayList.class.metaClass.startWith = { List list ->
            List self = delegate as List
            for (int i = 0; i < list.size(); i++) {
                if (i >= self.size() || list.get(i) != self.get(i))
                    return false
            }
            return true
        }
    }

    public "Should return #expectCount given #arr when call removeDuplicates"() {
        given:
        int[] nums = toIntArray(arr)

        expect:
        p.removeDuplicates(nums) == expectCount
        startWith(nums, toIntArray(expectArr))

        where:
        arr          || expectCount | expectArr
        []           || 0           | []
        [0]          || 1           | [0]
        [0, 0]       || 1           | [0]
        [0, 0, 1, 1] || 2           | [0, 1]
    }

    public boolean startWith(int[] src, int[] tar){
        for (int i = 0; i < tar.length; i++) {
            if(i >= src.length || src[i] != tar[i]) return false
        }

        return true
    }

    public int[] toIntArray(List<Integer> arr) {
        int[] nums = new int[arr.size()]
        for (int i = 0; i < arr.size(); i++) {
            nums[i] = arr[i]
        }
        return nums
    }
}
