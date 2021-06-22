public class Lab1 {
/*
 * Author: Haaris Alam
 * Assignment: Lab 1
 * Date: June 17, 2021
 */
    public static void main(String[] args) {
        //for each number from 1 - 100
        for (int i = 1; i <= 100; i++) {
            //if i is divisible by 3 and 5
            if ((i % 3) + (i % 5) == 0) {
                System.out.println("FizzBuzz");
            }
            //if i is divisible by 3
            else if (i % 3 == 0) {
                System.out.println("Fizz");
            }
            //if i is divisible by 5
            else if (i % 5 == 0) {
                System.out.println("Buzz");
            }
            else {
                System.out.println(i);
            }
        }
    }

}
