package com.company.day3;

public class ThreeSixNineAdvanced {
    public static void main(String args[]){
        int gameLength = 1000;
        int numPeople = 12;
        int myTurn = 3;
        for(int i=myTurn; i<=gameLength; i+=numPeople){
            String a = String.valueOf(i);
            if(a.contains("3") || a.contains("6") || a.contains("9") || a.contains("5")){
                String[] arr = a.split("");
                int hand = 0;
                int foot = 0;
                for(int j=0; j<arr.length; j++){
                    if(arr[j].equals("3") || arr[j].equals("6") || arr[j].equals("9"))
                        hand++;
                    if(arr[j].equals("5"))
                        foot++;
                }
                if(hand>foot){
                    while(true) {
                        if(hand==0 && foot ==0)
                            break;
                        if(hand>0) {
                            System.out.print("짝!");
                            hand--;
                        }
                        if(foot>0) {
                            System.out.print("쿵!");
                            foot--;
                        }
                    }
                }
                else{
                    while(true) {
                        if(hand==0 && foot ==0)
                            break;
                        if(foot>0) {
                            System.out.print("쿵!");
                            foot--;
                        }
                        if(hand>0) {
                            System.out.print("짝!");
                            hand--;
                        }
                    }
                }
                System.out.println();
            }
            else{
                System.out.println(a + "!");
            }
        }
    }
}
