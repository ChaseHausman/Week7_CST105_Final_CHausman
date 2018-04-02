/**
 * Program: Final
 * File: NFLPlayerManagerTestDriver.java
 * Summary: Runs through some demonstrations showing how the NFLPlayerManager class works
 * Author: Chase Hausman
 * Date: March 18, 2018
 */
public class NFLPlayerManagerTestDriver {
    public static void main(String args[]) {
        // Start by creating a new NFLPlayerManager, and then print it to the console as a String
        System.out.println("Creating a new NFLPlayerManager without any arguments.");
        NFLPlayerManager manager = new NFLPlayerManager();
        System.out.println(manager);

        // Call the create players method
        System.out.println("\n\n After calling the createPlayers() method: ");
        manager.createPlayers();
        System.out.println(manager);

        // Get the second player, change their name, set the player, then re-display all the players.
        System.out.println("\n\n Making a change to a specific player by their index.");

        NFLPlayer testPlayer = manager.getPlayer(1);
        testPlayer.setName("Tiger Lily");
        manager.setPlayer(1, testPlayer);
        System.out.println(manager);

        // Display how many players are part of the group
        System.out.println("\n\n There are "+manager.getNumberOfPlayers()+" players involved at the moment.");
    }
}
