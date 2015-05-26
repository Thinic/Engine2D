package com.tenikkan.engine2d.demo;

import com.tenikkan.engine2d.entity.Component;

public class Position extends Component
{
    private float x, y;
    
    public Position(float x, float y) 
    {
        this.x = x;
        this.y = y;
    }
    
    public float getX() { return x; }
    public float getY() { return y; }
    
    public void setX(float x) { this.x = x; }
    public void setY(float y) { this.y = y; }
    
    public void changeX(float dx) { x += dx; }
    public void changeY(float dy) { y += dy; }
    
    private static float round(float i) 
    {
        return (int)(i * 100) / 100f;
    }
    
    public String toString() 
    {
        return "Position: {" + round(x) + ", " + round(y) + "};";
    }
}
