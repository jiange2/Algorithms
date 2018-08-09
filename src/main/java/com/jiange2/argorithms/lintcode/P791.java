package com.jiange2.argorithms.lintcode;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class P791 {

    public int mergeNumber(int[] numbers) {

        if (numbers == null || numbers.length < 2) {
            return 0;
        }

        Arrays.sort(numbers);
        System.out.println(Arrays.toString(numbers));
        int start = 0, count = 0;
        while (start < numbers.length - 1) {
            for (int i = start + 1; i < numbers.length; i++) {
                if (numbers[start + 1] < numbers[i]) {
                    numbers[start + 1] += numbers[start];
                    count += numbers[start + 1];
                    numbers[start] = 0;
                    insertRight(numbers, start+1, --i);
                }else if (i + 1 < numbers.length && numbers[i + 1] < numbers[start]) {
                    numbers[i] += numbers[i + 1];
                    count += numbers[i];
                    insertLeft(numbers, start, i);
                    System.arraycopy(numbers, start, numbers, start + 1, i - start + 1);
                    numbers[start] = 0;
                    ++i;
                } else {
                    numbers[i] = numbers[i] + numbers[start];
                    count += numbers[i];
                    numbers[start] = 0;
                }
                ++start;
            }
        }

        return count;
    }

    private void insertRight(int[] numbers, int index, int end) {
        int t = numbers[index];
        while (index < end) {
            if (numbers[index] > numbers[index + 1]) {
                numbers[index] = numbers[index + 1];
                ++index;
            } else {
                break;
            }
        }
        numbers[index] = t;
    }

    private void insertLeft(int[] numbers, int start, int index) {
        int t = numbers[index];
        while (index > start) {
            if (numbers[index] < numbers[index - 1]) {
                numbers[index] = numbers[index - 1];
                --index;
            } else {
                break;
            }
        }
        numbers[index] = t;
    }

    @Test
    public void test() {
        /*int[] a = randArray(10000);
        System.out.println(Arrays.toString(a));
        System.out.println(mergeNumber(a));*/
        int[] a = {2,3,3,3,4,4,5,5,12};
        System.out.println(mergeNumber(a));
    }

    private void printArrayRange(int[] nums, int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.println();
    }

    private int[] randArray(int n) {
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = (int) (Math.random() * 2);
        }
        return r;
    }

    private int[] readData() {
        File f = new File(this.getClass().getResource("/data/lintcode/P791.in").getPath());
        FileInputStream fis = null;
        StringBuilder sb = new StringBuilder();
        try {
            fis = new FileInputStream(f);
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                sb.append(new String(buf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = sb.substring(1, sb.length() - 1);
        String[] numsStr = str.split(",");
        int[] r = new int[numsStr.length];
        for (int i = 0; i < r.length; i++) {
            r[i] = Integer.parseInt(numsStr[i]);
        }
        return r;
    }
}
