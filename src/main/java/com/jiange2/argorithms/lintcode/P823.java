package com.jiange2.argorithms.lintcode;

import org.junit.Test;

public class P823 {

    public String inputStream(String inputA, String inputB) {
        char[] charsA = inputA.toCharArray();
        char[] charsB = inputB.toCharArray();

        int indexA = charsA.length - 1,indexB = charsB.length - 1;
        while ( indexA > 0 && indexB > 0){

            indexA = findCharIndex(indexA,charsA);
            indexB = findCharIndex(indexB,charsB);

            if(!(indexA >= 0 && indexB >= 0 && charsA[indexA] == charsB[indexB])){
                return indexA == -1 && indexB == -1 ? "YES" : "NO";
            }else{
                --indexA;
                --indexB;
            }
        }

        return "YES";
    }

    private int findCharIndex(int index,char[] chars){
        int count = 0;
        while (index > 0){
            if(chars[index] == '<'){
                ++count;
            }else{
                if(count > 0){
                    --count;
                }else{
                    return index;
                }
            }
            --index;
        }

        return -1;
    }

    @Test
    public void test(){
        String inputA = "a<<bc";
        String inputB = "b<bc";
        System.out.println(inputStream(inputA, inputB));
    }
}
