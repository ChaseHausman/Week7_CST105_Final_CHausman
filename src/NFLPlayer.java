/**
 * Program: Final
 * File: NFLPlayer.java
 * Summary: Defines the Player class
 * Author: Chase Hausman
 * Date: March 17, 2018
 */

import java.time.Year;

public abstract class NFLPlayer {
    protected String name;
    protected int height;
    protected int weight;
    protected String position;
    protected int firstYear;
    protected Double rating;
    protected String college;

    public NFLPlayer() {
        this.name = "New Player" + Math.round(Math.random() * 100);
        this.height = 60;
        this.weight = 200;
        this.position = "Quarterback";
        this.firstYear = 2017;
        this.rating = Math.random() * 10;
        this.college = "Homeschooled";
    }

    public NFLPlayer(String name, int height, int weight, String position, int firstYear, double rating, String college) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.position = position;
        this.firstYear = firstYear;
        this.rating = rating;
        this.college = college;
    }

    public String toString() {
        return "Name: "+this.getName() +
        "\n Height: "+this.getHeight() +
        "\n Height Format: "+this.getFormattedHeight() +
        "\n Weight: "+this.getWeight() +
        "\n Position: "+this.getPosition() +
        "\n First Year: "+this.getFirstYear() +
        "\n Years Exp.: "+this.getYearsOfExperience() +
        "\n Rating: "+this.getRating() +
        "\n College: "+this.getCollege();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    // Returns height formatted as feet' inches"
    public String getFormattedHeight() {
        int feet = Math.floorDiv(this.height, 12);
        int inches = this.height % 12;
        return feet+"\' "+inches+"\"";
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getFirstYear() {
        return this.firstYear;
    }

    public void setFirstYear(int firstYear) {
        this.firstYear = firstYear;
    }

    public int getYearsOfExperience() {
        return Year.now().getValue() - this.firstYear;
    }

    public Double getRating() {
        return this.rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getCollege() {
        return this.college;
    }

    public void setCollege(String college) {
        this.college = college;
    }
}
