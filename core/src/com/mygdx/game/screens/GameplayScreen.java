package com.mygdx.game.screens;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.ClickerGame;
import com.mygdx.game.entities.Player;
import com.mygdx.game.ui.IClickCallback;
import com.mygdx.game.ui.PlayerButton;
import com.mygdx.game.ui.PointsCounter;

public class GameplayScreen extends AbstractScreen{
	
	private Player player;
	private PlayerButton playerButton;
	private Button resetScoreButton;
	private PointsCounter pointsCounter;
	
	public GameplayScreen(ClickerGame game){
		super(game);
	}
	
	@Override
	protected void init(){
		initPlayer();
		initPlayerButton();
		initResetButton();
		initPointsCounter();
	}
	
	private void initResetButton() {
		resetScoreButton = new Button(new ButtonStyle());
		resetScoreButton.setWidth(100);
		resetScoreButton.setHeight(200);
		resetScoreButton.setPosition(350, 100);
		resetScoreButton.setDebug(true);
		addActorToStage(resetScoreButton);
		addListenerToResetScoreButton();
	}

	private void initPlayer() {
		player = new Player();
		addActorToStage(player);
	}
	
	private void initPlayerButton() {
		playerButton = new PlayerButton(new IClickCallback() {
			
			@Override
			public void onClick() {
				player.actionsOnClick();
				pointsCounter.addPoint();
			}
		});
		addActorToStage(playerButton);
	}
	
	private void initPointsCounter() {
		pointsCounter = new PointsCounter();
		addActorToStage(pointsCounter);
	}
	
	private void addListenerToResetScoreButton() {
		resetScoreButton.addListener(new ClickListener(){
			@Override
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
				pointsCounter.resetPoint();
				return super.touchDown(event, x, y, pointer, button);
			}
		});
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
		pointsCounter.showPoints();;
		stage.act();
	}
}
