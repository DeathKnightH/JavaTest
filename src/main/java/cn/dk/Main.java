package cn.dk;


import cn.dk.algorithm.leetcode.HouseRobberII;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        int[] houses = new int[]{1, 7, 9, 2};
        HouseRobberII.dynamicProgram(houses);
    }
}
