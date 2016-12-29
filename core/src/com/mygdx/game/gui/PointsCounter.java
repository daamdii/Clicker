package com.mygdx.game.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class PointsCounter extends Label {
	private static final int DEFAULT_POINTS_AMOUNT = 0;
	
	private static final int POINTS_COUNTER_POSITION_X = 20;
	private static final int POINTS_COUNTER_POSITION_Y = 650;
	
	private static final String POINT_LABEL_NAME = "Points: ";
	
	private int points;
	
	public PointsCounter(){
		super("", new LabelStyle(new BitmapFont(), Color.WHITE));
		setPositionOfPointsCounter(POINTS_COUNTER_POSITION_X,POINTS_COUNTER_POSITION_Y);
		points = DEFAULT_POINTS_AMOUNT;
	}
		
	public int getPoints() {
		return points;
	}
	
	public void showPoints(){
		this.setText(POINT_LABEL_NAME + Integer.toString(getPoints()));
	}
	
	public void addPoint(){
		points++;
	}
	
	private void setPositionOfPointsCounter(int posX, int posY){
		this.setPosition(posX, posY);
	}
	
	
}
