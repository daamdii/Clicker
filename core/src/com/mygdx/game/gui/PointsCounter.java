package com.mygdx.game.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class PointsCounter extends Label {
	
	public static final String GAME_PREFERENCES = "com.mygdx.game.gui.preferences";
	public static final String GAME_SCORE = "com.mygdx.game.gui.preferences.score";
	
	private static final int DEFAULT_POINTS_AMOUNT = 0;
	private static final String DEFAULT_LABEL_NAME = "";
	
	private static final int POINTS_COUNTER_POSITION_X = 20;
	private static final int POINTS_COUNTER_POSITION_Y = 650;
	
	private static final String POINT_LABEL_NAME = "Points: ";
	
	private Preferences preferences;
	
	private int points;
	
	public PointsCounter(){
		super(DEFAULT_LABEL_NAME, new LabelStyle(new BitmapFont(), Color.WHITE));
		points = DEFAULT_POINTS_AMOUNT;
		setPositionOfPointsCounter(POINTS_COUNTER_POSITION_X,POINTS_COUNTER_POSITION_Y);
		initScorePreferences();
		loadScoreFromPreferences();
	}
	
	private void initScorePreferences(){
		preferences = Gdx.app.getPreferences(GAME_PREFERENCES);
	}
	
	private void loadScoreFromPreferences(){
		points = preferences.getInteger(GAME_SCORE);
	}
	
	public int getPoints() {
		return points;
	}
	
	public void showPoints(){
		this.setText(POINT_LABEL_NAME + Integer.toString(getPoints()));
	}
	
	public void addPoint(){
		points++;
		updateScoreInPreferences();
	}
	
	public void resetPoint(){
		points = DEFAULT_POINTS_AMOUNT;
		updateScoreInPreferences();
	}
	
	private void updateScoreInPreferences() {
		preferences.putInteger(GAME_SCORE, points);
		preferences.flush();
	}

	private void setPositionOfPointsCounter(int posX, int posY){
		this.setPosition(posX, posY);
	}
	
	
	
}
