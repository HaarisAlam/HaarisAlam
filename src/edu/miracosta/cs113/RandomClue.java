package edu.miracosta.cs113;

/**
 * RandomClue.java : Ask the AssistantJack object and get the correct
 * answer in <= 20 tries.  RandomClue is ONE solution to the problem,
 * where arrays are used for persons, weapons, and locations. If 
 * AssistantJack says that the person/weapon/location is incorrect, 
 * then the array location for the the person/weapon/location has a 
 * value of 99 for incorrect. Using this logic and randomly generated 
 * numbers, AssistantJack is called until there is a match to the solution 
 * from the AssistantJack object.
 *
 * 
 *
 * @author Haaris Alam
 * @version 1.0
 *
 */

import java.util.Random;
import java.util.Scanner;

import model.Theory;
import model.AssistantJack;

public class RandomClue {

    /*
     * ALGORITHM:
     *
     * PROMPT "Which theory to test? (1, 2, 3[random]): "
     * READ answerSet
     * INSTANTIATE jack = new AssistantJack(answerSet)
     * DO
     *      weapon = random int between 1 and 6
     *      location = random int between 1 and 10
     *      murder = random int between 1 and 6
     *      solution = jack.checkAnswer(weapon, location, murder)
     * WHILE solution != 0
     *
     * OUTPUT "Total checks = " + jack.getTimesAsked()
     * IF jack.getTimesAsked() is greater than 20 THEN
     *      OUTPUT "FAILED"
     * ELSE
     *      OUTPUT "PASSED"
     * END IF
     */

    /**
     * Driver method for random guessing approach
     *
     * @param args not used for driver
     */
    public static void main(String[] args) {
        // DECLARATION + INITIALIZATION
        int[] murderers = new int[6];
        int[] locations = new int[10];
        int[] weapons = new int[6];

        int answerSet, solution;
        int murder = 1;
        int weapon = 1;
        int location = 1;
        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();
        int status = 0;

        // INPUT
       System.out.print("Which theory would like you like to test? (1, 2, 3[random]): ");
        answerSet = keyboard.nextInt();
       keyboard.close();

        // PROCESSING
        jack = new AssistantJack(answerSet);

        do {
            for (int i = 0; i < 6; i++) {
                status = weapons[i];
                if (status == 0) {
                    weapon = i + 1;
                    i = 6;
                }
            } 
            
            for (int i = 0; i < 6; i++) {
                status = murderers[i];
                if (status == 0) {
                    murder = i +1;
                    i = 6;
                }
            } 
            
            for (int i = 0; i < 10; i++) {
                status = locations[i];
                if (status == 0) {
                    location = i +1;
                    i = 10;
                }
            } 

            solution = jack.checkAnswer(weapon, location, murder);
            if (solution == 1) {
                weapons[weapon - 1] = 99;
            } else if (solution == 2) {
                locations[location - 1] = 99;
            } else if (solution == 3) {
                murderers[murder - 1] = 99;
            }
        } while (solution != 0);


        answer = new Theory(weapon, location, murder);

        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

    }

}
