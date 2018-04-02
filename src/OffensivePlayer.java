/**
 * Program: Final
 * File: .java
 * Summary:
 * Author: Chase Hausman
 * Date: March 24, 2018
 */
public class OffensivePlayer extends NFLPlayer {
    protected int touchdowns;
    protected int yards;

    public OffensivePlayer() {
        this.name = "New Player _" + Math.round(Math.random() * 100);
        this.height = 60;
        this.weight = 200;
        this.position = "Quarterback";
        this.firstYear = 2017;
        this.touchdowns = 0;
        this.yards = 0;
        this.rating = Math.random();
        this.college = "Homeschooled";
    }

    public OffensivePlayer(String name, int height, int weight, String position, int firstYear, int touchdowns,
                           int yards, double rating, String college) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.firstYear = firstYear;
        this.touchdowns = touchdowns;
        this.yards = yards;
        this.rating = rating;
        this.college = college;
    }

    @Override
    public String toString() {
        return "Name: "+this.getName() +
                "\n Height: "+this.getHeight() +
                "\n Height Format: "+this.getFormattedHeight() +
                "\n Weight: "+this.getWeight() +
                "\n Position: "+this.getPosition() +
                "\n First Year: "+this.getFirstYear() +
                "\n Years Exp.: "+this.getYearsOfExperience() +
                "\n Touchdowns: "+this.getTouchdowns() +
                "\n Yards: "+this.getYards() +
                "\n Rating: "+this.getRating() +
                "\n College: "+this.getCollege();
    }

    public int getTouchdowns() {
        return this.touchdowns;
    }

    public void setTouchdowns(int touchdowns) {
        this.touchdowns = touchdowns;
    }

    public void increaseTouchdowns(int additional) {
        this.touchdowns = this.touchdowns + additional;
    }

    public int getYards() {
        return this.yards;
    }

    public void setYards(int yards) {
        this.yards = yards;
    }

    public void increaseYards(int additional) {
        this.yards = this.yards + additional;
    }
}
