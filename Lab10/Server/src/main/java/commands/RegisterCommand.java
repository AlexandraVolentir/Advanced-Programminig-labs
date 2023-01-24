package commands;

import server.Server;
import user.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * register the user
 */
public class RegisterCommand extends Command{
    @Override
    public String execute(User user, Server server, String message) {
        List<String> parameters = getParameter(message, 9);
        if(!checkIfRegistered(parameters.get(0))){
            addNewUser(parameters.get(0));
            return "user login successful";
        }
        return "user login unsuccessful";
    }

    /**
     * checks if the user exists in the database
     * @param name the name of the user
     * @return truth statement if the user exists
     */
    public static boolean checkIfRegistered(String name){
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/registered_users.txt"))) {
            String line;
            line = br.readLine();
            List<String> listNames = Arrays.asList(line.trim().split(" "));
            if(listNames.contains(name)) return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    /**
     * adds a new user to the database
     * @param name the name of the user
     */
    public static void addNewUser(String name){
        try {
            Files.write(Paths.get("src/main/resources/registered_users.txt"), (" " + name).getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            System.out.println("Adding new user failed. I/O Error");
        }
    }

    public static int getNumberOfUsers(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/registered_users.txt"))) {
            String line;
            line = br.readLine();
            List<String> listNames = Arrays.asList(line.trim().split(" "));
            return listNames.size();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
