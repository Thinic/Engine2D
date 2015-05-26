package com.tenikkan.engine2d.entity;

import java.util.ArrayList;
import java.util.List;

public abstract class EntitySystem
{
    private List<Class<? extends Component>> classes;
    private List<Entity> entities;
    
    @SafeVarargs
    public EntitySystem(Class<? extends Component>... list) 
    {
        classes = new ArrayList<Class<? extends Component>>();
        entities = new ArrayList<Entity>();
        
        for(Class<? extends Component> c : list)
            addRequirement(c);
    }
    
    private void addRequirement(Class<? extends Component> type) 
    {
        classes.add(type);
    }
    
    public void addEntities(List<Entity> ent) 
    {
        for(Entity e : ent) 
        {
            addEntity(e);
        }
    }
    
    public void updateEntity(Entity e) 
    {
        boolean keep = true;
        
        for(Class<? extends Component> type : classes) 
        {
            if(e.getComponent(type) == null) keep = false;
            break;
        }
        
        if(!keep) 
            entities.remove(e);
    }
    
    public void addEntity(Entity e) 
    {
        boolean add = true;
        
        for(Class<? extends Component> type : classes) 
        {
            if(e.getComponent(type) == null) add = false;
            break;
        }
        
        if(add && !entities.contains(e)) 
        {
            entities.add(e);
        }
    }
    
    public void removeEntity(Entity e) 
    {
        entities.remove(e);
    }
    
    public void update() 
    {
        List<Entity> update = getEntitiesToUpdate(entities);
        
        for(Entity e : update) 
            update(e, update);
    }
    
    public abstract void update(Entity e, List<Entity> eToUpdate);
    
    public List<Entity> getEntitiesToUpdate(List<Entity> all) 
    {
        return all;
    }
}
