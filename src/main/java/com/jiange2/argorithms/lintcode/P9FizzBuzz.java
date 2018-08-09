package com.jiange2.argorithms.lintcode;

import java.util.ArrayList;
import java.util.List;

public class P9FizzBuzz {
    /*
     * @param n: An integer
     * @return: A list of strings.
     */
    public List<String> fizzBuzz(int n) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
              if(i % 15 == 0){
                  list.add("fizz buzz");
              }else if(i % 3 == 0){
                  list.add("fizz");
              }else if(i % 5 == 0){
                  list.add("buzz");
              }else{
                  list.add(String.valueOf(i));
              }
        }

        return list;
    }


}
