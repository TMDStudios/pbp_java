package wordpress.tmdstudios.pbp_java;

import java.util.Scanner;

public class Calculator {

    public void start(){
        Scanner reader = new Scanner(System.in);

        System.out.println("Starting Calculator");
        System.out.println("Press 'Enter' to continue");
        reader.nextLine();

        while (true){
            System.out.println("Enter first number: ");
            String number1 = reader.nextLine();
            if(numCheck(number1)){
                System.out.println(number1);
                System.out.println("Enter operator: ");
                String op = reader.nextLine();
                if(op.length()==0){op=" ";} // Ensure the first character in op exists
                if(op.charAt(0)=='+'||op.charAt(0)=='-'||op.charAt(0)=='*'||op.charAt(0)=='/'){
                    System.out.println(number1+op);
                    System.out.println("Enter second number: ");
                    String number2 = reader.nextLine();
                    if(numCheck(number2)){
                        if(op.charAt(0)=='/'&&(Float.parseFloat(number1)==0f||Float.parseFloat(number2)==0f)){
                            System.out.println("You cannot divide by 0");
                        }else{
                            System.out.println(number1+op+number2+" = "+calculate(
                                    Float.parseFloat(number1),
                                    op.charAt(0),
                                    Float.parseFloat(number2)));
                            break;
                        }
                    }
                }else{
                    System.out.println("Invalid Operator");
                }
            }
        }

        System.out.println();
        System.out.println("Press 'Enter' to continue");
        reader.nextLine();
    }

    public float calculate(float num1, char operator, float num2){
        switch (operator){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                return num1 / num2;
        }
    }

    private boolean numCheck(String num){
        try{
            Float.parseFloat(num);
            return true;
        }catch(NumberFormatException e){
            System.out.println("Invalid number");
            return false;
        }
    }

}
