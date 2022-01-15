package wordpress.tmdstudios.pbp_java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;
        Scanner reader = new Scanner(System.in);
        NumbersGame numbersGame = new NumbersGame();
        Calculator calculator = new Calculator();

        while(!exit){
            printWelcome();
            switch (reader.nextLine()){
                case "1":
                    numbersGame.game();
                    break;
                case "2":
                    calculator.start();
                    break;
                case "3":
                    System.out.println("Launching Guess The Phrase");
                    break;
                case "4":
                    System.out.println("Username and Password");
                    break;
                case "5":
                    exit = true;
                    break;
                default:
                    System.out.println("Please select a valid option");
            }
        }
        System.out.println("Closing Program");
    }

    public static void printWelcome(){
        String message = "This is a collection of select Project Based Python projects";
        for(int i = 0; i<message.length(); i++){System.out.print("*");}
        System.out.println();
        System.out.println(message);
        for(int i = 0; i<message.length(); i++){System.out.print("*");}
        System.out.println();
        System.out.println("Choose from the following menu:");
        System.out.println("1 => Numbers Game");
        System.out.println("2 => Calculator");
        System.out.println("3 => Guess the Phrase");
        System.out.println("4 => Username and Password");
        System.out.println("5 => Quit");
        System.out.print(">>");
    }

}
