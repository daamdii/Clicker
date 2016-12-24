package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.ClickerGame;
import com.mygdx.game.screens.AbstractScreen;

public class SplashScreen extends AbstractScreen{
	
	private Texture splashImage;
	
	public SplashScreen(ClickerGame game) {
		super(game);
		init();
	}

	private void init() {
		//TODO implement better assets loading when game grows
		splashImage = new Texture("badlogic.jpg");
	}
	
	@Override
	public void render(float delta) {
		super.render(delta);
		spriteBatch.begin();
		
		spriteBatch.draw(splashImage, 0, 0);
		
		spriteBatch.end();
	}
}