package com.company.day2;

import java.util.Scanner;

public class PrintFormat {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int id = scanner.nextInt();
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        s1 = s1.replaceAll(" ",  "");
        s2 = s2.replaceAll(" ",  "");
        System.out.println("*----------*--------*---------------*");
        System.out.println("| ID00" + id + " | " + s1 + " | " + s2 + "|");
        System.out.println("*----------*--------*---------------*");
    }
}
