package wordpress.tmdstudios.pbp_java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean exit = false;
        Scanner reader = new Scanner(System.in);

        while(!exit){
            printWelcome();
            switch (reader.nextLine()){
                case "1":
                    System.out.println("Launching Numbers Game");
                    break;
                case "2":
                    System.out.println("Launching Calculator");
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
        System.out.println();
        for(int i = 0; i<message.length(); i++){
            System.out.print("*");
        }
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
