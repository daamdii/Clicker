package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Player extends Image{
	
	private final static int WIDTH = 77;
	private final static int HEIGHT = 152;
	
	private final static int STARTING_X = 200;
	private final static int STARTING_Y = 500;
	
	private final static int MOVE_AMOUNT_Y = 10;
	private final static float MOVE_ACTION_TIME = 0.30f;
	
	private final static int GROW_AMOUNT_Y = 20;
	private final static float GROW_ACTION_TIME = 0.2f;
	
	public Player(){
		super(new Texture("badlogic.jpg"));
		this.setOrigin(WIDTH/2,HEIGHT/2);
		this.setSize(WIDTH, HEIGHT);
		this.setPosition(STARTING_X, STARTING_Y);
	}

	public void actionsOnClick() {
		movePlayerAction();
		growPlayerAction();
		rotatePlayerAction();
	}
	
	private void movePlayerAction() {
		int moveAmountX = MathUtils.random(-100,100);
		Action moveAction = Actions.sequence(
				Actions.moveBy(moveAmountX, MOVE_AMOUNT_Y, MOVE_ACTION_TIME, Interpolation.circleOut),
				Actions.moveBy(-moveAmountX, -MOVE_AMOUNT_Y, MOVE_ACTION_TIME, Interpolation.circle)
				);
		
		this.addAction(moveAction);
	}	
	
	private void growPlayerAction() {
		int growAmountX = MathUtils.random(-30,100);
		Action growAction = Actions.sequence(
				Actions.sizeBy(growAmountX, GROW_AMOUNT_Y, GROW_ACTION_TIME, Interpolation.circleOut),
				Actions.sizeBy(-growAmountX, -GROW_AMOUNT_Y, GROW_ACTION_TIME, Interpolation.circle)
				);
		this.addAction(growAction);
	}
	
	private void rotatePlayerAction() {
		if(this.getHeight()>170){
			this.addAction(Actions.rotateBy(MathUtils.randomSign()*360, 0.4f));
		}
	}
	
}
