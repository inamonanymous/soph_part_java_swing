package soph_part;

import java.util.*;

import javax.swing.JLabel;

/**
 * 
 */
public class Soph {
	private User user; //initialize the user variable from User class in Soph class

	public Soph() {
		this.user = new User("soph", "soph123"); // Create the user
	}
	
	public User getCurrentUser() {
		return this.user; //return the current user object
	}
	
	
	public static void main(String[] args) {
		Soph soph = new Soph(); //Instance of this class
		
		Shop shop_obj = new Shop(); //Instance of Shop class
		
		User user_obj = soph.getCurrentUser(); // get the user object using the getter method in Soph class
		soph.addGamesToCurrentUserLibrary(user_obj); //call method to add games and pass the user_obj as parameter(line:45) 
        //soph.fetchGamesToGamesFrame(user_obj); //shows the GamesFrame Frame <-remove comment to test //remove comment to show GAMES FRAME
        //sendUserDataToShopFrame(user_obj, shop_obj); //shows the ShopFrameFrame <-remove comment to test  //remove comment to show SHOP FRAME
		sendUserDataToAchievementsFrame(user_obj);  //shows the AchievementsFrame <-remove comment to test  //remove comment to show ACHIEVEMENTS FRAME
	
        
        
	}

	private void fetchGamesToGamesFrame(User user) { //create method for fetching games to GamesFrame
		GamesFrame games_frame_obj = new GamesFrame(user); //create instance of GamesFrame class
		Stack<Game> user_games = user.getGamesLibrary(); //Create new stack variable and pass the value of user_object get library
		
		//send users games data to games frame and set visible
        games_frame_obj.updateGamesInVault(user_games);
        games_frame_obj.setVisible(true);
        
	}
	
	// default games
	private void addGamesToCurrentUserLibrary(User user) {
		// Create some games
		Game rrd_2 = new Game("Read Dead Redemption 2", 29.99, 1);
        Game gta_v = new Game("GTA V", 39.99, 2);
		Game dota_2 = new Game("DOTA 2", 39.99, 1);
				
        // User adds local game
		user.addGameToLibrary(rrd_2);
        user.addGameToLibrary(gta_v);
        user.addGameToLibrary(dota_2);
	}
	
	private static void sendUserDataToShopFrame(User user, Shop shop) {
		ShopFrame shop_frame_obj = new ShopFrame(user, shop); //create instance of ShopFrame Frame
		shop_frame_obj.setVisible(true); //set ShopFrame visible
	}
				
	private static void sendUserDataToAchievementsFrame(User user) {
		AchievementsFrame af = new AchievementsFrame(user); //create instance of AchievementsFrame Frame
		af.setVisible(true); //set AchievementsFrame visible
	} 
	
}
