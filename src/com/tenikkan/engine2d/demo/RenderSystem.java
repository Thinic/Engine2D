package com.tenikkan.engine2d.demo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import com.tenikkan.engine2d.entity.Entity;
import com.tenikkan.engine2d.entity.EntitySystem;
import com.tenikkan.engine2d.template.Display;

public class RenderSystem extends EntitySystem
{
    private Display display;
    
    public RenderSystem(Display display) 
    {
        super(Position.class);
        
        this.display = display;
    }
    
    public void update(Entity e, List<Entity> eToUpdate)
    {
        Position pos = e.getComponent(Position.class);
        
        Graphics g = display.getGraphics();
        
        g.setColor(Color.GREEN);
        
        int rad = 10;
        int drawX = (int)(pos.getX()) - rad;
        int drawY = (int)(pos.getY()) - rad;
        
        g.fillOval(drawX, drawY, rad * 2, rad * 2);
        
        g.dispose();
    }
}
