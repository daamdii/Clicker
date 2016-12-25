package com.mygdx.game.screens;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.ClickerGame;

public class GameplayScreen extends AbstractScreen{
	private Texture gameplayImage;
	
	public GameplayScreen(ClickerGame game){
		super(game);
		init();
	}
	
	private void init(){
		gameplayImage = new Texture("badlogic.jpg");
	}
	
	@Override
	public void render(float delta){
		super.render(delta);
		spriteBatch.begin();
		spriteBatch.draw(gameplayImage,0,0);
		spriteBatch.end();
		
	}
}
