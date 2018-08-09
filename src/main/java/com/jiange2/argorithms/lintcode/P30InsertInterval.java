package com.jiange2.argorithms.lintcode;

import java.util.ArrayList;
import java.util.List;

public class P30InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> list = new ArrayList<>();

        boolean finish = false;

        for (Interval interval : intervals) {
            if (finish) {
                list.add(interval);
            } else if (newInterval.start < interval.start) {
                if (newInterval.end < interval.start) {
                    list.add(newInterval);
                    list.add(interval);
                    finish = true;
                } else if (newInterval.end <= interval.end) {
                    newInterval.end = interval.end;
                    list.add(newInterval);
                    finish = true;
                }
            } else {
                if (newInterval.start <= interval.end) {
                    if (newInterval.end <= interval.end) {
                        list.add(interval);
                    } else {
                        newInterval.start = interval.start;
                    }
                } else {
                    list.add(interval);
                }
            }
        }

        if(!finish){
            list.add(newInterval);
        }

        return list;
    }

    class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}