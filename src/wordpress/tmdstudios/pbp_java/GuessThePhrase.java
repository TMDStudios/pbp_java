package wordpress.tmdstudios.pbp_java;

import java.util.*;

public class GuessThePhrase {

    public void game(){

        Scanner reader = new Scanner(System.in);

        System.out.println("Starting Guess The Phrase");
        System.out.println("Press 'Enter' to continue");
        reader.nextLine();

        String answer = "this is the secret phrase";

        Map<Integer, Character> myAnswerMap = new HashMap<>();
        StringBuilder myAnswer = new StringBuilder();

        for(int i = 0; i < answer.length(); i++){
            if(answer.charAt(i) == ' '){
                myAnswerMap.put(i, ' ');
                myAnswer.append(' ');
            }else{
                myAnswerMap.put(i, '*');
                myAnswer.append('*');
            }
        }

        StringBuilder guessedLetters = new StringBuilder();
        int count = 0;
        boolean multipleLetters = false;

        System.out.println("Can you decipher the text?");
        System.out.println(myAnswer);

        while(count<10){
            myAnswer = new StringBuilder();
            if(!multipleLetters){
                System.out.println("Guess the full text: ");
                String guessAnswer = reader.nextLine();
                if(Objects.equals(guessAnswer, answer)){ // makes guessAnswer null-safe
                    System.out.println("You win!");
                    break;
                }else{
                    System.out.println("Incorrect guess");
                }
            }
            multipleLetters = false;
            System.out.println("Guess a letter: ");
            String guess = reader.nextLine();

            if(guess.length()==1){
                for(int i = 0; i < answer.length(); i++){
                    if(answer.charAt(i) == guess.charAt(0)){myAnswerMap.put(i, guess.charAt(0));}
                }

                for(Map.Entry<Integer, Character> entry : myAnswerMap.entrySet()){ // enhanced for loop
                    myAnswer.append(entry.getValue());
                }

                if(myAnswer.toString().equals(answer)){
                    System.out.println(myAnswer);
                    System.out.println("You win!");
                    break;
                }

                if(guessedLetters.length() == 0){
                    guessedLetters.append(guess.charAt(0));
                }else{
                    guessedLetters.append(", ").append(guess.charAt(0));
                }

                System.out.println(myAnswer);
                System.out.println("Guessed letters: "+guessedLetters);

                count++;
                int guessesLeft = 10 - count;
                if(count<10){System.out.println(guessesLeft+" guesses remaining");}
            }else{
                if(guess.length()==0){
                    System.out.println("Please enter a letter.");
                }else{
                    System.out.println("Please enter one letter only.");
                }
                multipleLetters = true;
            }
        }
        System.out.println("The phrase was: "+answer);
        System.out.println("Game Over");

        System.out.println();
        System.out.println("Press 'Enter' to continue");
        reader.nextLine();
    }

}
