package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int listSize = scanner.nextInt();

        ArrayList<Integer> startList = new ArrayList<>();
        ArrayList<Integer> endList = new ArrayList<>();

        for (int i = 0; i < listSize; i++) {
            startList.add(scanner.nextInt());
            endList.add(scanner.nextInt());
        }
        int maxStart = Collections.max(startList);
        int minEnd = Collections.min(endList);

        if (maxStart > minEnd) System.out.println("edward is right");
        else System.out.println("gunilla has a point");

        scanner.close();
    }
}



