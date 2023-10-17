package soph_part;

import java.util.*;

public class User {
	private String username;
    private String password;
    private Stack<Game> gamesLibrary; //stack library
    private int gameAchievement; //game achievements based on level

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.gamesLibrary = new Stack<>();
        this.gameAchievement = 0;
    }

    // Getters and Setters for User class
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Stack<Game> getGamesLibrary() {
        return gamesLibrary;
    }

    public int getGameAchievement() {
        return gameAchievement;
    }

    // Method to add a game to the user's library
    public void addGameToLibrary(Game game) {
        gamesLibrary.push(game);
    }
    // Method to remove and return the top game from the library
    public Game removeTopGame() {
        if (!gamesLibrary.isEmpty()) {
            return gamesLibrary.pop(); // Pop the top game from the stack
        } else {
            return null; // Stack is empty
        }
    }
}
