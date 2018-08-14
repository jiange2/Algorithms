package com.jiange2.argorithms.leetcode

import spock.lang.Shared
import spock.lang.Specification

class P17LetterCombinationsofaPhoneNumberTest extends Specification {
    @Shared
    P17LetterCombinationsofaPhoneNumber p = new P17LetterCombinationsofaPhoneNumber()


    def "LetterCombinations"() {
        expect:
        p.letterCombinations(digit) == expect

        where:
        digit || expect
        "2"   || ["a", "b", "c"]
        "23"  || ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
    }
}
