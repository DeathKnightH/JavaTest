package cn.dk.algorithm.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 计算多行组件的宽度，形成整体的单元格分组.
 * 每行的宽度，组件数量，每个组件的宽度都不一定。
 * 最终是计算出一个符合所有组件宽的数组并根据这个数组定制 excel 单元格宽度，最终保证整页的宽度可控
 */
public class GlobalColumnWidth {
    public static void main(String[] args) {
        List<List<Integer>> origin = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(1);
        row1.add(3);
        row1.add(10);
        row1.add(5);
        origin.add(row1);
        List<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(4);
        row2.add(4);
        row2.add(4);
        row2.add(4);
        row2.add(4);
        origin.add(row2);
        switchToPrefixArray(origin);
        System.out.println(calculateGlobalWidth(origin));
    }

    private static void switchToPrefixArray(List<List<Integer>> origin){
        for (List<Integer> row : origin) {
            toPreOrderArray(row);
        }
    }

    private static void toPreOrderArray(List<Integer> origin){
        int sum = 0;
        for (int i = 0; i < origin.size(); i++) {
            Integer integer = origin.get(i);
            sum += integer;
            origin.set(i, sum);
        }
    }

    private static List<Integer> calculateGlobalWidth(List<List<Integer>> preOrderArray){
        PriorityQueue<Integer> sort = new PriorityQueue<>();
        Set<Integer> widthSet = new HashSet<>();
        for (List<Integer> row : preOrderArray) {
            for (Integer cellWidth : row) {
                if(!widthSet.contains(cellWidth)){
                    sort.add(cellWidth);
                    widthSet.add(cellWidth);
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!sort.isEmpty()){
            result.add(sort.poll());
        }
        return result;
    }
}
