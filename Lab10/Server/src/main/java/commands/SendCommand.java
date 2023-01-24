package commands;

import server.Server;
import user.User;

import java.util.List;

/**
 * sends text to the user
 */
public class SendCommand extends Command {

    /**
     * sends a message to the user
     * @param user the user
     * @param server the server
     * @param message the message
     * @return state of the execution
     */
    @Override
    public String execute(User user, Server server, String message) {
        List<String> commandMessage = Command.getParameter(message, 4);
        List<String> userList = user.getFriendsList();
        if(userList.isEmpty()) return "empty list of friends";
        for(String friendName: userList) {
            server.sendMessageTo(user.getName(), friendName, commandMessage.get(0));
        }
        return "sending successful";
    }
}