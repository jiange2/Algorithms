package com.jiange2.argorithms.lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P22FlattenList {

    //递归
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();

        if(nestedList == null)
            return list;

        flatten(nestedList,list);
        return list;
    }

    //迭代
    public List<Integer> flatten2(List<NestedInteger> nestedList) {
        List<Integer> list = new ArrayList<>();

        if(nestedList == null)
            return list;

        Stack<NestedInteger> stack = new Stack<>();

        for (int i = nestedList.size() - 1; i > 0; --i) {
            stack.push(nestedList.get(i));
        }

        while (!stack.isEmpty()){
             NestedInteger t = stack.pop();
             if(t.isInteger()){
                 list.add(t.getInteger());
             }else{
                 List<NestedInteger> tList = t.getList();
                 for (int i = tList.size() - 1; i > 0; --i) {
                     stack.push(tList.get(i));
                 }
             }
        }

        return list;
    }

    private void flatten(List<NestedInteger> nestedList,List<Integer> result){
        for(NestedInteger integer:nestedList){
            if(integer.isInteger()){
                result.add(integer.getInteger());
            }else{
                flatten(integer.getList(),result);
            }
        }
    }



    public interface NestedInteger {
 
      // @return true if this NestedInteger holds a single integer,
      // rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds,
      // if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds,
      // if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
}
