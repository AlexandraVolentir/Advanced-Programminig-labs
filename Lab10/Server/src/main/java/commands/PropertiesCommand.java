package commands;

import server.Server;
import server.ThreadHandler;
import user.User;

import java.util.ArrayList;

/**
 * calculates the density and centrality of the network
 */
public class PropertiesCommand extends Command{
    @Override
    public String execute(User user, Server server, String message) {
        float density = 0, centrality = 0;
        ArrayList<Integer> outDegree = new ArrayList<>();
        int numberOfPeople = server.getThreadHandlerList().size();
        int i = 0;
        for(ThreadHandler elm : server.getThreadHandlerList()){
            density += (float)elm.getUser().getNumberOfFriends()/(float)RegisterCommand.getNumberOfUsers();
            outDegree.add(elm.getUser().getNumberOfFriends());
            centrality += elm.getUser().getNumberOfFriends();
        }
        density *= 100;
        centrality /= (RegisterCommand.getNumberOfUsers() + 1);
        return "density: " + density + "; centrality: " + centrality;
    }
}
