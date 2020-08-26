package net.robotap;

import net.robotap.Controller.BashCommands;
import net.robotap.Controller.GitHubSingleton;

/**
 * Robotap the app for developers
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Robotap the app for developers" );
        GitHubSingleton gitUser = GitHubSingleton.user();
        gitUser.login("mattbecker5", "MSPress1@1");
        //gitUser.listRepos();

        BashCommands commands = new BashCommands();
        String response = commands.gitClone("https://github.com/200803-java-devops/project0-matthew-becker.git");
        System.out.println(response);
    }
}