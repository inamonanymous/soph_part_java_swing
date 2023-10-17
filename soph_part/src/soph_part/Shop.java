package soph_part;
import java.util.*;
public class Shop {
	private ArrayList<Game> gamesLibrary;
	
	public Shop() {
		gamesLibrary = new ArrayList<>();
		defaultGames();
	}
	
	public ArrayList<Game> getShopGamesLibrary(){
		return this.gamesLibrary; 
	}
	
	//given sample games
	private void defaultGames() {
		Game legend_of_zelda = new Game("Legend of Zelda", 2500, 0);
		Game hellblade = new Game("Hellblade", 1500, 0);
		Game castlevania = new Game("Castlevania - Symphony of the night", 700, 0);
		Game mass_effect = new Game("Mass Effect", 2500, 0);
		Game horizon_zero_dawn = new Game("Horizon Zero Dawn", 500, 0);
		Game spiderman = new Game("Spiderman", 2200, 0);
		Game control = new Game("Control", 1300, 0);
		Game hades = new Game("Hades", 800, 0);
		Game hollow_night = new Game("Hollow Night", 1000, 0);
		Game bioshock = new Game("Bioshock", 2800, 0);
		Game story_of_season = new Game("Story of Season", 500, 0);
		Game sea_of_stars = new Game("Sea of Stars", 1099, 0);
		Game half_life = new Game("Half Life", 200, 0);
		
		gamesLibrary.add(legend_of_zelda);
        gamesLibrary.add(hellblade);
        gamesLibrary.add(castlevania);
        gamesLibrary.add(mass_effect);
        gamesLibrary.add(horizon_zero_dawn);
        gamesLibrary.add(spiderman);
        gamesLibrary.add(control);
        gamesLibrary.add(hades);
        gamesLibrary.add(hollow_night);
        gamesLibrary.add(bioshock);
        gamesLibrary.add(story_of_season);
        gamesLibrary.add(sea_of_stars);
        gamesLibrary.add(half_life);
	}
	
}
