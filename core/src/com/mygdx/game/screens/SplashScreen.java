package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.mygdx.game.ClickerGame;
import com.mygdx.game.screens.AbstractScreen;

public class SplashScreen extends AbstractScreen{
	
	private Texture splashImage;
	/* When we are passing parameter to task witch will be executed after some time
	   it must be final */
	public SplashScreen(final ClickerGame game) {
		super(game);
		changeSplashScreenToGameplayScreen(game);		
	}
	
	private void changeSplashScreenToGameplayScreen(final ClickerGame game){
			Timer.schedule(new Task() {
			
			@Override
			public void run() {
				game.setScreen(new GameplayScreen(game));
			}
		}, 2);
	}
	
	@Override
	protected void init() {
		//TODO implement better assets loading when game grows
		splashImage = new Texture("splashScreen.png");
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		spriteBatch.begin();
		
		spriteBatch.draw(splashImage,0, 0);
		
		spriteBatch.end();
	}
}
