/**
 * Program: Final
 * File: NFLPlayerTestDriver.java
 * Summary: A "test suite" for the NFLPlayer class
 * Author: Chase Hausman
 * Date: March 17, 2018
 */
public class NFLPlayerTestDriver {
    public static void main(String args[]) {
        // Without arguments, create a new instance, show the results
        System.out.println("Creating offensive without arguments:");
        NFLPlayer player_1 = new OffensivePlayer();
        System.out.println(player_1.toString());

        // Editing all properties, by setting all of them, show results
        System.out.println("\n\n Editing Properties");
        player_1.setCollege("Grand Canyon University");
        player_1.setFirstYear(1949);
        player_1.setHeight(18);
        player_1.setName("Thunder the Antelope");
        player_1.setPosition("Mascot");
        player_1.setRating(12.5);
        player_1.setWeight(250);
        System.out.println(player_1);

        // Creating a player with arguments, show results
        System.out.println("\n\n Creating with arguments");
        NFLPlayer player_2 = new OffensivePlayer("Someone Else", 72, 210, "Something", 1996, 1,
        12, 5.5, "University of American Samoa");
        System.out.println(player_2);
    }
}
