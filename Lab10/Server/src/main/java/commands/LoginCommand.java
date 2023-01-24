package commands;

import server.Server;
import user.User;

import java.util.List;

/**
 * authorises the user
 */
public class LoginCommand extends Command{
    @Override
    public String execute(User user, Server server, String message) {
        List<String> parameters = getParameter(message, 6);
        user.setName(parameters.get(0));
        if(checkAndLog(user.getName(), user)){
            return "login successful";
        }
        return "login unsuccessful";
    }

    /**
     *
     * @param name name of the user
     * @param user the user object
     * @return if the user exists in the db
     */
    public static boolean checkAndLog(String name, User user){
        if(RegisterCommand.checkIfRegistered(name)){
            user.setLogged(true);
            return true;
        }
        return false;
    }
}
