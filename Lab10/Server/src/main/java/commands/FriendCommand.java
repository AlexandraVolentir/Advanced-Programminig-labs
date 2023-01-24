package commands;

import server.Server;
import user.User;

import java.util.List;

/**
 * adds a friend to the user
 */
public class FriendCommand extends Command{
    @Override
    public String execute(User user, Server server, String message) {
        System.out.println("Am fost pe aici");
        List<String> friends = Command.getParameter(message,  7);
        for(String friendName: friends) {
            if(RegisterCommand.checkIfRegistered(friendName)){
                System.out.println("am adaugat prieten");
                user.addFriend(friendName);
                return "friend added successfully";
            }
        }
        System.out.println("Am fost pe aici 2");
        return "Inexistent user. Impossible to add to friends";
    }
}
