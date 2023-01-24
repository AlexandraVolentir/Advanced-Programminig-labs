package commands;

import server.Server;
import user.User;

/**
 * command that logs the user out
 */
public class LogoutCommand extends Command {
    @Override
    public String execute(User user, Server server, String message) {
        user.setLogged(false);
        return "user logged out";
    }
}
