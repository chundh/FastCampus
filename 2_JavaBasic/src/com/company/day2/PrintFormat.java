package com.company.day2;

import java.util.Scanner;

public class PrintFormat {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int id = scanner.nextInt();
        scanner.nextLine();
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        s1 = s1.replaceAll(" ",  "");
        s2 = s2.replaceAll(" ",  "");
        System.out.println("*----------*--------*---------------*");
        System.out.printf("| ID%06d | %-5s | %-10s | \n", id, s1, s2);
        System.out.println("*----------*--------*---------------*");
        scanner.close();
    }
}
