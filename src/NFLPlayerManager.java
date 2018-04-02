/**
 * Program: Final
 * File: NFLPlayerManager.java
 * Summary: Custom implementation of an ArrayList on a specific group of players.
 * Author: Chase Hausman
 * Date: March 17, 2018
 */

import java.util.ArrayList;

public class NFLPlayerManager {
    // The only thing we're currently storing is who the players are.
    private ArrayList<NFLPlayer> players;

    // Creation without any details.
    public NFLPlayerManager() {
        this.players = new ArrayList<NFLPlayer>(6);
    }

    // Creation knowing the number of players, but not who they are
    public NFLPlayerManager(int numberOfPlayers) {
        this.players = new ArrayList<NFLPlayer>(numberOfPlayers);
    }

    // Creation where we know what players are part of this group
    public NFLPlayerManager(NFLPlayer[] players) {
        this.players = new ArrayList<NFLPlayer>();

        for (int i = 0; i < players.length; i++) {
            this.players.add(players[i]);
        }
    }

    // A tool for creating a group with 6 players, who have details that will need to be provided later
    public void createPlayers() {
        this.createPlayers(6);
    }

    // We can also create a specific number of new players.
    public void createPlayers(int numberOfPlayers) {
        for (int i = 0; i < (numberOfPlayers / 2); i++) {
            this.players.add(new OffensivePlayer());
            this.players.add(new DefensivePlayer());
        }
    }

    // Shares the contents of the ArrayList in the form of a list of names, with some text formatting
    @Override
    public String toString() {
        String theString = "";

        // Loop through each player in the ArrayList and add their name, plus the needed punctuation
        for (int i = 0; i < this.players.size(); i++) {
            theString = theString + "\n Player #" + (i + 1) + " \n " + this.players.get(i).toString();
        }

        return theString;
    }

    // Get a specific player, if we know where they're stored at
    public NFLPlayer getPlayer(int index) {
        return this.players.get(index);
    }

    // Set a specific player, if we know where they're stored at
    public void setPlayer(int index, NFLPlayer player) {
        this.players.set(index, player);
    }

    // Remove a specific player, if we know where they're stored at
    public void removePlayer(int index) {
        this.players.remove(index);
    }

    // Add a new player
    public void addPlayer(NFLPlayer player) {
        this.players.add(player);
    }

    // Search for a specific player in the group, return the index if we find it
    public int findPlayer(NFLPlayer target) {
        return this.players.indexOf(target);
    }

    public int getNumberOfPlayers() {
        return this.players.size();
    }

    public ArrayList<NFLPlayer> getPlayers() {
        return this.players;
    }
}
