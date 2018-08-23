package com.jiange2.argorithms.leetcode

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class P796RotateStringTest extends Specification {

    @Shared
    public P796RotateString p = new P796RotateString()

    def "should return #output when input a = #a and b = #b"() {

        expect:
        p.rotateString(a, b) == output

        where:
        a       | b       || output
        null    | null    || true
        null    | 'abc'   || false
        'abc'   | null    || false
        ''      | ''      || true
        'abcde' | 'cdeab' || true
        'abcde' | 'abced' || false
    }
}
