package com.mygdx.game.screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.ClickerGame;
import com.mygdx.game.entities.Player;

public class GameplayScreen extends AbstractScreen{
	private Player player;
	private Button playerButton;
	
	public GameplayScreen(ClickerGame game){
		super(game);
	}
	
	@Override
	protected void init(){
		initPlayer();
		initPlayerButton();
	}
	
	private void initPlayerButton() {
		playerButton = new Button(new ButtonStyle());
		playerButton.setWidth(200);
		playerButton.setHeight(200);
		playerButton.setPosition(100, 100);
		playerButton.setDebug(true);
		addListenerToPlayerButton();
		addActorToStage(playerButton);
	}

	private void addListenerToPlayerButton() {
		playerButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				return super.touchDown(event, x, y, pointer, button);
			}
		});
	}

	private void initPlayer() {
		player = new Player();
		addActorToStage(player);
	}
	
	private void addActorToStage(Actor actor){
		stage.addActor(actor);
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
