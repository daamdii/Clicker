package com.mygdx.game.screens;

import com.mygdx.game.ClickerGame;
import com.mygdx.game.entities.Player;

public class GameplayScreen extends AbstractScreen{
	private Player player;
	
	public GameplayScreen(ClickerGame game){
		super(game);
	}
	
	@Override
	protected void init(){
		initPlayer();
		addPlayerToStage();
	}
	
	private void initPlayer() {
		player = new Player();
	}
	private void addPlayerToStage(){
		stage.addActor(player);
	}

	@Override
	public void render(float delta){
		super.render(delta);
		update();
		spriteBatch.begin();
		stage.draw();
		spriteBatch.end();
	}

	private void update() {
		stage.act();
	}
}
