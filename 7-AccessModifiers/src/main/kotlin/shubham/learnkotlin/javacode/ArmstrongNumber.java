package shubham.learnkotlin.javacode;

import java.util.Scanner;

public class ArmstrongNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = scanner.nextInt();
        int t1 = number, length = 0;

        while(t1 != 0){

            t1 = t1/10;
            length = length + 1;
        }

        System.out.println("Length: " + length);

        int t2 = number;
        int arm = 0;
        int rem;

        while(t2 != 0) {

            rem = t2%10;
            int mult = 1;

            for(int i = 1; i <= length; i++){

                mult = mult * rem;

            }

            arm = arm + mult;
            t2 = t2/10;

            System.out.println("Armstrong: " + arm);

        }

        if(number == arm){
            System.out.println(number + " is an armstrong number");
        }  else {
            System.out.println(number + " is not an armstrong number");
        }

    }

}
