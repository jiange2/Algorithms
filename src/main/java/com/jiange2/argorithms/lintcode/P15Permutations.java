package com.jiange2.argorithms.lintcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums.length > 0){
            Arrays.sort(nums);
            permute(nums,0,lists);
        } else{
            lists.add(new ArrayList<>());
        }
        return lists;
    }

    private void permute(int[] nums,int start,List<List<Integer>> lists){
        if(start == nums.length-1){
            List<Integer> list = new ArrayList<>();
            listAddAllArray(list,nums);
            lists.add(list);
            return;
        }

        permute(nums,start+1,lists);
        for (int i = start+1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]){
                moveRight(nums,start,i);
                permute(nums,start+1,lists);
                moveLeft(nums,start,i);
            }
        }
    }

    private void listAddAllArray(List<Integer> list, int[] nums){
        for (int num : nums) {
            list.add(num);
        }
    }

    private void moveRight(int[] nums,int start,int end){
        int t = nums[end];
        System.arraycopy(nums, start, nums, start + 1, end - start);
        nums[start] = t;
    }

    private void moveLeft(int[] nums,int start,int end){
        int t = nums[start];
        System.arraycopy(nums, start+ 1, nums, start, end - start);
        nums[end] = t;
    }

    @Test
    public void test(){
        int[] a = {1,2,3,4,5};
        printList(permute(a));
    }

    private void printList(List<List<Integer>> lists){
        for(List<Integer> list : lists){
            for(Integer i : list){
                System.out.print(i+" ");
            }
            System.out.println("");
        }
    }
}
