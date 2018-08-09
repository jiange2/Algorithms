package com.jiange2.argorithms.lintcode;


import java.util.Stack;

public class P12MinStack {

    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public P12MinStack() {}

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        if(mainStack.isEmpty()){
            minStack.push(number);
        }else{
            if(number <= min()){
                minStack.push(number);
            }
        }
        mainStack.push(number);
        System.out.println(min());
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int r = mainStack.pop();
        if(r == min()){
            minStack.pop();
        }
        System.out.println(min());
        return r;
    }

    /*
     * @return: An integer
     */
    public int min() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }


}
