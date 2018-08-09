package com.jiange2.argorithms.lintcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P16PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length - 1;

        listAddAllArray(lists, nums);
        //最后一个顺序对的第一个数
        int k = n - 1;

        while (k > -1) {

            for (int i = 0; i < 1; i++) {
                
            }
            
            listAddAllArray(lists,nums);
        }

        return lists;
    }

    private void reverse(int[] nums, int i, int j) {
        for (int k = 0; k <= (j - i) / 2; k++) {
            swap(nums, i + k, j - k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void listAddAllArray(List<List<Integer>> lists, int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        lists.add(list);
    }

    @Test
    public void test() {
        int[] a = {1, 2, 3, 4};
        printList(permuteUnique(a));
    }

    private void printList(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.println("");
        }
    }
}
