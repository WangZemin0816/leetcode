package com.wangzemin.leetcode;

import java.util.HashMap;
import java.util.Map;

class SnapshotArray {

    public static void main(String []args){
        SnapshotArray snapshotArray = new SnapshotArray(3);
        snapshotArray.set(0,5);
        snapshotArray.snap();
        snapshotArray.set(0,6);
        snapshotArray.get(0,0);
    }

    int length = 0;
    int snapId = 0;
    int currentId = -1;
    Map<Integer, Map<Integer, Integer>> idxSnapValue = new HashMap<>();

    public SnapshotArray(int length) {

    }

    public void set(int index, int val) {

        if (idxSnapValue.containsKey(index)) {
            Map<Integer, Integer> snapValue = idxSnapValue.get(index);
            snapValue.put(currentId, val);
            return;
        }
        Map<Integer, Integer> snapValue = new HashMap<>();
        snapValue.put(currentId, val);
        idxSnapValue.put(index, snapValue);
    }

    public int snap() {
        for (int index : idxSnapValue.keySet()) {
            if (!idxSnapValue.containsKey(index)) {
                continue;
            }
            Map<Integer, Integer> snapValue = idxSnapValue.get(index);
            if (!idxSnapValue.containsKey(currentId)) {
                snapValue.put(snapId, 0);
            }
            snapValue.put(snapId, snapValue.get(currentId));
        }
        snapId++;
        return snapId - 1;
    }

    public int get(int index, int snap_id) {
        if (!idxSnapValue.containsKey(index)) {
            return 0;
        }
        Map<Integer, Integer> snapValue = idxSnapValue.get(index);
        if (!snapValue.containsKey(snap_id)) {
            return 0;
        }
        return snapValue.get(snap_id);
    }
}