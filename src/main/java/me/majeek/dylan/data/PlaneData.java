package me.majeek.dylan.data;

import org.bukkit.util.Vector;

public class PlaneData {
    private float speed;
    private int throttle;
    private Vector direction;

    public PlaneData(float speed, int throttle, Vector direction){
        this.speed = speed;
        this.throttle = throttle;
        this.direction = direction;
    }

    public float getSpeed() {
        return speed;
    }

    public int getThrottle() {
        return throttle;
    }

    public Vector getDirection(){ return direction; }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setThrottle(int throttle) {
        this.throttle = throttle;
    }

    public void setDirection(Vector direction){ this.direction = direction; }
}
