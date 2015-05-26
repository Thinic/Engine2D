package com.tenikkan.engine2d.demo;

import java.util.List;

import com.tenikkan.engine2d.entity.Entity;
import com.tenikkan.engine2d.entity.EntitySystem;

public class MovementSystem extends EntitySystem
{
    public MovementSystem() 
    {
        super(Position.class, Velocity.class);
    }
    
    public void update(Entity e, List<Entity> eToUpdate)
    {
        Position p = e.getComponent(Position.class);
        Velocity v = e.getComponent(Velocity.class);
        
        p.changeX(v.getVelX());
        p.changeY(v.getVelY());
    }
    
}
