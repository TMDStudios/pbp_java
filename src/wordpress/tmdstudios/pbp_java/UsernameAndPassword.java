package wordpress.tmdstudios.pbp_java;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;
import java.util.Scanner;

public class UsernameAndPassword {
    String[] users = {"Sam", "Frank", "Jane"};
    char[] specialCharacters = {'!', '@', '#', '$'};
    boolean nameCheck = false;

    String username = "";
    String password = "";

    public void start(){
        Scanner reader = new Scanner(System.in);

        System.out.println("Starting Username and Password");
        System.out.println("Press 'Enter' to continue");
        reader.nextLine();

        while(true){
            if(!nameCheck){
                System.out.println("Enter your username: ");
                username = reader.nextLine();
                if(nameAvailable(username)){
                    if(!numberFound(username)){
                        if(username.length() >= 3 && username.length() <= 14){
                            nameCheck = true;
                            System.out.println("Username created");
                        }else{
                            System.out.println("Username must be between 3 and 14 characters long");
                        }
                    }else{
                        System.out.println("Username cannot contain numbers");
                    }
                }else{
                    System.out.println("Please choose another username");
                }
            }else{
                System.out.println("Enter your password: ");
                password = reader.nextLine();
                if(capsFound(password)){
                    if(specialFound(password)){
                        if(numberFound(password)){
                            if(password.length() > 7){
                                System.out.println("Your username is "+username+" and your password is "+password);
                                System.out.println("Press 'Enter' to continue");
                                reader.nextLine();
                                nameCheck = false;
                                break;
                            }else{
                                System.out.println("Password must be at least 8 characters long");
                            }
                        }else{
                            System.out.println("Password must contain a number");
                        }
                    }else{
                        System.out.println("Password must contain a special character ('!', '@', '#', '$')");
                    }
                }else{
                    System.out.println("Password must contain a capital letter");
                }
            }
        }
    }

    private boolean nameAvailable(String name){
        return !Arrays.asList(users).contains(StringUtils.capitalize(name));
    }

    private boolean numberFound(String name){
        for(int i = 0; i < name.length(); i++){
            if(Character.isDigit(name.charAt(i))){return true;}
        }
        return false;
    }

    private boolean capsFound(String pw){
        for(int i = 0; i < pw.length(); i++){
            if(Character.isUpperCase(pw.charAt(i))){return true;}
        }
        return false;
    }

    private boolean specialFound(String pw){
        for(int i = 0; i < pw.length(); i++){
            if(new String(specialCharacters).indexOf(pw.charAt(i))>=0){return true;}
        }
        return false;
    }
}
