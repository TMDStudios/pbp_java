package wordpress.tmdstudios.pbp_java;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumbersGame {

    public void game(){
        Scanner reader = new Scanner(System.in);
        int answer = new Random().nextInt(10);
        int count = 0;

        System.out.println("Starting Numbers Game");
        System.out.println("Press 'Enter' to continue");
        reader.nextLine();

        while(count<3){
            System.out.println("Guess a number between 0 and 10:");
            try{
                int guess = reader.nextInt();
                if(guess == answer){
                    System.out.println("You got it!");
                }else{
                    if(count==2){
                        System.out.println("You lose. The number was "+answer+".");
                        break;
                    }else{
                        System.out.println("Try again");
                    }
                    count++;
                    System.out.println("You have guessed "+count+" time(s).");
                }
            }catch(InputMismatchException e){
                System.out.println("Please enter numbers only.");
            }
        }
        System.out.println("Game Finished");
    }

}
