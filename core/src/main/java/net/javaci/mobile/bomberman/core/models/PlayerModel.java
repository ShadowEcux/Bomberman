package net.javaci.mobile.bomberman.core.models;

import com.badlogic.gdx.math.Vector2;

public class PlayerModel extends GameObjectModel {
    private float speed = 100f;
    private String playerName;
    private State state = State.STANDING_DOWN;
    private int targetGridX = -1;
    private int targetGridY = -1;

    public int getTargetGridY() {
        return targetGridY;
    }

    public void setTargetGridY(int targetGridY) {
        this.targetGridY = targetGridY;
    }

    public int getTargetGridX() {
        return targetGridX;
    }

    public void setTargetGridX(int targetGridX) {
        this.targetGridX = targetGridX;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPosition(Vector2 position) {
        this.x = position.x;
        this.y = position.y;
    }

    public float getOriginX() {
        return this.x + this.width * 0.5f;
    }

    public float getOriginY() {
        return this.y + this.height * 0.5f;
    }

    public static enum State {
        STANDING_UP, STANDING_DOWN, STANDING_RIGHT, STANDING_LEFT,
        WALKING_UP, WALKING_DOWN, WALKING_RIGHT, WALKING_LEFT,
        STOPPING_UP, STOPPING_DOWN, STOPPING_RIGHT, STOPPING_LEFT
    }
}
