package com.company.day1;

public class DomainReverse {
    public static void main(String args[]){
        //Scanner sc = new Scanner(System.in);
        String string = "www.google.com";
        int min = 0;
        int spot = 0;
        String answer = "";
        for(int i=0; i<string.length(); i++){
            if(string.charAt(i)=='.'){
                spot = i;
                for(int j=spot-1; j>=min; j--){
                    answer += string.charAt(j);
                }
                answer+= ".";
                min = spot+1;
            }
            if(i == string.length()-1){
                for(int j=i; j>=min; j--){
                    answer += string.charAt(j);
                }
            }

        }
        System.out.println(answer);
    }
}
