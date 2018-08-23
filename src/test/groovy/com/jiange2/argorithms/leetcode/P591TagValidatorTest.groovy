package com.jiange2.argorithms.leetcode

import spock.lang.Shared
import spock.lang.Specification

class P591TagValidatorTest extends Specification {

    @Shared
    public P591TagValidator p = new P591TagValidator()

    def "IsValid"() {
        expect:
        p.isValid(input) == ouput

        where:
        input                                                                               | ouput
        "<A>  <B> </A>   </B>"                                                              | false
        "<DIV>  div tag is not closed  <DIV>"                                               | false
        "<DIV>  unmatched <  </DIV>"                                                        | false
        "<DIV> closed tags with invalid tag name  <b>123</b> </DIV>"                        | false
        "<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>" | false
        "<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>"                | false
        "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"                                | true
        "<DIV>This is the first line <![CDATA[<div>]]></DIV>"                               | true
        ">A<"                                                                               | false
        "<A><!></A>"                                                                        | false
        "<![CDATA[wahaha]]]><![CDATA[]> wahaha]]>"                                          | false
        "<TRUe><![CDATA[123123]]]]><![CDATA[>123123]]></TRUe>"                              | false
        "<A>  <B> </A>   </B>"                                                              | false
        "<A></A><B></B>"                                                                    | false
        "<A><A>/A></A></A>"                                                                 | true
        "<DIV><></></DIV>"                                                                  | false
        "<A<></A<>"                                                                         | false
        "<AAAAAAAAAA></AAAAAAAAAA>"                                                         | false
        "<A"                                                                                | false
        "<A><!CDATAA[[123]]></A>"                                                           | false
    }
}
