package com.jiange2.argorithms.lintcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class P17Subsets {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        if(nums != null){
            Arrays.sort(nums);
            for (int i = 1; i <= nums.length; i++) {
                subsets(nums,0,new Stack<>(),i,lists,null);
            }
        }
        return lists;
    }

    private void subsets(int[] nums, int index, Stack<Integer> stack, int max,List<List<Integer>> lists,Integer lastPop) {
        if (nums.length - index <= max - stack.size()) {
            if(lastPop == null || lastPop != nums[index]){
                List<Integer> list = new ArrayList<>(stack);
                for (int i = index; i < nums.length; i++) {
                    list.add(nums[i]);
                }
                lists.add(list);
            }
        } else if(stack.size() == max){
            lists.add(new ArrayList<>(stack));
        } else {
            //选
            if(lastPop == null || lastPop != nums[index]){
                stack.push(nums[index]);
                subsets(nums, index + 1, stack, max,lists, lastPop);
                lastPop = stack.pop();
            }
            //不选
            subsets(nums, index + 1, stack, max,lists,lastPop);
        }
    }


    @Test
    public void test(){
        int[] a = {1,2,2,2};
        System.out.println(subsets(a));
    }
}
