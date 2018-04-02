/**
 * Program: Final
 * File: .java
 * Summary:
 * Author: Chase Hausman
 * Date: March 24, 2018
 */
public class DefensivePlayer extends NFLPlayer {
    protected int interceptions;

    public DefensivePlayer() {
        this.name = "New Player _" + Math.round(Math.random() * 100);
        this.height = 60;
        this.weight = 200;
        this.position = "Lineman";
        this.firstYear = 2017;
        this.interceptions = 0;
        this.rating = Math.random() * 10;
        this.college = "Homeschooled";
    }

    public DefensivePlayer(String name, int height, int weight, String position, int firstYear,
                     int interceptions, double rating, String college) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.firstYear = firstYear;
        this.interceptions = interceptions;
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
                "\n Interceptions: "+this.getInterceptions() +
                "\n Rating: "+this.getRating() +
                "\n College: "+this.getCollege();
    }

    public int getInterceptions() {
        return this.interceptions;
    }

    public void setInterceptions(int interceptions) {
        this.interceptions = interceptions;
    }

    public void increaseInterceptions(int additional) {
        this.interceptions = this.interceptions + additional;
    }
}
