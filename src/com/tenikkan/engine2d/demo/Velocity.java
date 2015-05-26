package com.tenikkan.engine2d.demo;

import com.tenikkan.engine2d.entity.Component;

public class Velocity extends Component
{
    private float x, y;
    
    public Velocity(float x, float y) 
    {
        this.x = x;
        this.y = y;
    }
    
    public float getVelX() { return x; }
    public float getVelY() { return y; }
    
    private static float round(float i) 
    {
        return (int)(i * 100) / 100f;
    }
    
    public String toString() 
    {
        return "Velocity: {" + round(x) + ", " + round(y) + "};";
    }
}
