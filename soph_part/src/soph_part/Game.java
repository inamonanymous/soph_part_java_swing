package soph_part;

public class Game {
    private String title;
    private double price;
    private int level;

    public Game(String title, double price, int level) {
        this.title = title;
        this.price = price;
        this.level = level;
    }
    
    public Game(String title) {
    	this.title = title;
    	this.price = 0;
    	this.level = 0;
    }

    // Getters for Game class
    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getLevel() {
        return level;
    }
}

